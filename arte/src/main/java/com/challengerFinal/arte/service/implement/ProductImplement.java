package com.challengerFinal.arte.service.implement;

import com.challengerFinal.arte.dtos.CreateProductDto;
import com.challengerFinal.arte.dtos.ProductDto;
import com.challengerFinal.arte.dtos.UpdateProductDTO;
import com.challengerFinal.arte.model.Client;
import com.challengerFinal.arte.model.Product;
import com.challengerFinal.arte.repositories.ClientRepository;
import com.challengerFinal.arte.repositories.ProductRepository;
import com.challengerFinal.arte.service.ServiceProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductImplement implements ServiceProduct {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ClientRepository clientRepository;

    @Override
    public Product saveArtworks(Product product) {
        return productRepository.save(product);
    }
    @Override
    public List<ProductDto> getArtworksAll() {
        return productRepository.findAll().stream().map(ProductDto::new).collect(Collectors.toList());
    }
    @Override
    public ProductDto getArtworkById(Long id) {
        return productRepository.findById(id).map(ProductDto::new).orElse(null);
    }

    @Override
    public ResponseEntity<Object> createProduct(Authentication authentication,
                                                CreateProductDto createProductDto) {

        Client client = clientRepository.findByEmail(authentication.getName());

        if (
                createProductDto.getName().isEmpty()
                || createProductDto.getCategory().isEmpty()
                || createProductDto.getDimensionsList().isEmpty()
                || createProductDto.getDescription().isEmpty()
                || createProductDto.getImage().isEmpty()
                ){
            return new  ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        Product newProduct =new Product (
                createProductDto.getName(),
                createProductDto.getDescription(),
                createProductDto.getCategory(),
                createProductDto.getPrice(),
                true,
                LocalDate.now(),
                createProductDto.getUnits(),
                createProductDto.getDimensionsList(),
                createProductDto.getImage(),
                client
                );
        productRepository.save(newProduct);
        return new ResponseEntity<>("Created a new work of art"+newProduct,HttpStatus.CREATED);
    }
//No terminado.
    @Override
    public ResponseEntity<Object> updateProduct(Long id, UpdateProductDTO updateProductDto,Authentication authentication) {
        Client client = clientRepository.findByEmail(authentication.getName());
        Optional<Product> updateProduct = productRepository.findById(id);
        //Si el product no existe
        if (updateProduct == null) {
            return new ResponseEntity<>("Product not updated",HttpStatus.FORBIDDEN);
        }
        updateProduct.get().setName(updateProductDto.getName());
        updateProduct.get().setCategory(updateProductDto.getCategory());
        updateProduct.get().setDate(LocalDate.now());
        updateProduct.get().setDescription(updateProductDto.getDescription());
        updateProduct.get().setImage(updateProductDto.getImage());
        updateProduct.get().setPrice(updateProductDto.getPrice());
        updateProduct.get().setStatus(updateProductDto.getStatus());
        updateProduct.get().setUnits(updateProductDto.getUnits());
        updateProduct.get().setClient(client);

        productRepository.save(updateProduct.get());
        return new ResponseEntity<>("Producto actualizado", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> deleteProduct(Long id) {
        return null;
    }

}
