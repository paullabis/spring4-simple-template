package com.mzl.service;

import com.mzl.dao.CategoryRepository;
import com.mzl.model.Category;
import com.mzl.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author paul.labis@practiceinsight.io
 */
@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CategoryService {
  @Autowired
  private CategoryRepository categoryRepository;

  public List<Category> getCategoryList() {
    List<Category> categories = categoryRepository.findAll();
    if (categories == null || categories.isEmpty()) {
      save(new Category("Bread", "Any kind of bread."));
      save(new Category("Liquor", "Any kind of alcoholic beverages."));
    }
    return categories;
  }

  public Category save(Category category) {
    return categoryRepository.save(category);
  }

  public void delete(long categoryId) {
    categoryRepository.delete(categoryId);
  }

  public Category findById(long categoryId) {
    return categoryRepository.findOne(categoryId);
  }

}
