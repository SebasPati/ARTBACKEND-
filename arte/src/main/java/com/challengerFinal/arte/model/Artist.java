package com.challengerFinal.arte.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Artist {
   @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(strategy = "native",name = "native")
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String nickname;
    private String password;
    @OneToMany(mappedBy = "artist",fetch = FetchType.EAGER)
    private Set<Artworks> artworks = new HashSet<>();

    public Artist(){
    }

    public Artist(String name, String lastName, String email, String nickname, String password) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String telefone) {
        this.nickname = telefone;
    }

    public Set<Artworks> getArtworks() {
        return artworks;
    }

    public void setArtworks(Set<Artworks> artworks) {
        this.artworks = artworks;
    }
    public void addArtworks(Artworks artwork) {
        artwork.setArtist(this);
        artworks.add(artwork);

    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
