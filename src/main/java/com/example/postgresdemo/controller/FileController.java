package com.example.postgresdemo.controller;

import com.example.postgresdemo.dto.ImageDTO;
import com.example.postgresdemo.mapper.CycleAvoidingMappingContext;
import com.example.postgresdemo.mapper.ImageMapper;
import com.example.postgresdemo.model.Image;
import com.example.postgresdemo.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FileController {
    @Autowired
    ImageRepository imageRepository;
    @Autowired
    ImageMapper imageMapper;

    @GetMapping("/files")
    List<ImageDTO> getImages() {
        return imageRepository.findAll().stream().map(image -> imageMapper.toDto(image, new CycleAvoidingMappingContext())).collect(Collectors.toList());
    }

    @PostMapping("/files")
    ImageDTO addImage(@RequestPart(value = "file") MultipartFile file) throws IOException {
        return imageMapper.toDto(imageRepository.save(new Image(file.getBytes())), new CycleAvoidingMappingContext());
    }

}
