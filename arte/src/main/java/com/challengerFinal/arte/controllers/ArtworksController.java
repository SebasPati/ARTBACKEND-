package com.challengerFinal.arte.controllers;

import com.challengerFinal.arte.dtos.ArtworksDto;
import com.challengerFinal.arte.service.ArtworksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api")
public class ArtworksController {
    @Autowired
    ArtworksService service;
    @GetMapping(value = "/artworks")
    public List<ArtworksDto> getArtworks() {
        return service.getArtworks().stream().map(ArtworksDto::new).collect(Collectors.toList());
    }
}
