package com.example.postgresdemo.controller;

import com.example.postgresdemo.dto.TypeIconDTO;
import com.example.postgresdemo.mapper.TypeIconMapper;
import com.example.postgresdemo.model.TypeIcon;
import com.example.postgresdemo.repository.TypeIconRepository;
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
public class TypeIconController {
    TypeIconRepository typeIconRepository;
    TypeIconMapper iconMapper;

    @GetMapping("/icons")
    List<TypeIconDTO> getImages() {
        return typeIconRepository.findAll()
                .stream()
                .map(iconMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/icons")
    TypeIconDTO addIcon(@RequestPart(value = "file") MultipartFile file) throws IOException {
        return iconMapper.toDto(typeIconRepository.save(new TypeIcon(file.getBytes())));
    }
}
