package rikkei_thao.com.social_login.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rikkei_thao.com.social_login.entity.Usuario;
import rikkei_thao.com.social_login.service.UsuarioService;


@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.getByEmail(email).orElseThrow(()-> new UsernameNotFoundException("email no encontrado"));
        return UsuarioPrincipalFactory.build(usuario);
    }
}
