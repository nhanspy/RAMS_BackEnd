package com.rams.backend;

import com.rams.backend.entities.User;
import com.rams.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);

    }

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Khi chương trình chạy
        // Insert vào csdl một user.
        User user = new User();
        user.setUsername("nhan");
        user.setPassword(passwordEncoder.encode("nhan"));
        userRepository.save(user);
        System.out.println(user);
    }

}

