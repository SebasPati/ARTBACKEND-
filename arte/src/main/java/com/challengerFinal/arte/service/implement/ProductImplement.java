package com.challengerFinal.arte.service.implement;

import com.challengerFinal.arte.dtos.CreateProductDto;
import com.challengerFinal.arte.dtos.ProductDto;
import com.challengerFinal.arte.dtos.UpdateProductDTO;
import com.challengerFinal.arte.model.Product;
import com.challengerFinal.arte.repositories.ProductRepository;
import com.challengerFinal.arte.service.ServiceProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductImplement implements ServiceProduct {
    @Autowired
    ProductRepository productRepository;

    @Override
    public Product saveArtworks(Product product) {
        return productRepository.save(product);
    }
    @Override
    public List<ProductDto> getArtworksAll() {
        return productRepository.findAll().stream().map(ProductDto::new).collect(Collectors.toList());
    }
    @Override
    public ProductDto getArtworksId(Long id) {
        return productRepository.findById(id).map(ProductDto::new).orElse(null);
    }

    @Override
    public ResponseEntity<Object> createProduct(CreateProductDto createProductDto) {
        Product newProduct =new Product ();
        productRepository.save(newProduct);
        return new ResponseEntity<>("Created a new work of art"+newProduct,HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> updateProduct(Long id, UpdateProductDTO updateProductDto) {
        return null;
    }

    @Override
    public ResponseEntity<Object> deleteProduct(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Object> patchProduct(Long id, UpdateProductDTO updateProductDto) {
        return null;
    }
}
