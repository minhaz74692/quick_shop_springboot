package com.mie.quickshop.repository.product;


import com.mie.quickshop.dto.product.ProductDto;
import com.mie.quickshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByName(String name);

    List<Product> findByCategoryName(String category);

    List<Product> findByBrand(String brand);

//    @Query("SELECT p FROM Product p WHERE p.category.name = :categoryName AND p.brand = :brand")
    List<Product> findByCategoryNameAndBrand(String categoryName, String brand);

}
