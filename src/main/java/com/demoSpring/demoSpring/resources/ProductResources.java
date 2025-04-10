package com.demoSpring.demoSpring.resources;

import com.demoSpring.demoSpring.entidades.Product;
import com.demoSpring.demoSpring.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // INFORMA AO SPRING QUE ESTA CLASSE É UM CONTROLADOR REST
@RequestMapping("/products") // TODAS AS REQUISICOES "/Resources" SAO TRATADAS POR ESTA CLASSE
public class ProductResources {

    @Autowired // INJECAO "AUTOMATICA"
    private ProductService service;


    // ENDPOINTS REST
    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        List<Product> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        Product obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
