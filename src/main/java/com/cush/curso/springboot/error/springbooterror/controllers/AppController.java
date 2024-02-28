package com.cush.curso.springboot.error.springbooterror.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cush.curso.springboot.error.springbooterror.exceptions.UserNotFoundException;
import com.cush.curso.springboot.error.springbooterror.models.domain.User;
import com.cush.curso.springboot.error.springbooterror.services.UserService;


@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private UserService service;

    @GetMapping
    public String index(){
        int value = Integer.parseInt("hola");
        return "ok 200";
    }

    @GetMapping("/show/{id}")
    public User show(@PathVariable(name = "id") Long id) {
        return service.findById(id).orElseThrow(() -> new UserNotFoundException("Error el usuaro no existe"));
    }
    
}
