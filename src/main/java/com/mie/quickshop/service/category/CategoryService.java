package com.mie.quickshop.service.category;

import com.mie.quickshop.exeption.CategoryNotFoundException;
import com.mie.quickshop.model.Category;
import com.mie.quickshop.repository.category.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoryService implements ICategoryService{
    final CategoryRepository categoryRepository;

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(()->new CategoryNotFoundException("Category Not Found for Id"+id));
    }

    @Override
    public Category getCategoryByName(String name) {
        return Optional.ofNullable(categoryRepository.findByName(name)).orElseThrow(()-> new CategoryNotFoundException("category not found"));
    }

//    @Override
//    public List<Category> allCategories() {
//        return categoryRepository.findAll();
//    }

//    @Override
//    public Category createCategory(AddCategoryRequest addCategoryRequest) {
//        Category newCategory = addCategoryRequest.createCategory();
//        return categoryRepository.save(newCategory);
//    }
}
