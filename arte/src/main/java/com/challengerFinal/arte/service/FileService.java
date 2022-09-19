package com.challengerFinal.arte.service;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

@Service
public interface FileService {
    public String save(MultipartFile file, String name) throws Exception;

    public void save (List<MultipartFile> file, String name) throws  Exception;

    public String updateFile(MultipartFile file, String name) throws IOException;



}
