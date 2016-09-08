package com.mzl.service;

import com.mzl.dao.ProductRepository;
import com.mzl.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  public List<Product> getProductList() {
    return productRepository.findAll();
  }

  public Product save(Product product) {
    return productRepository.save(product);
  }

  public void delete(long productId) {
    productRepository.delete(productId);
  }

  public Product findById(long productId) {
    return productRepository.findOne(productId);
  }


}
