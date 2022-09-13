package com.challengerFinal.arte.service;

import com.challengerFinal.arte.model.UserGlobal;

import java.util.List;

public interface UserService {
    List<UserGlobal> getUsers();
    public UserGlobal getUserId(long userId);
    UserGlobal saveUser(UserGlobal user);
}
