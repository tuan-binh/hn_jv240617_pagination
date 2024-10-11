package com.ra.pagination.model.dto.request;

import org.springframework.lang.NonNull;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class ProductRequest
{
    @NotBlank(message = "tên không được để trống")
    private String name;
    private String description;
    @Min(value = 1,message = "giá phải lớn hơn 0")
    private Double price;
    private MultipartFile image;
    @Min(value = 1,message = "tồn kho phải lớn hơn 0")
    private Integer stock;

    public ProductRequest()
    {
    }

    public ProductRequest(String name, String description, Double price, MultipartFile image, Integer stock)
    {
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.stock = stock;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Double getPrice()
    {
        return price;
    }

    public void setPrice(Double price)
    {
        this.price = price;
    }

    public MultipartFile getImage()
    {
        return image;
    }

    public void setImage(MultipartFile image)
    {
        this.image = image;
    }

    public Integer getStock()
    {
        return stock;
    }

    public void setStock(Integer stock)
    {
        this.stock = stock;
    }
}
