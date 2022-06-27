package com.example.postgresdemo.controller;

import com.example.postgresdemo.dto.AnswerDTO;
import com.example.postgresdemo.exception.ResourceNotFoundException;
import com.example.postgresdemo.mapper.AnswerMapperImpl;
import com.example.postgresdemo.mapper.CycleAvoidingMappingContext;
import com.example.postgresdemo.model.Answer;
import com.example.postgresdemo.model.Question;
import com.example.postgresdemo.repository.QuestionRepository;
import com.example.postgresdemo.service.AnswerService;
import com.example.postgresdemo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerMapperImpl mapper;

    public AnswerController() {
    }

    @GetMapping("/questions/{questionId}/answers")
    public List<AnswerDTO> getAnswersByQuestionId(@PathVariable int questionId) {
        Optional<Question> question = questionService.findById(questionId);
        return question.get().getAnswers().stream().map(answer -> mapper.toDto(answer, new CycleAvoidingMappingContext())).collect(Collectors.toList());
    }

    @PostMapping("/questions/{questionId}/answers")
    public AnswerDTO addAnswer(@PathVariable Integer questionId,
                               @Valid @RequestBody Answer answer) {
        Answer answer1 = questionService.findById(questionId)
                .map(question -> {
                    answer.setQuestion(question);
                    return answerService.saveOrUpdate(answer);
                }).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + questionId));

        return mapper.toDto(answer1, new CycleAvoidingMappingContext());
    }

    @PutMapping("/answers/{answerId}")
    public AnswerDTO updateAnswer(@PathVariable int answerId,
                                  @Valid @RequestBody Answer answerRequest) {
        return mapper.toDto(answerService.saveOrUpdate(answerRequest), new CycleAvoidingMappingContext());
    }

    @DeleteMapping("/questions/{questionId}/answers/{answerId}")
    public ResponseEntity<Integer> deleteAnswer(@PathVariable Integer questionId,
                                                @PathVariable Integer answerId) {
        answerService.deleteById(answerId);

        return new ResponseEntity<Integer>(HttpStatus.NO_CONTENT);

    }
}
