package com.ra.pagination.model.service;

import com.ra.pagination.model.dto.request.ProductRequest;
import com.ra.pagination.model.entity.Product;

import java.util.List;

public interface IProductService
{
    List<Product> findAll();

    boolean saveProduct(ProductRequest productRequest);
}
