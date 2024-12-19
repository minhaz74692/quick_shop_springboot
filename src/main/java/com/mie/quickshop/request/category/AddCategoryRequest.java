package com.mie.quickshop.request.category;

import com.mie.quickshop.model.Category;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddCategoryRequest {
    private String name;
    private String description;


    public Category createCategory(){

        return Category.builder()
                .name(this.name)
                .description(this.description)
                .build();

    }
}
