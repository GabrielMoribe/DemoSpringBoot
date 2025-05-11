package com.demoSpring.demoSpring.services;

import com.demoSpring.demoSpring.model.Category;
import com.demoSpring.demoSpring.repository.CategoryRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepositories repositories;

    public List<Category> findAll(){
        return repositories.findAll();
    }
    public Category findById(Long id){
        Optional<Category> obj = repositories.findById(id);
        return obj.get();
    }
}