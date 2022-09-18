package com.challengerFinal.arte.service.implement;

import com.challengerFinal.arte.dtos.ClientRegisterDto;
import com.challengerFinal.arte.dtos.ClientsDto;
import com.challengerFinal.arte.dtos.ToUpdateClientsDto;
import com.challengerFinal.arte.model.Client;
import com.challengerFinal.arte.model.Product;
import com.challengerFinal.arte.model.enums.TypeUser;
import com.challengerFinal.arte.repositories.ClientRepository;
import com.challengerFinal.arte.repositories.ProductRepository;
import com.challengerFinal.arte.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class implementClient implements ClientService {
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<ClientsDto> getUsers() {
        // Para mostrar toda la lista de los clientes
        return clientRepository.findAll().stream().map(ClientsDto::new).collect(Collectors.toList());
    }
    @Override
    public ClientsDto getUserId(Long user) {
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
        Client client = this.clientRepository.findByEmail(authentication.getName());
        return new ClientsDto(client);
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

            Client newClient = new Client(
                    registration.getName(),
                    registration.getLastName(),
                    registration.getEmail(),
                    passwordEncoder.encode(registration.getPassword()));

            clientRepository.save(newClient);
            return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @Override
    public ResponseEntity<Object> patchClient(Long id,
                                              ToUpdateClientsDto toUpdateClientsDto) {
        Client clientToUpdate = clientRepository.findById(id).orElse(null);
        if (clientToUpdate == null) {
            return new ResponseEntity<>("The client not found: " + clientToUpdate,HttpStatus.FORBIDDEN);
        }
        else {
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
    public ResponseEntity<Object> patchClientCurrent(Authentication authentication,
                                                     ToUpdateClientsDto toUpdateClientsDto) {
        Client clientToUpdate = clientRepository.findByEmail(authentication.getName());
        if (clientToUpdate == null) {
            return new ResponseEntity<>("Client to update "+clientToUpdate,HttpStatus.FORBIDDEN);
        }
        else {
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
        return new ResponseEntity<>("Client to update "+clientToUpdate,HttpStatus.CREATED);
    }
    @Override
    public ResponseEntity<Object> deleteClient(Long id) {
        Client deleteClient = clientRepository.findById(id).orElse(null);
        if (deleteClient == null) {
            return new ResponseEntity<>("Client to delete "+deleteClient,HttpStatus.FORBIDDEN);
        }else {
            Product product = productRepository.findById(id).orElse(null);
            clientRepository.deleteById(deleteClient.getId());
        }
        return new ResponseEntity<>("Client to delete "+id,HttpStatus.OK);
    }
    @Override
    public ResponseEntity<Object> deleteClientCurrent(Authentication authentication) {
        Client deleteClient = clientRepository.findByEmail(authentication.getName());
        if (deleteClient == null) {
            return new ResponseEntity<>("El cliente indicado no existe", HttpStatus.FORBIDDEN);
        } else {

            clientRepository.deleteById(deleteClient.getId());
        }
        return new ResponseEntity<>("Cliente eliminado", HttpStatus.OK);
    }
}
