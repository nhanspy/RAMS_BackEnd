package com.rams.backend.services;

import com.rams.backend.entities.role_user.ERole;
import com.rams.backend.entities.role_user.Role;
import com.rams.backend.entities.role_user.User;
import com.rams.backend.repositories.RoleRepository;
import com.rams.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public User get(long id) {
        return repository.findById(id).get();
    }

    public void delete(long id) {
        repository.deleteById(id);
    }

    public boolean existsEmail(String email){
        return repository.existsByEmail(email);
    }

    public Optional<User> getByEmail(String email){
        return repository.findByEmail(email);
    }

    public User saveUser(String email, String password){
        User user1 = new User();
        // role
        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName(ERole.ROLE_USER).get();
        roles.add(userRole);
        user1.setRoles(roles);
        user1.setEmail(email);
        user1.setUsername(email);
        user1.setPassword(passwordEncoder.encode(password));
        return repository.save(user1);
    }

    public List<User> getAll() {
        return repository.findAll();
    }

    public void save(User user) {
        repository.save(user);
    }
}
