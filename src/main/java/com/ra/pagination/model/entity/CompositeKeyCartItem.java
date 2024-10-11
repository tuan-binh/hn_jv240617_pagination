package com.ra.pagination.model.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CompositeKeyCartItem implements Serializable
{
    private Long userId;
    private Long productId;

    public CompositeKeyCartItem()
    {
    }

    public CompositeKeyCartItem(Long userId, Long productId)
    {
        this.userId = userId;
        this.productId = productId;
    }

    public Long getUserId()
    {
        return userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getProductId()
    {
        return productId;
    }

    public void setProductId(Long productId)
    {
        this.productId = productId;
    }
}
