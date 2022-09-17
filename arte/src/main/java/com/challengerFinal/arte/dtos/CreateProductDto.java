package com.challengerFinal.arte.dtos;

import java.io.Serializable;
import java.util.List;

public class CreateProductDto implements Serializable {
    private Long id;
    private String name;
    private String description;
    private String category;
    private List<Double> dimensionsList;

    public CreateProductDto() {
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

    public String getCategory() {
        return category;
    }

    public List<Double> getDimensionsList() {
        return dimensionsList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDimensionsList(List<Double> dimensionsList) {
        this.dimensionsList = dimensionsList;
    }
}
