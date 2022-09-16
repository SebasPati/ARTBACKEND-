package com.challengerFinal.arte.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
@Entity
public class OrderLineal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(strategy = "native",name = "native")
    private Long id;
    private Integer units;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "orderRequest_id")
    private OrderRequest orderRequest;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "productRequest_id")
    private Product product;

    public OrderLineal() {
    }

    public OrderLineal(Integer units,OrderRequest orderRequest, Product product) {
        this.units = units;
        this.orderRequest = orderRequest;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public Integer getUnits() {
        return units;
    }

    public void setUnits(Integer units) {
        this.units = units;
    }

    public OrderRequest getOrderRequest() {
        return orderRequest;
    }

    public void setOrderRequest(OrderRequest orderRequest) {
        this.orderRequest = orderRequest;
    }

    public Product getArtworks() {
        return product;
    }

    public void setArtworks(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "OrderLineal{" +
                "id=" + id +
                ", units=" + units +
                ", orderRequest=" + orderRequest +
                ", product=" + product +
                '}';
    }
}
