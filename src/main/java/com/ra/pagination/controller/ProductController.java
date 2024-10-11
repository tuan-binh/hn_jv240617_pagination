package com.ra.pagination.controller;


import com.ra.pagination.model.dto.request.ProductRequest;
import com.ra.pagination.model.entity.Product;
import com.ra.pagination.model.service.IProductService;
import com.ra.pagination.model.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductController
{
    @Autowired
    private IProductService productService;

    // chức năng hiển thị danh sách sản phẩm
    @GetMapping
    public String products(Model model)
    {
        model.addAttribute("products", productService.findAll());
        return "products";
    }

    // định nghĩa đường dẫn chuyển sang view add
    @GetMapping("/add")
    public String viewAdd(Model model)
    {
        model.addAttribute("productRequest", new ProductRequest());
        return "add_product";
    }

    @PostMapping("/add")
    public String addProduct(
            @Valid @ModelAttribute("productRequest") ProductRequest productRequest,
            BindingResult result,
            Model model
    )
    {
        if (result.hasErrors())
        {
            model.addAttribute("productRequest", productRequest);
            return "add_product";
        }
        if (productService.saveProduct(productRequest))
        {
            return "redirect:/products";
        }
        ;
        return "redirect:/products/add";
    }
}
