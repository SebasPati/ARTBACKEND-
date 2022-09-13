package com.challengerFinal.arte.service.implement;

import com.challengerFinal.arte.model.Artist;
import com.challengerFinal.arte.repositories.ArtistRepository;
import com.challengerFinal.arte.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistImplement implements ArtistService {
    @Autowired
    ArtistRepository artistRepository;

    @Override
    public List<Artist> getUsers() {
        return artistRepository.findAll();
    }

    @Override
    public Artist getUserId(long user) {
        return artistRepository.findById(user).get();
    }

    @Override
    public Artist saveUser(Artist user) {
        return artistRepository.save(user);
    }

}
