package com.cush.curso.springboot.error.springbooterror.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cush.curso.springboot.error.springbooterror.models.domain.User;

@Service
public class UserServiceImpl implements UserService{

    private List<User> users;

    public UserServiceImpl(List<User> users) {
        this.users = users;
    }

    @Override
    public List<User> findAll() {
        return this.users;
    }

    @Override
    public Optional<User> findById(Long id) {
        // User user = null;
        // for (User u : users) {
        //     if(u.getId().equals(id)){
        //         user = u;
        //         break;
        //     }
        // }

        return users.stream()
        .filter(usr -> usr.getId().equals(id)).findFirst();
    }

}
