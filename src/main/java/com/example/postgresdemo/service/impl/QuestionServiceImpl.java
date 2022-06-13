package com.example.postgresdemo.service.impl;

import com.example.postgresdemo.model.Answer;
import com.example.postgresdemo.model.Question;
import com.example.postgresdemo.repository.QuestionRepository;
import com.example.postgresdemo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    @Override
    public Optional<Question> findById(int id) {
        return questionRepository.findById(Integer.valueOf(id));
    }

    @Override
    public Page<Question> findAll(Pageable pageable) {
        return questionRepository.findAll(pageable);
    }

    @Override
    public Question saveOrUpdate(Question question) {
        if (!questionRepository.existsById(question.getId())) {
            question.setCreatedAt(new Date());
            question.setUpdatedAt(question.getCreatedAt());
            question.getAnswers().forEach((answer -> {
                answer.setCreatedAt(new Date());
                answer.setUpdatedAt(question.getCreatedAt());
                answer.setQuestion(question);
            }));
            return questionRepository.save(question);
        } else {
            Question questionModel = new Question();
            questionModel.setId(question.getId());
            questionModel.setTitle(question.getTitle());
            questionModel.setDescription(question.getDescription());
            questionModel.setUpdatedAt(new Date());
            questionModel.setCreatedAt(question.getCreatedAt());
            question.getAnswers().forEach(answer -> answer.setUpdatedAt(new Date()));
            questionModel.setAnswers(question.getAnswers());
            return questionRepository.save(questionModel);
        }
    }

    @Override
    public void delete(Question question) {
        questionRepository.delete(question);
    }
}
