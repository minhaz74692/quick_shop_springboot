package com.mie.quickshop.service.category;

import com.mie.quickshop.dto.category.CategoryDto;
import com.mie.quickshop.model.Category;
import com.mie.quickshop.request.category.AddCategoryRequest;

import java.util.List;

public interface ICategoryService {
    Category getCategoryById(Long id);
    Category getCategoryByName(String name);
//    List<Category> allCategories();
    CategoryDto createCategory(AddCategoryRequest addCategoryRequest);

}
