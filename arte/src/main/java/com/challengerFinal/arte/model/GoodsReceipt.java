package com.challengerFinal.arte.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class GoodsReceipt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator ="native")
    @GenericGenerator(name = "native",strategy = "native")
    private Long id;
    private Double price;
    private Boolean status;
    private LocalDate date;
    private Integer units;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product")
    private Product productRec;

    public GoodsReceipt() {
    }

    public GoodsReceipt(Product productRec,Double price, Boolean status, LocalDate date, Integer units) {
        this.productRec = productRec;
        this.price = price;
        this.status = status;
        this.date = date;
        this.units = units;

    }

    public Long getId() {
        return id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getUnits() {
        return units;
    }

    public void setUnits(Integer units) {
        this.units = units;
    }

    public Product getProductRec() {
        return productRec;
    }

    public void setProductRec(Product productRec) {
        this.productRec = productRec;
    }

    @Override
    public String toString() {
        return "GoodsReceipt{" +
                "id=" + id +
                ", price= $" + price +
                ", status=" + status +
                ", date=" + date +
                ", units=" + units +
                ", productRec=" + productRec +
                '}';
    }
}
