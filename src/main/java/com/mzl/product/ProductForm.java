package com.mzl.product;

import com.mzl.model.Product;


public class ProductForm {

    private String name;
    private String description;
    private double price;
    private long category;
    private boolean available;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getCategory() {
        return category;
    }

    public void setCategory(long category) {
        this.category = category;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Product createProduct() {
        return new Product(getName(), getDescription(), getPrice(), null, isAvailable());
    }
}
