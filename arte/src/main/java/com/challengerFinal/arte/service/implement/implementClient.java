package com.challengerFinal.arte.service.implement;

import com.challengerFinal.arte.dtos.ClientRegisterDto;
import com.challengerFinal.arte.dtos.ClientsDto;
import com.challengerFinal.arte.dtos.ToUpdateClientsDto;
import com.challengerFinal.arte.model.Client;
import com.challengerFinal.arte.model.enums.TypeUser;
import com.challengerFinal.arte.repositories.ClientRepository;
import com.challengerFinal.arte.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class implementClient implements ClientService {
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public List<ClientsDto> getUsers() {
        // Para mostrar toda la lista de los clientes
        return clientRepository.findAll().stream().map(ClientsDto::new).collect(Collectors.toList());
    }
    @Override
    public ClientsDto getUserId(long user) {
        return clientRepository.findById(user).map(ClientsDto::new).orElse(null);
    }

    @Override
    public Client saveUser(Client user) {
        return clientRepository.save(user);
    }

    @Override
    public Client findByEmailClient(String email) {
        return clientRepository.findByEmail(email);
    }

    @Override
    public ClientsDto getClient(Authentication authentication) {
        return null;
    }

    @Override
    public ResponseEntity<Object> registerUser( ClientRegisterDto registration) {
        if (registration.getEmail().isEmpty()
        || registration.getPassword().isEmpty()
        || registration.getName().isEmpty()
        || registration.getLastName().isEmpty()){

            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        String email = registration.getEmail();

        if (clientRepository.findByEmail(email) != null) {

            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        if (registration.getTypeUser() == TypeUser.CLIENT){

            Client newClient = new Client(
                    registration.getName(),
                    registration.getLastName(),
                    registration.getEmail(),
                    registration.getTelephone(),
                    passwordEncoder.encode(registration.getPassword()),
                    TypeUser.CLIENT);
            clientRepository.save(newClient);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        else if(registration.getTypeUser() == TypeUser.ARTIST){

            Client newClient = new Client(
                    registration.getName(),
                    registration.getLastName(),
                    registration.getNickname(),
                    registration.getEmail(),
                    registration.getTelephone(),
                    passwordEncoder.encode(registration.getPassword()),
                    TypeUser.ARTIST, registration.getDirection(),
                    registration.getNetworks());

            clientRepository.save(newClient);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> patchClient(Long id, ToUpdateClientsDto toUpdateClientsDto) {
        Client clientToUpdate = clientRepository.findById(id).orElse(null);
        if (clientToUpdate == null) {
            return new ResponseEntity<>("The client not found: " + clientToUpdate,HttpStatus.FORBIDDEN);
        }else {
            if (clientToUpdate.getName() != null) {
                clientToUpdate.setName(toUpdateClientsDto.getName());
            }
            if (clientToUpdate.getLastName() != null) {
                clientToUpdate.setLastName(toUpdateClientsDto.getLastName());
            }
            if (clientToUpdate.getNickname() != null) {
                clientToUpdate.setNickname(toUpdateClientsDto.getNickname());
            }
            if (clientToUpdate.getEmail() != null) {
                clientToUpdate.setEmail(toUpdateClientsDto.getEmail());
            }
            if (clientToUpdate.getTelephone() != null) {
                clientToUpdate.setTelephone(toUpdateClientsDto.getTelephone());
            }
            if (clientToUpdate.getPassword() != null) {
                clientToUpdate.setPassword(toUpdateClientsDto.getPassword());
            }
            if (clientToUpdate.getTypeUser() != null) {
                clientToUpdate.setTypeUser(toUpdateClientsDto.getTypeUser());
            }
            if (clientToUpdate.getDirection() != null) {
                clientToUpdate.setDirection(toUpdateClientsDto.getAddress());
            }
            if (clientToUpdate.getNetworks() != null) {
                clientToUpdate.setNetworks(toUpdateClientsDto.getNetworks());
            }
            this.clientRepository.save(clientToUpdate);
        }

        return new ResponseEntity<>("Client to update "+clientToUpdate,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> patchClient(Authentication authentication, ToUpdateClientsDto toUpdateClientsDto) {
        return null;
    }

    @Override
    public ResponseEntity<Object> deleteClient(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Object> deleteClientCurrent(Authentication authentication) {
        return null;
    }
}
