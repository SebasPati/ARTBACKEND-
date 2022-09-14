package com.challengerFinal.arte.repositories;

import com.challengerFinal.arte.model.Artworks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtworksRepository extends JpaRepository<Artworks, Long> {
}