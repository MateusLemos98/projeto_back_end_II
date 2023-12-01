package com.projeto.crud.services;

import com.projeto.crud.domain.Product;
import com.projeto.crud.domain.dto.RequestProduct;
import com.projeto.crud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(String id) {
        return productRepository.findById(id);
    }

    public Product createProduct(RequestProduct requestProduct) {
        Product newProduct = new Product(requestProduct);
        return productRepository.save(newProduct);
    }

    public Product updateProduct(String id, RequestProduct requestProduct) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();
            existingProduct.setName(requestProduct.name());
            existingProduct.setPrice_in_cents(requestProduct.price_in_cents());
            return productRepository.save(existingProduct);
        } else {
            return null;
        }
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }
}