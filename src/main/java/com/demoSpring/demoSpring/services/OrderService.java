package com.demoSpring.demoSpring.services;

import com.demoSpring.demoSpring.model.Order;
import com.demoSpring.demoSpring.repository.OrderRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepositories repositories;

    public List<Order> findAll(){
        return repositories.findAll();
    }
    public Order findById(Long id){
        Optional<Order> obj = repositories.findById(id);
        return obj.get();
    }
}
