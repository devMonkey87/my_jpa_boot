package com.example.postgresdemo.repository;

import com.example.postgresdemo.model.Answer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends GenericRepository<Answer, Integer> {

    List<Answer> findByQuestionId(String questionId);

    List<Answer> findAllByQuestionId(String questionId);


}
