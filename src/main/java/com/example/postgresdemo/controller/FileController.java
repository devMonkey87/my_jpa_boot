package com.example.postgresdemo.controller;

import com.example.postgresdemo.dto.ImageDTO;
import com.example.postgresdemo.mapper.ImageMapper;
import com.example.postgresdemo.model.Image;
import com.example.postgresdemo.repository.ImageRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080"})
//From SSSS
public class FileController {
    ImageRepository imageRepository;
    ImageMapper imageMapper;

    @GetMapping("/files")
    List<ImageDTO> getImages() {
        return imageRepository.findAll()
                .stream()
                .map(imageMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/files")
    ImageDTO addImage(@RequestPart(value = "file") MultipartFile file, @RequestParam String description) throws IOException {
        return imageMapper.toDto(imageRepository.save(new Image(description, file.getBytes())));
    }
}
