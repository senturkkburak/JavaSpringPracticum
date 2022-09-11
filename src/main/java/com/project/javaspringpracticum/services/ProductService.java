package com.project.javaspringpracticum.services;
import com.project.javaspringpracticum.entities.Product;
import com.project.javaspringpracticum.repository.ProductRepository;
import com.project.javaspringpracticum.requests.ProductCreateRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductService {

    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product createOneProduct(ProductCreateRequest newProduct) {
        Product toSave = new Product();
        toSave.setId(newProduct.getId());
        toSave.setName(newProduct.getName());
        toSave.setPrice(newProduct.getPrice());
        toSave.setExpireDate(newProduct.getExpireDate());

        return productRepository.save(toSave);
    }

    public Product getOneProduct(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }

    public List<Product> getExpired() {

        return productRepository.findAllByExpireDateBefore(new Date());
    }

    public List<Product> getNotExpired() {
        return productRepository.findAllByExpireDateAfterOrExpireDateIsNull(new Date());
    }
}
