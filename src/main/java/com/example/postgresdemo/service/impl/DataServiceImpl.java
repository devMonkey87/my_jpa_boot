package com.example.postgresdemo.service.impl;

import com.example.postgresdemo.model.Type;
import com.example.postgresdemo.repository.DataRepository;
import com.example.postgresdemo.service.DataService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DataServiceImpl implements DataService {

    DataRepository dataRepository;

    @Override
    public List<Type> getAllTypes() {
        return dataRepository.findAll();
    }

    @Override
    public Type findTypeById(Integer id) {
        return dataRepository.getById(id);
    }
}
