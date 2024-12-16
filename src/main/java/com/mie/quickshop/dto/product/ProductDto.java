package com.mie.quickshop.dto.product;

import com.mie.quickshop.model.Category;
import com.mie.quickshop.model.Image;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private String brand;
    private BigDecimal price;
    private int inventory;
    private  String description;
    private Category category;
    private List<Image> images;
}
