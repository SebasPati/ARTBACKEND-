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
    @JoinColumn(name = "artworksRequest_id")
    private Artworks artworks;

    public OrderLineal() {
    }

    public OrderLineal(Integer units,OrderRequest orderRequest, Artworks artworks) {
        this.units = units;
        this.orderRequest = orderRequest;
        this.artworks = artworks;
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

    public Artworks getArtworks() {
        return artworks;
    }

    public void setArtworks(Artworks artworks) {
        this.artworks = artworks;
    }

    @Override
    public String toString() {
        return "OrderLineal{" +
                "id=" + id +
                ", units=" + units +
                ", orderRequest=" + orderRequest +
                ", artworks=" + artworks +
                '}';
    }
}
