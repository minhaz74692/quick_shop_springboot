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

//        return ResponseEntity.ok().body(new MyApiResponse("hh", "sghsxhxs"));
        List<ProductDto> all_products = productService.getAllProducts();

        try {
            return ResponseEntity.ok(new ApiResponse(
                    "all-product",
                    all_products
            ));
//            return  ResponseEntity.ok("all_Okay :"+ all_products.toString());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse("server-error", null));
//            return  ResponseEntity.ok("all_Not_Okay");
            }

    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createProduct(@RequestBody AddProductRequest addProductRequest){
        try {
            ProductDto product = productService.createProduct(addProductRequest);
            return ResponseEntity.ok(new ApiResponse(
                    "new product",
                    product
            ));
        }catch (Exception e){

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse("server-error", null));        }

    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable Long id) {
        try {
            boolean isDeleted = productService.deleteProductById(id);
            if (isDeleted) {
                return ResponseEntity.ok(new ApiResponse(
                        "product-deleted",
                        "Product Deleted Successfully"
                ));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(
                        "product-not-found",
                        null
                ));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(
                    "server-error",
                    null
            ));
        }
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<ApiResponse> updateProduct(
            @PathVariable Long id,

            @Valid @RequestBody AddProductRequest updateProductRequest){
        try {
//            ProductDto product = productService.createProduct(addProductRequest);
//            return ResponseEntity.ok(new ApiResponse(
//                    "new product",
//                    product
//            ));
//        }catch (Exception e){
            try {
                Product updatedProduct = productService.updateProduct(id, updateProductRequest);
                return ResponseEntity.ok(new ApiResponse(
                        "product-updated",
                        updatedProduct
                ));
            } catch (ResourceNotFoundException e) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(
                        e.getMessage(),
                        null
                ));
            } catch (IllegalArgumentException e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(
                        e.getMessage(),
                        null
                ));
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(
                        "server-error",
                        null
                ));
            }

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(
                    "server-error",
                    null
            ));
        }

    }



}
