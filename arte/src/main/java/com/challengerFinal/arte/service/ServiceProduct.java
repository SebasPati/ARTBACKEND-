package com.challengerFinal.arte.service;

import com.challengerFinal.arte.model.Product;

import java.util.List;

public interface ServiceProduct {
    Product saveArtworks(Product product);
    List <Product> getArtworksAll();
    Product getArtworksId(Long id);
}
