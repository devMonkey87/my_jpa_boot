package com.example.postgresdemo.repository;

import com.example.postgresdemo.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {
    List<Answer> findByQuestionId(int questionId);

    Optional<Answer> findById(Integer integer);

    Answer findById(int id);
}
