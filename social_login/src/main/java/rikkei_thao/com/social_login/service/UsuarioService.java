package rikkei_thao.com.social_login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rikkei_thao.com.social_login.entity.Usuario;
import rikkei_thao.com.social_login.repository.UsuarioRepository;

import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Optional<Usuario> getByEmail(String email){
        return usuarioRepository.findByEmail(email);
    }

    public boolean existsEmail(String email){
        return usuarioRepository.existsByEmail(email);
    }

    public Usuario save(Usuario usuario){
        return usuarioRepository.save(usuario);
    }
}
