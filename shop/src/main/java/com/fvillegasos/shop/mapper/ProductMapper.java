package com.fvillegasos.shop.mapper;

import com.fvillegasos.shop.entity.ProductEntity;
import com.fvillegasos.shop.model.Product;
import com.fvillegasos.shop.model.ProductIn;
import com.fvillegasos.shop.model.ProductOut;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(target = "name", source = "name")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "sale", source = "sale")
    @Mapping(target = "salePercentage", source = "percentage")
    @Mapping(target = "category", source = "category", ignore = true)
    ProductEntity convertToProductEntity(ProductIn source);

    @Mapping(target = "id", source = "productId")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "sale", source = "sale")
    @Mapping(target = "percentage", source = "salePercentage")
    @Mapping(target = "category", expression = "java(getCategoryName(source))")
    Product convertToProduct(ProductEntity source);

    List<Product> convertToProducts(List<ProductEntity> source);

    default String getCategoryName(ProductEntity source) {
        return source.getCategory().getProductCategoryName();
    }

    @Mapping(target = "id", source = "productId")
    ProductOut convertToProductOut(ProductEntity source);

}
