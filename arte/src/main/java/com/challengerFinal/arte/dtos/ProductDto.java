package com.challengerFinal.arte.dtos;

import com.challengerFinal.arte.model.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ProductDto {
    private  Long id;
    private  String name;
    private  String description;
    private  List<Double> dimensionsList;
    private List<GoodsReceiptDto> existing;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.dimensionsList = product.getDimensionsList();
        this.existing = product.getExisting().stream().map(GoodsReceiptDto::new).collect(Collectors.toList());
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

    public List<GoodsReceiptDto> getExisting() {
        return existing;
    }

}
