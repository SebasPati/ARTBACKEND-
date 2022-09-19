package com.challengerFinal.arte.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(strategy = "native",name = "native")
    private Long id;
    private boolean isShoppingCart;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client")
    private Client client;
    @OneToMany(mappedBy = "orders",fetch = FetchType.EAGER)
    private Set <OrderRequest> orderRequest = new HashSet<>();

    @OneToMany(mappedBy="payment", fetch=FetchType.EAGER)
    Set<GoodsReceipt> payment = new HashSet<>();

    public ShoppingCart() {
    }

    public ShoppingCart(Client client) {
        this.client = client;
        this.isShoppingCart = true;
    }

    public Long getId() {
        return id;
    }



    public boolean isShoppingCart() {
        return isShoppingCart;
    }

    public void setShoppingCart(boolean shoppingCart) {
        isShoppingCart = shoppingCart;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}
