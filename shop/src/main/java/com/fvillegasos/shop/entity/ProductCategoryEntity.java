package com.fvillegasos.shop.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "PRODUCT_CATEGORY")
@SequenceGenerator(name="PRODUCT_CATEGORY_SEQ_GNR",sequenceName="PRODUCT_CATEGORY_SEQ", allocationSize = 1)
public class ProductCategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_CATEGORY_SEQ_GNR")
    @Column(name = "PRODUCT_CATEGORY_ID", nullable = false)
    private Long productCategoryId;

    @Column(name = "PRODUCT_CATEGORY_NAME", nullable = false, length = 50)
    private String productCategoryName;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProductEntity> products;

    public ProductCategoryEntity() {
    }

    public ProductCategoryEntity(Long productCategoryId, String productCategoryName, List<ProductEntity> products) {
        this.productCategoryId = productCategoryId;
        this.productCategoryName = productCategoryName;
        this.products = products;
    }

    public Long getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public String getProductCategoryName() {
        return productCategoryName;
    }

    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }
}
