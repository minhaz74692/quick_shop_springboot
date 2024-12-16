package com.mie.quickshop.request.product;
import com.mie.quickshop.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddProductRequest {
    private Long id;
    private String name;
    private String brand;
    private BigDecimal price;
    private int inventory;
    private  String description;
    private Long categoryId;

    public Product createProduct(){
        return Product.builder()
                .name(this.name)
                .description(this.description)
                .price(this.price)
                .brand(this.brand)
                .inventory(this.inventory)
                .build();

    }

}
