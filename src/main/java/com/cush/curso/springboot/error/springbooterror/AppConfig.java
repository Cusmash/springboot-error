package com.cush.curso.springboot.error.springbooterror;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cush.curso.springboot.error.springbooterror.models.domain.User;

@Configuration
public class AppConfig {

    @Bean
    public List<User> users(){
        return Arrays.asList(
            new User(1L, "Pepe", "Gonzalez"),
            new User(2L, "Andres", "Mena"),
            new User(3L, "Maria", "Perez"),
            new User(4L, "Josefa", "Ramirez"),
            new User(5L, "Ale", "Gutierrez")
        );
    }
}
