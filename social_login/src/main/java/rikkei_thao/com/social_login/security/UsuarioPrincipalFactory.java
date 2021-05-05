package rikkei_thao.com.social_login.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import rikkei_thao.com.social_login.entity.Usuario;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioPrincipalFactory {

    public static UsuarioPrincipal build(Usuario usuario){
        List<GrantedAuthority> authorities =
                usuario.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol.getRolNombre().name())).collect(Collectors.toList());
        return new UsuarioPrincipal(usuario.getEmail(), usuario.getPassword(), authorities);
    }
}
