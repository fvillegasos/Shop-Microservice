package com.fvillegasos.shop.repository;

import com.fvillegasos.shop.entity.ProductCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategoryEntity, Long> {

    ProductCategoryEntity findByProductCategoryName(String categoryName);

}
