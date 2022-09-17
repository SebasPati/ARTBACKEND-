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
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client")
    private Client petitioner;

    @OneToMany(mappedBy = "orderRequest",fetch = FetchType.EAGER)
    private Set<OrderLineal> orders = new HashSet<>();
    public OrderRequest(){}

    public OrderRequest(LocalDate date, StatePedido state, Client petitioner) {
        this.date = date;
        this.state = state;
        this.petitioner = petitioner;
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

    public Client getPetitioner() {
        return petitioner;
    }

    public void setPetitioner(Client petitioner) {
        this.petitioner = petitioner;
    }

    public Set<OrderLineal> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderLineal> orders) {
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
