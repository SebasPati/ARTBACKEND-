package com.challengerFinal.arte.model;

import com.challengerFinal.arte.model.enums.StatePedido;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
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
}
