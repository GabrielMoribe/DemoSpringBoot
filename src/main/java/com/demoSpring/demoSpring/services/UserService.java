package com.demoSpring.demoSpring.services;

import com.demoSpring.demoSpring.entidades.User;
import com.demoSpring.demoSpring.repositorios.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

// INJECAO DE DEPENDENCIA
    @Autowired
    private UserRepositories repositories;

    public List<User> findAll(){
        return repositories.findAll();
    }
    public User findById(Long id){
        Optional<User> obj = repositories.findById(id);
        return obj.get();
    }
}
