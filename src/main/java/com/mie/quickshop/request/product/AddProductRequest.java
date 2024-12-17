package com.mie.quickshop.request.product;
import com.mie.quickshop.model.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
    @NotBlank(message = "Name can not be empty")
    private String name;
    private String brand;
    @NotNull(message = "Price is Required")
    @Positive(message = "Price must be positive")
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
