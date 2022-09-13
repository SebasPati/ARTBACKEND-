package com.challengerFinal.arte.service.implement;

import com.challengerFinal.arte.model.UserGlobal;
import com.challengerFinal.arte.repositories.UserGlobalRepository;
import com.challengerFinal.arte.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class implementUser implements UserService {
    @Autowired
    UserGlobalRepository userGlobalRepository;

    @Override
    public List<UserGlobal> getUsers() {
        return userGlobalRepository.findAll();
    }

    @Override
    public UserGlobal getUserId(long user) {
        return userGlobalRepository.findById(user).get();
    }

    @Override
    public UserGlobal saveUser(UserGlobal user) {
        return userGlobalRepository.save(user);
    }
}
