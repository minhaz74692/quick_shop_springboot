package com.mie.quickshop.controller.category;

import com.mie.quickshop.dto.category.CategoryDto;
import com.mie.quickshop.dto.product.ProductDto;
import com.mie.quickshop.model.Category;
import com.mie.quickshop.request.category.AddCategoryRequest;
import com.mie.quickshop.request.product.AddProductRequest;
import com.mie.quickshop.response.ApiResponse;
import com.mie.quickshop.service.category.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

     @GetMapping("/get_category_by_id/{id}")
        public ResponseEntity<ApiResponse> getCategoryById(@PathVariable Long id){
         Category category = categoryService.getCategoryById(id);

            return ResponseEntity.ok(new ApiResponse(
                    "category",
                    categoryService.convertToDto(category)
            ));
        }


}
