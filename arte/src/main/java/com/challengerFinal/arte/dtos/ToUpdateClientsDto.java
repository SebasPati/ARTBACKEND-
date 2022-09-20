package com.challengerFinal.arte.dtos;

import com.challengerFinal.arte.model.enums.TypeUser;

import java.io.Serializable;
import java.util.List;

public class ToUpdateClientsDto implements Serializable {
    private final Long id;
    private final String name;
    private final String lastName;
    private final String nickname;
    private final String email;
    private final String telephone;
    private final String password;
    private final TypeUser typeUser;
    private final String direction;
    private String image;
    private final List<String> networks;

    public ToUpdateClientsDto(Long id, String name, String lastName, String nickname, String email, String telephone, String password, TypeUser typeUser, String direction, List<String> networks, String image) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.nickname = nickname;
        this.email = email;
        this.telephone = telephone;
        this.password = password;
        this.typeUser = typeUser;
        this.direction = direction;
        this.networks = networks;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getPassword() {
        return password;
    }

    public TypeUser getTypeUser() {
        return typeUser;
    }

    public List<String> getNetworks() {
        return networks;
    }

    public String getDirection() {
        return direction;
    }

    public String getImage() {
        return image;
    }
}
