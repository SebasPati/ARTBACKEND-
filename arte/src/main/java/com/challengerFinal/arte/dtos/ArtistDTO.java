package com.challengerFinal.arte.dtos;


import com.challengerFinal.arte.model.Artist;

public class ArtistDTO {
    private long Id;
    private String Name;
    private String LastName;
    private String Email;
    private String nickname;



    public ArtistDTO() {
    }

    public ArtistDTO(Artist user) {
        this.Id = user.getId();
        this.Name = user.getName();
        this.LastName = user.getLastName();
        this.Email = user.getEmail();
        this.nickname = user.getNickname();

    }

    public long getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getLastName() {
        return LastName;
    }

    public String getEmail() {
        return Email;
    }

    public String getNickname() {
        return nickname;
    }
}
