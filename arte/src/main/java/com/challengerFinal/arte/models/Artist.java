package com.challengerFinal.arte.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class Artist extends User {
    private String nickname;

    public Artist() {
    }

    public Artist(String nickname) {
        this.nickname = nickname;
    }

    public Artist(String name, String lastName, String email, String password, String nickname) {
        super(name, lastName, email, password);
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "ID='" + getId() + '\''
                +"Name='" + getName() + '\''
                +"Last Name='" + getLastName() + '\''
                +"Email='" + getEmail() + '\''
                +"Password='" + getPassword() + '\'' +
                "nickname='" + nickname + '\'' +
                '}';
    }
}