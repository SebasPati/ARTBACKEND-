package com.challengerFinal.arte.dtos;


import com.challengerFinal.arte.model.Client;

public class ClientDTO {
    private long id;
    private String name;
    private String lastName;
    private String email;
    private String telefono;


    public ClientDTO() {
    }

    public ClientDTO(Client user) {
        this.id = user.getId();
        this.name = user.getName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.telefono = user.getTelefone();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }
}
