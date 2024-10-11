package com.ra.pagination.model.service.impl;

import com.ra.pagination.model.dao.IProductDao;
import com.ra.pagination.model.dto.request.ProductRequest;
import com.ra.pagination.model.entity.Product;
import com.ra.pagination.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ProductService implements IProductService
{

    @Autowired
    private IProductDao productDao;
    @Autowired
    private UploadFile uploadFile;

    @Override
    public List<Product> findAll()
    {
        return productDao.findAll();
    }

    @Override
    public boolean saveProduct(ProductRequest productRequest)
    {
        String img = null;
        if(productRequest.getImage() != null && !productRequest.getImage().isEmpty()) {
            img = uploadFile.uploadFileService(productRequest.getImage());
        }
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setImage(img);
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        product.setStock(productRequest.getStock());
        product.setStatus(true);
        return productDao.saveProduct(product);
    }
}
