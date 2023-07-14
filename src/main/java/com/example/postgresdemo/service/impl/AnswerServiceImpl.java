package com.example.postgresdemo.service.impl;

import com.example.postgresdemo.model.Answer;
import com.example.postgresdemo.repository.AnswerRepository;
import com.example.postgresdemo.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    AnswerRepository answerRepository;

    @Override
    public Answer findById(int id) {
        return answerRepository.findById(id).get();
    }

    @Override
    public List<Answer> findAll() {
        return answerRepository.findAll();
    }

    @Override
    public Answer saveOrUpdate(Answer answer) {
        if (!answerRepository.existsById(answer.getId())) return answerRepository.save(answer);
        else {
            Answer answer1 = new Answer();
            answer1.setQuestion(answer.getQuestion());
            answer1.setText(answer.getText());
            return answerRepository.save(answer1);
        }
    }

    @Override
    public void deleteById(int id) {

        if (!answerRepository.existsById(id))
            throw new EntityNotFoundException("The entity with provided ID does not exists");
        answerRepository.deleteById(id);
    }

    @Override
    public List<Answer> updateAll(List<Answer> list) {

    /*    List<Answer> entregar = new ArrayList<>();
        for (Answer answer : list) {
            Answer save = answerRepository.save(answer);
            entregar.add(save);

        }*/


        return answerRepository.saveAll(list);
    }
}
