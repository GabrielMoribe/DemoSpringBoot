package com.demoSpring.demoSpring.resources;

import com.demoSpring.demoSpring.entidades.Category;
import com.demoSpring.demoSpring.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // INFORMA AO SPRING QUE ESTA CLASSE É UM CONTROLADOR REST
@RequestMapping("/categories") // TODAS AS REQUISICOES "/Category" SAO TRATADAS POR ESTA CLASSE
public class CategoryResources {

    @Autowired // INJECAO "AUTOMATICA"
    private CategoryService service;


    // ENDPOINTS REST
    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        Category obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}