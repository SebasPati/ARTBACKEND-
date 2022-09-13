package com.challengerFinal.arte.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table()
public class Client extends User {
    private Integer telefone;
    public Client(){

    }

    public Client(String name, String lastName, String email, String password, Integer telefone) {
        super(name, lastName, email, password);
        this.telefone = telefone;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Client{" +
                "ID='" + getId() + '\''
                +"Name='" + getName() + '\''
                +"Last Name='" + getLastName() + '\''
                +"Email='" + getEmail() + '\''
                +"Password='" + getPassword() + '\'' +
                "telefone=" + telefone  + '\'' +
                '}';
    }
}