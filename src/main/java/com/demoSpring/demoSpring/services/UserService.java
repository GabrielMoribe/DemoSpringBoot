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
    public User insert(User user){
        return repositories.save(user);
    }
    public void delete(Long id){
        repositories.deleteById(id);
    }
    public User update(Long id, User obj){
        User entity = repositories.getReferenceById(id);
        updateData(entity, obj);
        return repositories.save(entity);
    }
    private void updateData(User entity, User obj){
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
