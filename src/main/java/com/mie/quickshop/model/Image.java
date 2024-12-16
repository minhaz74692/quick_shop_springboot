package com.mie.quickshop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ManyToAny;

import java.sql.Blob;

@Getter
@Setter
@Entity(name = "Image")
@Table
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Image {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY) // Define as Primary Key
    private Long id;
    private  String fileName;
    private String filaType;
    private Blob image;
    private  String downloadUrl;

    @ManyToOne //defined the relation with product
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private Product product;
}
