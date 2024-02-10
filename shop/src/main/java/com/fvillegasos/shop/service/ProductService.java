package com.fvillegasos.shop.service;

import com.fvillegasos.shop.mapper.ProductMapper;
import com.fvillegasos.shop.model.ProductIn;
import com.fvillegasos.shop.model.ProductOut;
import com.fvillegasos.shop.model.Products;
import com.fvillegasos.shop.repository.ProductCategoryRepository;
import com.fvillegasos.shop.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository repository;
    private final ProductCategoryRepository productCategoryRepository;
    private final ProductMapper mapper;

    public ProductService(ProductRepository repository, ProductCategoryRepository productCategoryRepository, ProductMapper mapper) {
        this.repository = repository;
        this.productCategoryRepository = productCategoryRepository;
        this.mapper = mapper;
    }

    public Products listProducts() {
        var result = repository.findAll();
        return new Products().listOfProducts(mapper.convertToProducts(result));
    }

    public ProductOut postProduct(ProductIn productIn) {
        var productCategory = productCategoryRepository.findByProductCategoryName(productIn.getCategory());
        if (productCategory == null) {
            //TODO Category can not be null throw custom error
        }
        var entity = mapper.convertToProductEntity(productIn);
        entity.setCategory(productCategory);
        var savedEntity = repository.save(entity);
        return mapper.convertToProductOut(savedEntity);
    }
}
