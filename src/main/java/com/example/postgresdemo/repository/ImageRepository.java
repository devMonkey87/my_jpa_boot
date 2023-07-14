package com.example.postgresdemo.repository;

import com.example.postgresdemo.model.Image;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends GenericRepository<Image, Integer> {

    List<Image> findAllById(int imageId);

}
