package com.fvillegasos.shop.controller;

import com.fvillegasos.shop.api.ProductApi;
import com.fvillegasos.shop.model.ProductIn;
import com.fvillegasos.shop.model.ProductOut;
import com.fvillegasos.shop.model.Products;
import com.fvillegasos.shop.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class ProductController implements ProductApi {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public ResponseEntity<Products> listProducts() {
        var products = productService.listProducts();
        return products.getListOfProducts().isEmpty() ?
                ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
                ResponseEntity.ok(products);
    }

    @Override
    public ResponseEntity<ProductOut> postProduct(ProductIn productIn) {
        return ResponseEntity.ok(productService.postProduct(productIn));
    }
}
