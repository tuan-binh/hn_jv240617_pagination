package com.ra.pagination.model.dao;

import com.ra.pagination.model.entity.Product;

import java.util.List;

public interface IProductDao
{

    List<Product> findAll();

    boolean saveProduct(Product product);

}
