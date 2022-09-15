package com.challengerFinal.arte.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.net.URL;

@Entity
public class ImgArtworks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(strategy = "native",name = "native")
    private Long id;
    private String description;
    private URL urlImagen;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "artworksImage")
    private Artworks image;

    public ImgArtworks() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public URL getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(URL urlImagen) {
        this.urlImagen = urlImagen;
    }

    public Artworks getImage() {
        return image;
    }

    public void setImage(Artworks image) {
        this.image = image;
    }
}
