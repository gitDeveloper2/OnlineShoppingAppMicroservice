package com.example.productservice.services;

import com.example.productservice.dto.ProductRequest;
import com.example.productservice.dto.ProductResponse;
import com.example.productservice.models.Product;
import com.example.productservice.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
public class ProductService {
@Autowired
    ProductRepo productRepo;
    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder().name(productRequest.getName()).
                description(productRequest.getDescription()
                ).price(productRequest.getPrice()).build();
        productRepo.save(product);
        log.info("Product {} is saved", product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepo.findAll();
        return products.stream().map(
                product -> {

                    return ProductResponse.builder().
                            id(product.getId()).
                            price(product.getPrice()).
                            name(product.getName()).description(
                                    product.getDescription()).
                            build();

                }
        ).toList();


    }
}





