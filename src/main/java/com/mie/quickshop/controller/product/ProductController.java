package com.mie.quickshop.controller.product;

import com.mie.quickshop.dto.product.ProductDto;
import com.mie.quickshop.exception.global.ResourceNotFoundException;
import com.mie.quickshop.model.Product;
import com.mie.quickshop.request.product.AddProductRequest;
import com.mie.quickshop.response.ApiResponse;
import com.mie.quickshop.service.product.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/product")
@RequiredArgsConstructor
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all-products")
    public ResponseEntity<ApiResponse> getAllProduct(){
        List<ProductDto> all_products = productService.getAllProducts();
            return ResponseEntity.ok(new ApiResponse(
                    "all-product",
                    all_products
            ));
    }

    @GetMapping("/all-products-new")
    public ResponseEntity<ApiResponse> getAllProductNew(){
        List<Product> all_products = productService.getAllProductsNew();
            return ResponseEntity.ok(new ApiResponse(
                    "all-product",
                    all_products
            ));
    }

    @GetMapping("/all-products/{id}")
    public ResponseEntity<ApiResponse> getProductById(@PathVariable Long id){
        ProductDto product = productService.getProductById(id);
            return ResponseEntity.ok(new ApiResponse(
                    "product by id",
                    product
            ));
    }

    @GetMapping("/products/{name}")
    public ResponseEntity<ApiResponse> getProductByName(@PathVariable String name){
        List<ProductDto> products = productService.getProductsByName(name);
            return ResponseEntity.ok(new ApiResponse(
                    "product by id",
                    products
            ));
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createProduct( @Valid @RequestBody AddProductRequest addProductRequest){
      ProductDto product = productService.createProduct(addProductRequest);
        return ResponseEntity.ok(new ApiResponse(
                    "new product",
                    product
            ));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable Long id) {
      productService.deleteProductById(id);
                return ResponseEntity.ok(new ApiResponse(
                        "product-deleted",
                        "Product Deleted Successfully"
                ));
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<ApiResponse> updateProduct(
            @PathVariable Long id,
            @Valid @RequestBody AddProductRequest updateProductRequest){
                Product updatedProduct = productService.updateProduct(id, updateProductRequest);
                return ResponseEntity.ok(new ApiResponse(
                        "product-updated",
                        updatedProduct
                ));
    }
}
