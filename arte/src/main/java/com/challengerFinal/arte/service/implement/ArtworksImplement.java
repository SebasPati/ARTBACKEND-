package com.challengerFinal.arte.service.implement;

import com.challengerFinal.arte.model.Artworks;
import com.challengerFinal.arte.repositories.ArtworksRepository;
import com.challengerFinal.arte.service.ServiceArtworks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtworksImplement implements ServiceArtworks {
    @Autowired
    ArtworksRepository artworksRepository;

    @Override
    public Artworks saveArtworks(Artworks artworks) {
        return artworksRepository.save(artworks);
    }

    @Override
    public List<Artworks> getArtworksAll() {
        return artworksRepository.findAll();
    }

    @Override
    public Artworks getArtworksId(Long id) {
        return artworksRepository.findById(id).get();
    }
}
