package com.example.postgresdemo.service.impl;

import com.example.postgresdemo.model.Question;
import com.example.postgresdemo.repository.QuestionRepository;
import com.example.postgresdemo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
            question.getAnswers().forEach((answer -> {
                answer.setQuestion(question);
            }));
            return questionRepository.save(question);
        } else {
            Question questionModel = new Question();
            questionModel.setId(question.getId());
            questionModel.setTitle(question.getTitle());
            questionModel.setDescription(question.getDescription());
            questionModel.setAnswers(question.getAnswers());
            return questionRepository.save(questionModel);
        }
    }

    @Override
    public void delete(Question question) {
        questionRepository.delete(question);
    }
}
