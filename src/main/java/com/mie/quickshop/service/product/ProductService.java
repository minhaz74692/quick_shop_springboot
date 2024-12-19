package com.mie.quickshop.service.product;

import com.mie.quickshop.dto.product.ProductDto;
import com.mie.quickshop.exception.ProductDeleteFailedException;
import com.mie.quickshop.exception.ProductNotFountException;
import com.mie.quickshop.exception.global.ResourceNotFoundException;
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
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryService categoryService;



    @Override
    public ProductDto createProduct(AddProductRequest addProductRequest) {


        Product savedProduct = addProductRequest.createProduct();
        if(addProductRequest.getCategoryId()!=null){
            Category category = categoryService.getCategoryById(addProductRequest.getCategoryId());
            savedProduct.setCategory(category);
        }


        return convertToDto(productRepository.save(savedProduct));
    }

    @Override
    public ProductDto getProductById(Long id) {
        return convertToDto( productRepository.findById(id).orElseThrow(() ->new ProductNotFountException("Product not found with this id")));
    }

//    public Void updateProduct(Product product, Long id) {
//        return null;
//    }
    @Override
    public Product updateProduct(Long id, AddProductRequest updatedProductRequest) {
        // Find the product by ID
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with ID: " + id));

        System.out.println("Hello from update product"+ id);
        System.out.println("Hello from update product"+ updatedProductRequest.getName());


        if (updatedProductRequest.getName() != null) {
            existingProduct.setName(updatedProductRequest.getName());
        }
        if (updatedProductRequest.getBrand() != null) {
            existingProduct.setBrand(updatedProductRequest.getBrand());
        }
        if (updatedProductRequest.getPrice() != null) {
            existingProduct.setPrice(updatedProductRequest.getPrice());
        }
        if (updatedProductRequest.getInventory() != 0) {
            existingProduct.setInventory(updatedProductRequest.getInventory());
        }
        if (updatedProductRequest.getDescription() != null) {
            existingProduct.setDescription(updatedProductRequest.getDescription());
        }

        return productRepository.save(existingProduct);

    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.findById(id).ifPresentOrElse(productRepository ::delete, ()-> {throw new ProductDeleteFailedException("Product delete failed");});
        return;
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
    public List<ProductDto> getProductsByName(String name) {

        return productRepository.findAllByName(name).stream().map(this::convertToDto).toList();
//        return List.of();
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
