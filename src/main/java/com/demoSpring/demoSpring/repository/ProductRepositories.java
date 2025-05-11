package com.demoSpring.demoSpring.repository;

import com.demoSpring.demoSpring.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepositories extends JpaRepository<Product,Long> {
}
