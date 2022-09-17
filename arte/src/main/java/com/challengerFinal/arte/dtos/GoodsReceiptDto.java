package com.challengerFinal.arte.dtos;

import com.challengerFinal.arte.model.GoodsReceipt;

import java.io.Serializable;
import java.time.LocalDate;

public class GoodsReceiptDto implements Serializable {
    private final Long id;
    private final Double price;
    private final Boolean status;
    private final LocalDate date;
    private final Integer units;

    public GoodsReceiptDto(GoodsReceipt goodsReceipt) {
        this.id = goodsReceipt.getId();
        this.price = goodsReceipt.getPrice();
        this.status = goodsReceipt.getStatus();
        this.date = goodsReceipt.getDate();
        this.units = goodsReceipt.getUnits();
    }

    public Long getId() {
        return id;
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
