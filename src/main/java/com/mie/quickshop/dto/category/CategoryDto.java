package com.mie.quickshop.dto.category;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mie.quickshop.model.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
    private Long id;
    private String name;
    private  String description;

//    @JsonIgnore // You can ignore below returns just by annotate with this annotation
    private List<Product> products;
}
