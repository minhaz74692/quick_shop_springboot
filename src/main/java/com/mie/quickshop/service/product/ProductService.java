package com.mie.quickshop.service.product;

import com.mie.quickshop.dto.product.ProductDto;
import com.mie.quickshop.exeption.ProductDeleteFailedException;
import com.mie.quickshop.exeption.ProductNotFountException;
import com.mie.quickshop.model.Category;
import com.mie.quickshop.model.Product;
import com.mie.quickshop.repository.product.ProductRepository;
import com.mie.quickshop.request.product.AddProductRequest;
import com.mie.quickshop.service.category.CategoryService;
import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class ProductService implements IProductService{

    private ModelMapper modelMapper;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryService categoryService;

    @Override
    public ProductDto createProduct(AddProductRequest addProductRequest) {

        if(addProductRequest.getName()==null){
            throw new RuntimeException("You haven't added the name MF!!!!");
        }

        Product savedProduct = addProductRequest.createProduct();
        if(addProductRequest.getCategoryId()!=null){
            Category category = categoryService.getCategoryById(addProductRequest.getCategoryId());
            savedProduct.setCategory(category);
        }


        return convertToDto(productRepository.save(savedProduct));
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() ->new ProductNotFountException("Product not found with this id"));
    }

    @Override
    public Void updateProduct(Product product, Long id) {
        return null;
    }

    @Override
    public Void deleteProductById(Long id) {
//        productRepository.deleteProduct(id).orElseThrow(()-> new ProductDeleteFailedException("Product delete failed"));
         productRepository.findById(id).ifPresentOrElse(productRepository ::delete, ()-> {throw new ProductDeleteFailedException("Product delete failed");});
        return null;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream().map(this::convertToDto).toList();
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategoryName(category);
    }

    @Override
    public List<Product> getProductsByBrand(String brand) {

        return productRepository.findByBrand(brand);
    }

    @Override
    public List<Product> findByCategoryNameAndBrand(String category, String brand) {

        return productRepository.findByCategoryNameAndBrand(category, brand);
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return List.of();
    }

    @Override
    public List<Product> getProductsByBrandAndName(String brand, String name) {
        return List.of();
    }

    @Override
    public Long countProductsByBrandAndName(String brand, String name) {
        return 0L;
    }

    public ProductDto convertToDto(Product product){
        return modelMapper.map(product, ProductDto.class);
    }

}
