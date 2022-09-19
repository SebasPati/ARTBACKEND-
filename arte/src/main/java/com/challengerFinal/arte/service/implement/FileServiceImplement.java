package com.challengerFinal.arte.service.implement;

import com.challengerFinal.arte.service.FileService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Stream;

import org.apache.commons.io.FilenameUtils;
@Service
public class FileServiceImplement implements FileService {

    private final Path rootFolder = Paths.get("src/main/resources/static/images");

    @Override
    public String save(MultipartFile file, String name) throws Exception {
        String serverUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
        String fileName = name + "." + FilenameUtils.getExtension(file.getOriginalFilename());
        System.out.println(serverUrl + "/images/" + fileName);
        System.out.println(file.getOriginalFilename());
        if(!file.getContentType().contains("image")) {
            return null;
        }
        Files.copy(file.getInputStream(), rootFolder.resolve(fileName));
        return serverUrl + "/images/" + fileName;
    }

    @Override
    public void save(List<MultipartFile> files, String name) throws Exception {
        for (MultipartFile file : files) {
            this.save(file, name);
        }
    }

    @Override
    public String updateFile(MultipartFile file, String name) throws IOException {
        String fileName = name + "." + FilenameUtils.getExtension(file.getOriginalFilename());
        Files.deleteIfExists(rootFolder.resolve(fileName));
        
        return null;
    }

}
