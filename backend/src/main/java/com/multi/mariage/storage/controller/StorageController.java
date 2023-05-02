package com.multi.mariage.storage.controller;

import com.multi.mariage.storage.dto.response.ImageSavedResponse;
import com.multi.mariage.storage.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/api/user")
@RequiredArgsConstructor
@RestController
public class StorageController {

    private final StorageService storageService;

    @PostMapping("/image")
    public ResponseEntity<ImageSavedResponse> save(@RequestParam MultipartFile file) {
        ImageSavedResponse response = storageService.save(file);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}