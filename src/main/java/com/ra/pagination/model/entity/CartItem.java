package com.ra.pagination.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "cart_item")
public class CartItem
{

    @EmbeddedId
    private CompositeKeyCartItem compositeKeyCartItem;

    @MapsId("userId")
    @ManyToOne
    private Users users;

    @MapsId("productId")
    @ManyToOne
    private Product product;

    private int quantity;
}
