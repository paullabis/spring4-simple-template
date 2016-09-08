package com.mzl.service;

import com.mzl.product.Product;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author paul.labis@practiceinsight.io
 */
@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ProductService {

  public List<Product> getProductList() {

    List<Product> products = new ArrayList<>();
    products.add(new Product("Gardenia", "1 description", 100.01, "Bread", false));
    products.add(new Product("Corned Beef", "2 description", 100.40, "Can Goods", true));

    return products;
  }
}
