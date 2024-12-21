package com.mie.quickshop.service.file;

import com.mie.quickshop.model.CustomFile;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface CustomFileServiceI {

    List<CustomFile> getAllFiles();

    Optional<CustomFile> saveFile(MultipartFile file);

    CustomFile getFileById(UUID id);





}
