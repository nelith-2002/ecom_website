package com.nelith.ecome_website.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private String brand;
    private BigDecimal price;
    private String category;

//    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "dd-mm-yyyy")
    private LocalDate releaseDate;
    private Boolean available;
    private Integer quantity;

    private String imageName;
    private String imageType;
    @Lob
    private byte[] imageDate;


}
