package com.askrindo.handson;

import com.askrindo.handson.model.entity.Role;
import com.askrindo.handson.model.entity.User;
import com.askrindo.handson.service.UsersService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class HandsOnApplication {

    public static void main(String[] args) {
        SpringApplication.run(HandsOnApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UsersService userService) {
        return args -> {
//            userService.saveRole(new Role(null,"ROLE_USER"));
//            userService.saveRole(new Role(null,"ROLE_ADMIN"));
//            userService.saveRole(new Role(null,"ROLE_MANAGER"));
//            userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));
//
//            userService.saveUser(new User(null,"Reynaldi Akbar M","abay","password12","Jl. Spoor Dalam IV","3201223336789228","172135223351325", new ArrayList<>()));
//
//            userService.addRoleToUser("abay", "ROLE_MANAGER");
//            userService.addRoleToUser("abay", "ROLE_SUPER_ADMIN");
//            userService.addRoleToUser("abay", "ROLE_ADMIN");
//            userService.addRoleToUser("abay", "ROLE_USER");
        };
    }

}
