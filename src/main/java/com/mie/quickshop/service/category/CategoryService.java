package com.mie.quickshop.service.category;

import com.mie.quickshop.dto.category.CategoryDto;
import com.mie.quickshop.dto.product.ProductDto;
import com.mie.quickshop.exception.CategoryNotFoundException;
import com.mie.quickshop.model.Category;
import com.mie.quickshop.model.Product;
import com.mie.quickshop.repository.category.CategoryRepository;
import com.mie.quickshop.request.category.AddCategoryRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoryService implements ICategoryService{
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
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

    @Override
    public CategoryDto createCategory(AddCategoryRequest addCategoryRequest) {
        Category newCategory = addCategoryRequest.createCategory();

        return convertToDto(categoryRepository.save(newCategory));
    }

    public CategoryDto convertToDto(Category category){
        return modelMapper.map(category, CategoryDto.class);
    }
}
