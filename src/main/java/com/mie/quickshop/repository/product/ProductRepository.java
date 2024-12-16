package com.mie.quickshop.repository.product;


import com.mie.quickshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategoryName(String category);

    List<Product> findByBrand(String brand);

//    @Query("SELECT p FROM Product p WHERE p.category.name = :categoryName AND p.brand = :brand")
    List<Product> findByCategoryNameAndBrand(String categoryName, String brand);

}
