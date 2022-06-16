package com.example.postgresdemo.controller;

import com.example.postgresdemo.model.Image;
import com.example.postgresdemo.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class FileController {

    @Autowired
    ImageRepository imageRepository;

/*
    @GetMapping("/files/{id}")
    ResponseEntity getImage(@PathParam( id) int id){

        return null;
    }*/


    @PostMapping("/files")
    ResponseEntity<String> addImage(@RequestPart(value = "file", required = true) MultipartFile file) {

        Image x = new Image();
        try {
            x.setImage(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        imageRepository.save(x);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

}
