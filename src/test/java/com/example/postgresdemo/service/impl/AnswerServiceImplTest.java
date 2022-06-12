package com.example.postgresdemo.service.impl;

import com.example.postgresdemo.model.Answer;
import com.example.postgresdemo.model.Question;
import com.example.postgresdemo.repository.AnswerRepository;
import com.example.postgresdemo.service.AnswerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class AnswerServiceImplTest {

    @MockBean
    AnswerRepository repository;

    @Autowired
    AnswerService answerService;

    Answer answer;
    @BeforeEach
    void setUp() {
        this.answer = new Answer(1, "Test", new Question(1, "Test", "Test", new ArrayList<>()));
    }

    @Test
    void findById() {

        Mockito.when(repository.findById(1)).thenReturn(new Answer());

        Answer byId = answerService.findById(1);

        Mockito.verify(repository, Mockito.times(1)).findById(1);

    }

    @Test
    void findAll() {

        Mockito.when(repository.findAll()).thenReturn(new ArrayList<>());

        List<Answer> list =  answerService.findAll();

        Mockito.verify(repository, Mockito.times(1)).findAll();
    }

    @Test
    void saveOrUpdate() {
    }

    @Test
    void deleteAndThrowException() {
    }

    @Test
    void deleteAnswer() {
        Mockito.doReturn(true).when(repository).existsById(1);
        Mockito.doNothing().when(repository).deleteById(1);

        answerService.deleteById(1);

        Mockito.verify(repository).deleteById(1);
    }
}