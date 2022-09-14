package com.challengerFinal.arte.controllers;

import com.challengerFinal.arte.dtos.ArtistDTO;
import com.challengerFinal.arte.dtos.ArtistRegister;
import com.challengerFinal.arte.dtos.ClientDTO;
import com.challengerFinal.arte.dtos.ClientRegister;
import com.challengerFinal.arte.service.ArtistService;
import com.challengerFinal.arte.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api")
public class ArtistController {
    @Autowired
    ArtistService artistService;
    @GetMapping("/artist")
    public List<ArtistDTO> getAtist() {
        return artistService.getUsers().stream().map(ArtistDTO::new).collect(Collectors.toList());
    }

    public ResponseEntity<Object> registerArtist(@RequestBody ArtistRegister user){

        return new ResponseEntity<Object>(HttpStatus.CREATED);
    }

}