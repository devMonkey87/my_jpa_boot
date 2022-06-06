package com.example.postgresdemo.service.impl;

import com.example.postgresdemo.model.Answer;
import com.example.postgresdemo.model.Question;
import com.example.postgresdemo.repository.QuestionRepository;
import com.example.postgresdemo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
            Question question1 = new Question();
            question1.setId(question.getId());
            question1.setTitle(question.getTitle());
            question1.setDescription(question.getDescription());
            question1.setUpdatedAt(new Date());
            question1.setCreatedAt(question.getCreatedAt());
            return questionRepository.save(question1);
        }
    }

    @Override
    public void delete(Question question) {
        questionRepository.delete(question);
    }
}
