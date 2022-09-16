package com.challengerFinal.arte.controllers;

import com.challengerFinal.arte.dtos.ClientsDto;
import com.challengerFinal.arte.dtos.ClientRegisterDto;
import com.challengerFinal.arte.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api")
public class ClientController {
    @Autowired
    ClientService clientService;
    @GetMapping("/clients")
    public List<ClientsDto> getClientsAll() {
        return clientService.getUsers().stream().map(ClientsDto::new).collect(Collectors.toList());
    }
    @PostMapping("/client/current")
    public ResponseEntity<Object> registerUser(@RequestBody ClientRegisterDto user){
        return new ResponseEntity<Object>(HttpStatus.CREATED);
    }

}
