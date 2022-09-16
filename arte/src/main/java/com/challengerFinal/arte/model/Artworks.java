package com.challengerFinal.arte.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private List<Double> dimensionsList;
    @ElementCollection
    @Column(name = "ImgArtworks")
    private List<String> image;
    private Boolean status;
    private Integer existing;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client")
    private Client client;

    @OneToMany(mappedBy = "artworks",fetch = FetchType.EAGER)
    private Set<OrderLineal> artworks = new HashSet<>();

    public Artworks() {
    }

    public Artworks(String name, Double cost, String description, List<Double> dimensionsList, Boolean status, Integer existing, Client client) {
        this.name = name;
        this.cost = cost;
        this.description = description;
        this.dimensionsList = dimensionsList;
        this.status = status;
        this.existing = existing;
        this.client = client;
    }

    public Artworks(String name, Double cost, String description, List<Double> dimensionsList, List<String> image, Boolean status, Integer existing, Client client) {
        this.name = name;
        this.cost = cost;
        this.description = description;
        this.dimensionsList = dimensionsList;
        this.image = image;
        this.status = status;
        this.existing = existing;
        this.client = client;
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
        return dimensionsList;
    }

    public void setDimensionsSet(List<Double> dimensionsSet) {
        this.dimensionsList = dimensionsSet;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Double> getDimensionsList() {
        return dimensionsList;
    }

    public void setDimensionsList(List<Double> dimensionsList) {
        this.dimensionsList = dimensionsList;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getExisting() {
        return existing;
    }

    public void setExisting(Integer existing) {
        this.existing = existing;
    }

    public List<String> getImage() {
        return image;
    }

    public void setImage(List<String> image) {
        this.image = image;
    }

    public Set<OrderLineal> getArtworks() {
        return artworks;
    }

    public void setArtworks(Set<OrderLineal> artworks) {
        this.artworks = artworks;
    }

    @Override
    public String toString() {
        return "Artworks{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", description='" + description + '\'' +
                ", dimensionsList=" + dimensionsList +
                ", status=" + status +
                ", existing=" + existing +
                ", artist=" + client +
                '}';
    }
}
