package com.demoSpring.demoSpring.services;

import com.demoSpring.demoSpring.entidades.Product;
import com.demoSpring.demoSpring.repositorios.ProductRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    // INJECAO DE DEPENDENCIA
    @Autowired
    private ProductRepositories repositories;

    public List<Product> findAll(){
        return repositories.findAll();
    }
    public Product findById(Long id){
        Optional<Product> obj = repositories.findById(id);
        return obj.get();
    }
}
