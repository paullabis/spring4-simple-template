package com.mzl.dao;

import com.mzl.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author paul.labis@practiceinsight.io
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
