package com.mzl.dao;

import com.mzl.model.Category;
import com.mzl.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author paul.labis@practiceinsight.io
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
