package com.challengerFinal.arte.dtos;

import java.io.Serializable;
import java.util.List;

public class UpdateProductDTO implements Serializable {
    private Long id;
    private String name;
    private String description;
    private String category;
    private List<Double> dimensionsList;
    private List<String> image;

    public UpdateProductDTO(Long id, String name, String description, String category, List<Double> dimensionsList, List<String> image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.dimensionsList = dimensionsList;
        this.image = image;
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

    public List<String> getImage() {
        return image;
    }
}
