package com.challengerFinal.arte.controllers;

import com.challengerFinal.arte.model.Client;
import com.challengerFinal.arte.repositories.ClientRepository;
import com.challengerFinal.arte.service.ClientService;
import com.challengerFinal.arte.service.FileService;
import com.challengerFinal.arte.service.ServiceProduct;
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
    ClientService clientService;

    @Autowired
    ServiceProduct serviceProduct;

    @PostMapping("/upload/client")
    public ResponseEntity<Object> uploadFile(@RequestParam("files") MultipartFile file, Authentication authentication){
        return clientService.uploadFile(file, authentication);
    }



}
