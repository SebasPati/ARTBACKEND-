package com.challengerFinal.arte.service;

import com.challengerFinal.arte.model.Artworks;

import java.util.List;

public interface ArtworksService {
    List<Artworks> getArtworks();
    Artworks getArtworksId(Long id);
    Artworks saveArtworks(Artworks artworks);
}
