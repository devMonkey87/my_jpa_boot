package com.example.postgresdemo.controller;

import com.example.postgresdemo.dto.TypeDto;
import com.example.postgresdemo.mapper.DataMapper;
import com.example.postgresdemo.service.DataService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080"})
public class DataController {
    private DataService dataService;
    private DataMapper mapper;

    @GetMapping("/types")
    public List<TypeDto> getAllTypes() {
        return dataService.getAllTypes()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

}
