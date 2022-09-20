package com.challengerFinal.arte.dtos;

import com.challengerFinal.arte.model.Product;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ProductDto {
    private  Long id;
    private  String name;
    private  String description;
    private  List<Double> dimensionsList;
    private String image;
    private Double price;
    private Boolean status;
    private LocalDate date;
    private Integer units;


    public ProductDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.dimensionsList = product.getDimensionsList();
        this.image = product.getImage();
        this.price = product.getPrice();
        this.status = product.getStatus();
        this.date = product.getDate();
        this.units = product.getUnits();

          }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Double> getDimensionsList() {
        return dimensionsList;
    }

    public String getImage() {
        return image;
    }

    public Double getPrice() {
        return price;
    }

    public Boolean getStatus() {
        return status;
    }

    public LocalDate getDate() {
        return date;
    }

    public Integer getUnits() {
        return units;
    }
}
