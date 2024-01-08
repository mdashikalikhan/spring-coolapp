package com.app.springcoolapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="products")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Products {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    @Column(name = "product_name")
    private String name;

    @NonNull
    @Column(name = "product_description")
    private String description;
}
