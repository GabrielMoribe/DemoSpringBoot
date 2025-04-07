package com.demoSpring.demoSpring.resources;

import com.demoSpring.demoSpring.entidades.Order;
import com.demoSpring.demoSpring.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController // INFORMA AO SPRING QUE ESTA CLASSE É UM CONTROLADOR REST
@RequestMapping("/orders") // TODAS AS REQUISICOES "/order" SAO TRATADAS POR ESTA CLASSE
public class OrderResources {

    @Autowired // INJECAO "AUTOMATICA"
    private OrderService service;


    // ENDPOINTS REST
    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        List<Order> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id){
        Order obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
