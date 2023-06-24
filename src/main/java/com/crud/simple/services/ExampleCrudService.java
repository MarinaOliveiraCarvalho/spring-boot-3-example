package com.crud.simple.services;

import com.crud.simple.dto.ProductDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Random;
import java.util.UUID;
@Slf4j
@Service
public class ExampleCrudService {

    public static final String PRODUCT_NAME = "Pop";
    public static final BigDecimal PRODUCT_VALUE = new BigDecimal(55.6)
            .setScale(2 , BigDecimal.ROUND_HALF_UP);


    public ProductDto findProduct(UUID idProduct){
        try {
            log.info("Find product begin");

            return new ProductDto(
                    idProduct,
                    PRODUCT_NAME,
                    PRODUCT_VALUE
            );
        }catch (Exception e){
            log.error("ERROR on find product"+ idProduct.toString());
            throw new RuntimeException("ERROR on find product"+ idProduct);
        }
    }


    public ProductDto createProduct(ProductDto productDto){
        try {
            log.info("Create product begin");

            return new ProductDto(
                    UUID.randomUUID(),
                    productDto.name(),
                    productDto.price()
            );
        }catch (Exception e){
            log.error("ERROR on create product");
            throw new RuntimeException("ERROR on create product");
        }
    }
}
