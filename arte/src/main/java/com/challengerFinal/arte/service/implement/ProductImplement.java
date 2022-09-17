package com.challengerFinal.arte.service.implement;

import com.challengerFinal.arte.model.Product;
import com.challengerFinal.arte.repositories.ProductRepository;
import com.challengerFinal.arte.service.ServiceProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImplement implements ServiceProduct {
    @Autowired
    ProductRepository productRepository;

    @Override
    public Product saveArtworks(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getArtworksAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getArtworksId(Long id) {
        return productRepository.findById(id).get();
    }
}
