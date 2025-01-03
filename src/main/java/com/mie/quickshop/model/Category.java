package com.mie.quickshop.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import  java.util.List;

@Getter
@Setter
@Entity(name = "Category")
@Table
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column( // This annotation is for handle string length
            columnDefinition = "TEXT"
    )
    private String description;

    @OneToMany(mappedBy = "category")
    @JsonBackReference
    private List<Product> products;
}