package com.rams.backend.controllers;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.rams.backend.dto.TokenDto;
import com.rams.backend.entities.Rol;
import com.rams.backend.entities.Usuario;
import com.rams.backend.enums.RolNombre;
import com.rams.backend.security.jwt.JwtUtils;
import com.rams.backend.services.RolService;
import com.rams.backend.services.UserService;
import com.rams.backend.services.UsuarioService;
import com.rams.backend.entities.role_user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/oauth")
@CrossOrigin
public class OauthController {

    @Value("${google.clientId}")
    String googleClientId;

    @Value("${secretPsw}")
    String secretPsw;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    RolService rolService;

    @Autowired
    UserService userService;

    @PostMapping("/google")
    public ResponseEntity<TokenDto> google(@RequestBody TokenDto tokenDto) throws IOException {
        final NetHttpTransport transport = new NetHttpTransport();
        final JacksonFactory jacksonFactory = JacksonFactory.getDefaultInstance();
        GoogleIdTokenVerifier.Builder verifier =
                new GoogleIdTokenVerifier.Builder(transport, jacksonFactory)
                        .setAudience(Collections.singletonList(googleClientId));
        final GoogleIdToken googleIdToken = GoogleIdToken.parse(verifier.getJsonFactory(), tokenDto.getValue());
        final GoogleIdToken.Payload payload = googleIdToken.getPayload();
        Usuario usuario = new Usuario();
        User user1 = new User();
        // bug
        if (userService.existsEmail(payload.getEmail())) {
            System.out.println(payload.toString());
            user1 = userService.getByEmail(payload.getEmail()).get();
        }
        else {
            System.out.println(payload.toString());
            user1 = userService.saveUser(payload.getEmail(), secretPsw);
        }
        // end bug
        TokenDto tokenRes = loginGoogle(user1);
        return new ResponseEntity(tokenRes, HttpStatus.OK);
    }

    @PostMapping("/facebook")
    public ResponseEntity<TokenDto> facebook(@RequestBody TokenDto tokenDto) throws IOException {
        Facebook facebook = new FacebookTemplate(tokenDto.getValue());
        final String [] fields = {"email", "picture"};
        User user = facebook.fetchObject("me", User.class, fields);
        Usuario usuario = new Usuario();
        if(usuarioService.existsEmail(user.getEmail()))
            usuario = usuarioService.getByEmail(user.getEmail()).get();
        else
            usuario = saveUsuario(user.getEmail());
        TokenDto tokenRes = login(usuario);

        return new ResponseEntity(tokenRes, HttpStatus.OK);
    }

    private TokenDto loginGoogle(com.rams.backend.entities.role_user.User user){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), secretPsw)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        TokenDto tokenDto = new TokenDto();
        tokenDto.setValue(jwt);
        return tokenDto;
    }

    private TokenDto login(Usuario usuario){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(usuario.getEmail(), secretPsw)
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        TokenDto tokenDto = new TokenDto();
        tokenDto.setValue(jwt);
        return tokenDto;
    }

    private Usuario saveUsuario(String email){
        Usuario usuario = new Usuario(email, passwordEncoder.encode(secretPsw));
        Rol rolUser = rolService.getByRolNombre(RolNombre.ROLE_USER).get();
        Set<Rol> roles = new HashSet<>();
        roles.add(rolUser);
        usuario.setRoles(roles);
        return usuarioService.save(usuario);
    }
}
