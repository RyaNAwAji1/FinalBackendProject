package com.example.technicalworkshop.Service;

import com.example.technicalworkshop.Model.Product;
import com.example.technicalworkshop.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;


    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void addProduct(Product product) {
         productRepository.save(product);

    }
}
