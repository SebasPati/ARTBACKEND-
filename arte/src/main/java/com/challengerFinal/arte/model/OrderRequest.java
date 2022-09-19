package com.challengerFinal.arte.model;

import com.challengerFinal.arte.model.enums.StatePedido;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class OrderRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(strategy = "native",name = "native")
    private Long id;
    private LocalDate date;
    private StatePedido state;
    private Integer units;
    private Double price;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "petitioner")
    private Product petitioner;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "orderRequest_id")
    private ShoppingCart orders;
    public OrderRequest(){}

    public OrderRequest(Product petitioner,LocalDate date, StatePedido state,Double price,Integer units,ShoppingCart orders) {
        this.petitioner = petitioner;
        this.date = date;
        this.state = state;
        this.price = price;
        this.units = units;
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public StatePedido getState() {
        return state;
    }

    public void setState(StatePedido state) {
        this.state = state;
    }

    public Product getPetitioner() {
        return petitioner;
    }

    public void setPetitioner(Product petitioner) {
        this.petitioner = petitioner;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getUnits() {
        return units;
    }

    public void setUnits(Integer units) {
        this.units = units;
    }

    public ShoppingCart getOrders() {
        return orders;
    }

    public void setOrders(ShoppingCart orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "id=" + id +
                ", date=" + date +
                ", state=" + state +
                ", petitioner=" + petitioner +
                ", orders=" + orders +
                '}';
    }
}
