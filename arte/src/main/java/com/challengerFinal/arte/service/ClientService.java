package com.challengerFinal.arte.service;

import com.challengerFinal.arte.dtos.ClientRegisterDto;
import com.challengerFinal.arte.dtos.ClientsDto;
import com.challengerFinal.arte.dtos.ToUpdateClientsDto;
import com.challengerFinal.arte.model.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ClientService {
    List<ClientsDto> getUsers();
    public ClientsDto getUserId(long userId);
    Client saveUser(Client client);
    Client findByEmailClient(String email);
    ClientsDto getClient(Authentication authentication);
    ResponseEntity<Object> registerUser(ClientRegisterDto registration);
    ResponseEntity<Object> patchClient(Long id, ToUpdateClientsDto toUpdateClientsDto);
    ResponseEntity<Object> patchClient(Authentication authentication, ToUpdateClientsDto toUpdateClientsDto);
    ResponseEntity<Object> deleteClient(@PathVariable("id") Long id);
    ResponseEntity<Object> deleteClientCurrent(Authentication authentication);
}
