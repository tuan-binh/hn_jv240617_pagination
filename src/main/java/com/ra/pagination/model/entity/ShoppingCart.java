package com.ra.pagination.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer quantity;


}
