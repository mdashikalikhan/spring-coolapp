package com.app.springcoolapp.model;

import lombok.*;

import java.math.BigDecimal;


@AllArgsConstructor
@Getter
@Setter
@ToString
public class Product {
    private Long productId;
    private String name;
    private double price;
}
