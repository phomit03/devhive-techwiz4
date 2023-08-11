package com.example.devhive_backend.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class UploadImage {
    private final String UPLOAD_FOLDER = "C:\\Users\\nguye\\OneDrive\\Desktop\\techwiz4\\devhive-techwiz4\\backend\\devhive_backend\\src\\main\\resources\\image";

    public String uploadImage(MultipartFile image) {
        try {
            String fileName = image.getOriginalFilename();
            String filePath = UPLOAD_FOLDER + File.separator + fileName;
            Files.copy(image.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
            return "/uploaded-images/" + fileName;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
