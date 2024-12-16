package com.mie.quickshop.repository.category;

import com.mie.quickshop.model.Category;
import com.mie.quickshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long>{
    Category findByName(String name);
}
