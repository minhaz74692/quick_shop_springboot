package com.mie.quickshop.service.category;

import com.mie.quickshop.model.Category;

import java.util.List;

public interface ICategoryService {
    Category getCategoryById(Long id);
    Category getCategoryByName(String name);
//    List<Category> allCategories();
//    Category createCategory(AddCategoryRequest addCategoryRequest);

}
