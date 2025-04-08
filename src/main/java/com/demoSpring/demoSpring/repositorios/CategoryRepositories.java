package com.demoSpring.demoSpring.repositorios;

import com.demoSpring.demoSpring.entidades.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepositories extends JpaRepository<Category,Long> {
}
