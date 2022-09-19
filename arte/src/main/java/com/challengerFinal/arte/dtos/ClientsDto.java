package com.challengerFinal.arte.dtos;

import com.challengerFinal.arte.model.Client;
import com.challengerFinal.arte.model.enums.TypeUser;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ClientsDto implements Serializable {
    private final Integer ranking;
    private Long id;
    private String name;
    private String lastName;
    private String nickname;
    private String email;
    private String telephone;
    private TypeUser typeUser;
    private String direction;
    private List<String> networks;
    private Set<ProductDto> artworks;
    private Set<OrderRequestDto> claimant;



    public ClientsDto(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.lastName = client.getLastName();
        this.nickname = client.getNickname();
        this.ranking = client.getRanking();
        this.email = client.getEmail();
        this.telephone = client.getTelephone();
        this.typeUser = client.getTypeUser();
        this.direction = client.getDirection();
        this.networks = client.getNetworks();
        this.artworks = client.getArtworks().stream().map(ProductDto::new).collect(Collectors.toSet());
        this.claimant = client.getClaimant().stream().map(OrderRequestDto::new).collect(Collectors.toSet());
    }

    public Integer getRanking() {
        return ranking;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public TypeUser getTypeUser() {
        return typeUser;
    }

    public String getDirection() {
        return direction;
    }

    public List<String> getNetworks() {
        return networks;
    }

    public Set<ProductDto> getArtworks() {
        return artworks;
    }
    public Set<OrderRequestDto> getClaimant() {
        return claimant;
    }
}
