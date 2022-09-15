package com.challengerFinal.arte.service.implement;

import com.challengerFinal.arte.model.Artworks;
import com.challengerFinal.arte.repositories.ArtworksRepository;
import com.challengerFinal.arte.service.ServiceArtworks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtworksImplement implements ServiceArtworks {
    @Autowired
    ArtworksRepository artworksRepository;

    @Override
    public Artworks saveArtworks(Artworks artworks) {
        return artworksRepository.save(artworks);
    }
}
