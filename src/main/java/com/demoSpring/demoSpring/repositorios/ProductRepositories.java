package com.demoSpring.demoSpring.repositorios;

import com.demoSpring.demoSpring.entidades.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepositories extends JpaRepository<Product,Long> {
}
