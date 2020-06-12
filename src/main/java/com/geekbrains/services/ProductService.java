package com.geekbrains.services;

import com.geekbrains.entities.Product;
import com.geekbrains.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;


    @Autowired
    public void setProductRepository(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product findById(int id){
        return productRepository.findById(id);
    }

    public void addProduct(double price, String title){
        productRepository.addProduct(price, title);
    }

    public List<Product> getAllProducts(){
        return productRepository.getAllProducts();
    }

    public void changeProductById(int id, Product product){
        productRepository.changeProductById(id, product);
    }
}
