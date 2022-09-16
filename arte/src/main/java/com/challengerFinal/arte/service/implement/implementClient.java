package com.challengerFinal.arte.service.implement;

import com.challengerFinal.arte.model.Client;
import com.challengerFinal.arte.repositories.ClientRepository;
import com.challengerFinal.arte.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class implementClient implements ClientService {
    @Autowired
    ClientRepository clientRepository;

    @Override
    public List<Client> getUsers() {
        return clientRepository.findAll();
    }

    @Override
    public Client getUserId(long user) {
        return clientRepository.findById(user).get();
    }

    @Override
    public Client saveUser(Client user) {
        return clientRepository.save(user);
    }

    @Override
    public Client findByEmailClient(String email) {
        return clientRepository.findByEmail(email);
    }
}
