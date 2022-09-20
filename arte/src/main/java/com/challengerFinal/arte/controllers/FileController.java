package com.challengerFinal.arte.controllers;

import com.challengerFinal.arte.model.Client;
import com.challengerFinal.arte.repositories.ClientRepository;
import com.challengerFinal.arte.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/files")
public class FileController {

    @Autowired
    private FileService fileService;

    @Autowired
    private ClientRepository clientRepository;
    @PostMapping("/upload/client")
    public ResponseEntity<Object> uploadFiles(@RequestParam("files") MultipartFile file, Authentication authentication){
        try {

            if (authentication == null) {
                return new ResponseEntity<Object>("You're not logged in",HttpStatus.FORBIDDEN);
            }

            Client authClient = clientRepository.findByEmail(authentication.getName());
            String fileUrl = fileService.updateFile(file, authClient.getId().toString(), "client");
            authClient.setImage(fileUrl);
            clientRepository.save(authClient);
            return new ResponseEntity<Object>(HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/update/client")
    public ResponseEntity<Object> updateFile(@RequestParam("files") MultipartFile file){
        try {
            System.out.println(fileService.updateFile(file, "pruebaimg", ""));
            return new ResponseEntity<Object>(HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
