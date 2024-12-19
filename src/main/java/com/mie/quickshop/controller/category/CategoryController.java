package com.mie.quickshop.controller.category;

import com.mie.quickshop.dto.category.CategoryDto;
import com.mie.quickshop.dto.product.ProductDto;
import com.mie.quickshop.request.category.AddCategoryRequest;
import com.mie.quickshop.request.product.AddProductRequest;
import com.mie.quickshop.response.ApiResponse;
import com.mie.quickshop.service.category.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.prefix}/category")
@RequiredArgsConstructor
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createProduct(@Valid @RequestBody AddCategoryRequest addCategoryRequest){
        CategoryDto category = categoryService.createCategory(addCategoryRequest);
        return ResponseEntity.ok(new ApiResponse(
                "new category",
                category
        ));
    }


}
