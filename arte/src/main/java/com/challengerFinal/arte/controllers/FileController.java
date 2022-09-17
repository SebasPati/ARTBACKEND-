package com.challengerFinal.arte.controllers;

import com.challengerFinal.arte.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/files")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<Object> uploadFiles(@RequestParam("files") List<MultipartFile> files){
        try {
            fileService.save(files);
            return new ResponseEntity<Object>(HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{filename:.+}")
    public ResponseEntity<String> getFile(@PathVariable String filename) throws Exception{
        Resource resource = fileService.load(filename);
        ResponseEntity<String> response = new ResponseEntity<String>(resource.getFile().toString(), new HttpHeaders(), HttpStatus.OK);
        return response;
    }
}
