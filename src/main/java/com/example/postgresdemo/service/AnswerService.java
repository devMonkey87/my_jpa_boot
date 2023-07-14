package com.example.postgresdemo.service;

import com.example.postgresdemo.model.Answer;

import java.util.List;

public interface AnswerService {

    Answer findById(int id);

    List<Answer> findAll();

    Answer saveOrUpdate(Answer answer);

    void deleteById(int id);

    List<Answer> updateAll(List<Answer> list);

}
