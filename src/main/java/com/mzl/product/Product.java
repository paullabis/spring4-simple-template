package com.mzl.product;

/**
 * @author paul.labis@practiceinsight.io
 */
public class Product {

  private String name;
  private String description;
  private double price;
  private String category;
  private boolean available;

  public Product(String name, String description, double price, String category, boolean available) {
    this.name = name;
    this.description = description;
    this.price = price;
    this.category = category;
    this.available = available;
  }

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

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public boolean isAvailable() {
    return available;
  }

  public void setAvailable(boolean available) {
    this.available = available;
  }
}
