package com.challengerFinal.arte.dtos;


import com.challengerFinal.arte.model.Artist;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ArtistDTO {
    private long Id;
    private String Name;
    private String LastName;
    private String Email;
    private String nickname;
    private List<String> networks;
    private Set<ArtworksDto> artworks;



    public ArtistDTO() {
    }

    public ArtistDTO(Artist user) {
        this.Id = user.getId();
        this.Name = user.getName();
        this.LastName = user.getLastName();
        this.Email = user.getEmail();
        this.nickname = user.getNickname();
        this.networks = user.getNetworks();
        this.artworks = user.getArtworks().stream().map(ArtworksDto::new).collect(Collectors.toSet());

    }

    public long getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getLastName() {
        return LastName;
    }

    public String getEmail() {
        return Email;
    }

    public String getNickname() {
        return nickname;
    }

    public List<String> getNetworks() {
        return networks;
    }

    public Set<ArtworksDto> getArtworks() {
        return artworks;
    }
}
