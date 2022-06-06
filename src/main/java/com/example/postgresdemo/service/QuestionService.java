package com.example.postgresdemo.service;

import com.example.postgresdemo.model.Answer;
import com.example.postgresdemo.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface QuestionService {

    Optional<Question> findById(int id);

    Page<Question> findAll(Pageable pageable);

    Question saveOrUpdate(Question question);

    void delete(Question question);
}
