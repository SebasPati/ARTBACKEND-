package com.challengerFinal.arte.service.implement;

import com.challengerFinal.arte.service.FileService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Stream;

@Service
public class FileServiceImplement implements FileService {

    private final Path rootFolder = Paths.get("src/main/resources/static/images");

    @Override
    public void save(MultipartFile file) throws Exception {
        System.out.println(file.getContentType());
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        Files.copy(file.getInputStream(), rootFolder.resolve(timeStamp));
    }

    @Override
    public Resource load(String name) throws Exception {
        Path file = rootFolder.resolve(name);
        Resource resource = new UrlResource(file.toUri());
        return resource;
    }

    @Override
    public void save(List<MultipartFile> files) throws Exception {
        for (MultipartFile file : files) {
            this.save(file);
        }
    }

    @Override
    public Stream<Path> loadAll() throws Exception {
        return null;
    }
}
