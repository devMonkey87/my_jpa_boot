package com.example.postgresdemo.service;

import com.example.postgresdemo.model.Type;

import java.util.List;

public interface DataService {

    List<Type> getAllTypes();

    Type findTypeById(Integer id);
}
