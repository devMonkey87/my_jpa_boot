package com.example.postgresdemo.service;

import com.example.postgresdemo.model.Answer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AnswerService {

    Answer findById(int id);

    List<Answer> findAll();

    Answer saveOrUpdate(Answer answer);

}
