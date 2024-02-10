package com.fvillegasos.shop.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "PRODUCT")
@SequenceGenerator(name="PRODUCT_SEQ_GNR",sequenceName="PRODUCT_SEQ", allocationSize = 1)
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_SEQ_GNR")
    @Column(name = "PRODUCT_ID", nullable = false)
    private Long productId;

    @Column(name = "NAME", nullable = false, length = 50)
    private String name;

    @Column(name = "PRICE", nullable = false, length = 5)
    private Long price;

    @Column(name = "SALE", nullable = false)
    private Boolean sale;

    @Column(name = "SALE_PERCENTAGE", length = 3)
    private Long salePercentage;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PRODUCT_CATEGORY", nullable = false)
    private ProductCategoryEntity category;

    public ProductEntity() {
    }

    public ProductEntity(Long productId, String name, Long price, Boolean sale, Long salePercentage, ProductCategoryEntity category) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.sale = sale;
        this.salePercentage = salePercentage;
        this.category = category;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Boolean getSale() {
        return sale;
    }

    public void setSale(Boolean sale) {
        this.sale = sale;
    }

    public Long getSalePercentage() {
        return salePercentage;
    }

    public void setSalePercentage(Long salePercentage) {
        this.salePercentage = salePercentage;
    }

    public ProductCategoryEntity getCategory() {
        return category;
    }

    public void setCategory(ProductCategoryEntity category) {
        this.category = category;
    }

}
