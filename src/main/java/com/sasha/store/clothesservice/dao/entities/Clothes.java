package com.sasha.store.clothesservice.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "_clothes")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Clothes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private TypeClothes typeClothes;

    private Double price;

    @Column(length = 1000 )
    private String description;

    @Column(name = "image_associate")
    private Byte[] image;

    private Boolean isAvailable;

    private Long quantity;

    private Boolean hasDiscount;

    private Double amountDiscount;

    @Enumerated(EnumType.STRING)
    private Size size;

}
