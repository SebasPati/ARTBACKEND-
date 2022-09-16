package com.challengerFinal.arte.service;

import com.challengerFinal.arte.model.Client;

import java.util.List;

public interface ClientService {
    List<Client> getUsers();
    public Client getUserId(long userId);
    Client saveUser(Client client);
    Client findByEmailClient(String email);
}
