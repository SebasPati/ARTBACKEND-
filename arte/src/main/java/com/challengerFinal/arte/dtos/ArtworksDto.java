package com.challengerFinal.arte.dtos;

import com.challengerFinal.arte.model.Artworks;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class ArtworksDto {
    private  Long id;
    private  String name;
    private  Double cost;
    private  String description;
    private  List<Double> dimensionsList;

    private Boolean status;
    private Integer existing;

    public ArtworksDto(Artworks artworks) {
        this.id = artworks.getId();
        this.name = artworks.getName();
        this.cost = artworks.getCost();
        this.description = artworks.getDescription();
        this.dimensionsList = artworks.getDimensionsSet();
        this.status = artworks.getStatus();
        this.existing = artworks.getExisting();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getCost() {
        return cost;
    }

    public String getDescription() {
        return description;
    }

    public List<Double> getDimensionsList() {
        return dimensionsList;
    }

    public Boolean getStatus() {
        return status;
    }

    public Integer getExisting() {
        return existing;
    }

}
