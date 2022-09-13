package com.challengerFinal.arte.service;

import com.challengerFinal.arte.model.Artist;

import java.util.List;

public interface ArtistService {
    List<Artist> getUsers();
    public Artist getUserId(long userId);
    Artist saveUser(Artist user);
}
