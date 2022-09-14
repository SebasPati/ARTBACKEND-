package com.challengerFinal.arte.service.implement;

import com.challengerFinal.arte.model.Artworks;
import com.challengerFinal.arte.repositories.ArtworksRepository;
import com.challengerFinal.arte.service.ArtworksService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ArtworksImplement  implements ArtworksService {
    @Autowired
    ArtworksRepository artworksRepository;
    @Override
    public List<Artworks> getArtworks() {
        return artworksRepository.findAll();
    }

    @Override
    public Artworks getArtworksId(Long id) {

        return artworksRepository.findById(id).get();
    }

    @Override
    public Artworks saveArtworks(Artworks artworks) {
        return artworksRepository.save(artworks);
    }
}
