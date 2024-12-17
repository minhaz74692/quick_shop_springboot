package com.mie.quickshop.service.product;

import com.mie.quickshop.dto.product.ProductDto;
import com.mie.quickshop.model.Product;
import com.mie.quickshop.request.product.AddProductRequest;

import java.util.List;

public interface IProductService {
    ProductDto createProduct(AddProductRequest addProductRequest);
    ProductDto getProductById(Long id);
    Product updateProduct(Long id, AddProductRequest updatedProductRequest);
    boolean deleteProductById(Long id);
    List<ProductDto> getAllProducts();
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsByBrand(String brand);
    List<Product> findByCategoryNameAndBrand(String category, String brand);
    List<Product> getProductsByName(String name);
    List<Product> getProductsByBrandAndName(String brand, String name);
    Long countProductsByBrandAndName(String brand, String name);
}
