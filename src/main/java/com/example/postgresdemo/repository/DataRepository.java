package com.example.postgresdemo.repository;

import com.example.postgresdemo.model.Type;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends GenericRepository<Type, Integer> {
}
