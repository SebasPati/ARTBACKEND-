package com.challengerFinal.arte.service;

import com.challengerFinal.arte.model.Artworks;

import java.util.List;

public interface ServiceArtworks {
    Artworks saveArtworks(Artworks artworks);
    List <Artworks> getArtworksAll();
    Artworks getArtworksId(Long id);
}
