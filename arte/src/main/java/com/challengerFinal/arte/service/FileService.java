package com.challengerFinal.arte.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface FileService {
    public String saveFile(MultipartFile file, String name, String directory) throws Exception;

    public String updateFile(MultipartFile file, String name, String directory) throws Exception;



}
