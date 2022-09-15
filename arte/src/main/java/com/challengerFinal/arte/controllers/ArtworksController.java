package com.challengerFinal.arte.controllers;

import com.challengerFinal.arte.dtos.ArtworksDto;
import com.challengerFinal.arte.service.ServiceArtworks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api")
public class ArtworksController {
    @Autowired
    ServiceArtworks artworksService;

    @GetMapping(value = "/artworks")
    public Set<ArtworksDto> getArtworks() {
        return artworksService.getArtworksAll().stream().map(ArtworksDto::new).collect(Collectors.toSet());
    }
    @GetMapping(value = "/artworks/{id}")
    public ArtworksDto getArtworksId(@PathVariable Long id) {
        return new ArtworksDto(artworksService.getArtworksId(id));
    }

}
