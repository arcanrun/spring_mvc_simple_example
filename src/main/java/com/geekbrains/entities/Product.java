package com.geekbrains.entities;

public class Product {
    private int id;
    private double price;
    private String title;


    public Product(){}

    public Product(int id, double price, String title){
        this.price = price;
        this.title = title;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return ""+id + " " + title + " " + price ;
    }
}
