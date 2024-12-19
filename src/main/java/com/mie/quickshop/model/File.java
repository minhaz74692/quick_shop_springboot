package com.mie.quickshop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Blob;
import java.util.UUID;

@Getter
@Setter
@Entity(name = "Image")
@Table
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class File {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    private  String fileName;
    private String filaType;
    @JsonIgnore
    @Lob
    private Blob myFile;
    private String filePath;
    private  String downloadUrl;
    private Long size;

    @ManyToOne //defined the relation with product
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private Product product;
}
