package com.challengerFinal.arte.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    private String name;

    @ElementCollection
    @Column(name = "payment")
    private List<Integer> payments = new ArrayList<>();

    @OneToMany (mappedBy="payment", fetch=FetchType.EAGER)
    Set<GoodsReceipt> invoices = new HashSet<>();

    public Payment() {
    }

    public Payment(Long id, String name, List<Integer> payments) {
    }

    public Payment(String name, List<Integer> payments) {
        this.name = name;
        this.payments = payments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getPayments() {
        return payments;
    }

    public void setPayments(List<Integer> payments) {
        this.payments = payments;
    }

    public Set<GoodsReceipt> getInvoices() {
        return invoices;
    }

    public void setInvoices(Set<GoodsReceipt> invoices) {
        this.invoices = invoices;
    }
}
