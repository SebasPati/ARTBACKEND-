package com.challengerFinal.arte.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(strategy = "native",name = "native")
    private Long id;
    private String name;
    private String description;
    private String category;
    @ElementCollection
    @Column(name = "Dimensions")
    private List<Double> dimensionsList;
    @ElementCollection
    @Column(name = "ImgArtworks")
    private List<String> image;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client")
    private Client client;

    @OneToMany(mappedBy = "product",
            fetch = FetchType.EAGER)
    private Set<OrderLineal> artworks = new HashSet<>();

    @OneToMany(mappedBy = "productRec",
            fetch = FetchType.EAGER)
    private Set<GoodsReceipt> existing = new HashSet<>();

    public Product() {
    }
    //Creado para pruebas
    public Product(String name, String description, List<Double> dimensionsList, String category, Client client) {
        this.name = name;
        this.description = description;
        this.dimensionsList = dimensionsList;
        this.category = category;
        this.client = client;
    }

    public Product(String name, String description, List<Double> dimensionsList, List<String> image, Client client) {
        this.name = name;
        this.description = description;
        this.dimensionsList = dimensionsList;
        this.image = image;
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

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Double> getDimensionsList() {
        return dimensionsList;
    }


    public void setDimensionsList(List<Double> dimensionsList) {
        this.dimensionsList = dimensionsList;
    }

    public List<String> getImage() {
        return image;
    }

    public void setImage(List<String> image) {
        this.image = image;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<OrderLineal> getArtworks() {
        return artworks;
    }

    public void setArtworks(Set<OrderLineal> artworks) {
        this.artworks = artworks;
    }

    public Set<GoodsReceipt> getExisting() {
        return existing;
    }

    public void setExisting(Set<GoodsReceipt> existing) {
        this.existing = existing;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dimensionsList=" + dimensionsList +
                ", existing=" + existing +
                ", artist=" + client +
                '}';
    }
}
