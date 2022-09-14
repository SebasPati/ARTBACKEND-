package com.challengerFinal.arte.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.awt.*;
import java.util.List;
@Entity
public class Artworks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(strategy = "native",name = "native")
    private Long id;
    private String name;
    private Double cost;
    private String description;
    @ElementCollection
    @Column(name = "Dimensions")
    private List<Double> dimensionsSet;
    //private Image image;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "artist")
    private Artist artist;

    public Artworks() {
    }

    public Artworks(String name, Double cost, String description, List<Double> dimensionsSet,Artist artist) {
        this.name = name;
        this.cost = cost;
        this.description = description;
        this.dimensionsSet = dimensionsSet;
        this.artist = artist;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Double> getDimensionsSet() {
        return dimensionsSet;
    }

    public void setDimensionsSet(List<Double> dimensionsSet) {
        this.dimensionsSet = dimensionsSet;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Artworks{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", description='" + description + '\'' +
                ", dimensionsSet=" + dimensionsSet +
                ", artist=" + artist +
                '}';
    }
}
