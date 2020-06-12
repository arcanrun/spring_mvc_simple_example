package com.geekbrains.repositories;


import com.geekbrains.entities.Product;
import com.geekbrains.entities.Student;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> productList;

    @PostConstruct
    private void init(){
        productList = new ArrayList<>();
        productList.add(new Product(productList.size(),10, "Shirt"));
        productList.add(new Product(productList.size(), 115, "Bag"));
        productList.add(new Product(productList.size(),20, "Hat"));
    }

    public Product findById(int id){
        if(id > productList.size() || id < 0){
            return null;
        }else {
            return productList.get(id);
        }
    }

    public void addProduct(double price, String title){
        productList.add(new Product(productList.size(), price, title));
    }

    public List<Product> getAllProducts(){
        return productList;
    }

    public void changeProductById(int id, Product product){
        productList.set(id, product);

    }


}
