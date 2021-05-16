package com.rams.backend.security;


import com.rams.backend.entities.Usuario;
import com.rams.backend.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserDeServiceImpl implements UserDetailsService {
    @Autowired
    UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.getByEmail(email).orElseThrow(()-> new UsernameNotFoundException("email no encontrado"));
        return UsuarioPrincipalFactory.build(usuario);
    }
}
