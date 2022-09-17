package com.challengerFinal.arte.controllers;

import com.challengerFinal.arte.dtos.ProductDto;
import com.challengerFinal.arte.service.ServiceProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api")
public class ProductController {
    @Autowired
    ServiceProduct artworksService;

    @GetMapping(value = "/products")
    public Set<ProductDto> getArtworks() {
        return artworksService.getArtworksAll().stream().map(ProductDto::new).collect(Collectors.toSet());
    }
    @GetMapping(value = "/products/{id}")
    public ProductDto getArtworksId(@PathVariable Long id) {
        return new ProductDto(artworksService.getArtworksId(id));
    }

}
