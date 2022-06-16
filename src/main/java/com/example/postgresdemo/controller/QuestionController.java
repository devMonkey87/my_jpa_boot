package com.example.postgresdemo.controller;

import com.example.postgresdemo.dto.QuestionDTO;
import com.example.postgresdemo.exception.ResourceNotFoundException;
import com.example.postgresdemo.mapper.CycleAvoidingMappingContext;
import com.example.postgresdemo.mapper.QuestionMapper;
import com.example.postgresdemo.model.Question;
import com.example.postgresdemo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuestionMapper questionMapper;

    @GetMapping("/questions")
    public Page<Question> getQuestions(Pageable pageable) {
        return questionService.findAll(pageable);
    }


    @PostMapping(value = "/questions")
    public QuestionDTO createQuestion(
            @NotNull @Valid @RequestBody Question question) {

        Question question1 = questionService.saveOrUpdate(question);
        QuestionDTO questionDTO = questionMapper.toDto(question1, new CycleAvoidingMappingContext());
        return questionDTO;
    }

    @PutMapping("/questions/{questionId}")
    public Question updateQuestion(@PathVariable Integer questionId,
                                   @Valid @RequestBody Question questionRequest) {
        return questionService.findById(questionId)
                .map(question -> {
                    question.setTitle(questionRequest.getTitle());
                    question.setDescription(questionRequest.getDescription());
                    question.setAnswers(questionRequest.getAnswers());
                    return questionService.saveOrUpdate(question);
                }).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + questionId));
    }

    @DeleteMapping("/questions/{questionId}")
    public ResponseEntity<?> deleteQuestion(@PathVariable Integer questionId) {
        return questionService.findById(questionId)
                .map(question -> {
                    questionService.delete(question);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + questionId));
    }


}
