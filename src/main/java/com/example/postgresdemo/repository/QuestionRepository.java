package com.example.postgresdemo.repository;

import com.example.postgresdemo.model.Question;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends GenericRepository<Question, Integer> {

}
