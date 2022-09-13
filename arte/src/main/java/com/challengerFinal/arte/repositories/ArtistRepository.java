package com.challengerFinal.arte.repositories;

import com.challengerFinal.arte.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ArtistRepository extends JpaRepository<Artist, Long> {

}