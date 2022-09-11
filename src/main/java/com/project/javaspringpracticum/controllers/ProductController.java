package com.project.javaspringpracticum.controllers;
import com.project.javaspringpracticum.entities.Product;
import com.project.javaspringpracticum.entities.User;
import com.project.javaspringpracticum.requests.ProductCreateRequest;
import com.project.javaspringpracticum.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    @PostMapping
    public Product createOneProduct(@RequestBody ProductCreateRequest newProduct){
        return productService.createOneProduct(newProduct);
    }
    @GetMapping("/{productId}")
    public Product getOneUser(@PathVariable Long productId){
        return productService.getOneProduct(productId);
    }

    @GetMapping("/expired")
    public List<Product> getExpired(){
        return productService.getExpired();
    }
    @GetMapping("/notexpired")
    public List<Product>getNotExpired(){
        return productService.getNotExpired();
    }
}
