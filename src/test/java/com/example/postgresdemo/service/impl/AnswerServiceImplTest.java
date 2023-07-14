/*
package com.example.postgresdemo.service.impl;

import com.example.postgresdemo.model.Answer;
import com.example.postgresdemo.repository.AnswerRepository;
import com.example.postgresdemo.service.AnswerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
class AnswerServiceImplTest {

    @Mock()
    AnswerRepository repository;

    @Autowired
    AnswerServiceImpl answerService;

    Answer answer;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findById() {

        AnswerRepository mock1 = Mockito.mock(AnswerRepository.class);

        Mockito.when(mock1.findById(123)).thenReturn(Optional.of(createAnswer()));


        AnswerService mock = Mockito.mock(AnswerService.class, Mockito.withSettings().verboseLogging());
        Mockito.when(mock.findById(123)).thenReturn(new Answer());


        Answer byId = answerService.findById(123);


    }


    @Test
    void findAll() {

        Mockito.when(repository.findAll()).thenReturn(List.of(new Answer("sd", null)));

        List<Answer> list = answerService.findAll();

        Mockito.verify(repository, Mockito.times(1)).findAll();
    }

    @Test
    void saveOrUpdate() {
    }

    @Test
    void deleteAndThrowException() {
        //When testing void methods, like deleteById, doThrow has to be used insetad of thenThrows
        Mockito.doReturn(false).when(repository).existsById(1);
        AnswerServiceImpl dictMock = Mockito.mock(AnswerServiceImpl.class);
        Mockito.doThrow(EntityNotFoundException.class)
                .when(dictMock)
                .deleteById(Mockito.anyInt());
    }

    @Test
    void deleteAnswer() {
        Mockito.doReturn(true).when(repository).existsById(1);
        Mockito.doNothing().when(repository).deleteById(1);

        answerService.deleteById(1);

        Mockito.verify(repository).deleteById(1);
    }

    public Answer createAnswer() {
        Answer s = new Answer();
        s.setId(123);
        s.setText("sds");
        return s;
    }
}
*/
