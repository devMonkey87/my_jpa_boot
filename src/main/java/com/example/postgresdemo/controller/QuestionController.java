package com.example.postgresdemo.controller;

import com.example.postgresdemo.dto.QuestionDTO;
import com.example.postgresdemo.exception.ResourceNotFoundException;
import com.example.postgresdemo.mapper.QuestionMapper;
import com.example.postgresdemo.model.Answer;
import com.example.postgresdemo.model.Question;
import com.example.postgresdemo.service.AnswerService;
import com.example.postgresdemo.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor

public class QuestionController {

    private QuestionService questionService;

    private AnswerService answerService;

    private QuestionMapper questionMapper;

    @GetMapping("/questions")
    public Page<Question> getQuestions(Pageable pageable) {
        return questionService.findAll(pageable);
    }

    @PostMapping(value = "/questions")
    public ResponseEntity<QuestionDTO> createQuestion(
            @NotNull @Valid @RequestBody Question question) {

        Question question1 = questionService.saveOrUpdate(question);
        QuestionDTO questionDTO = questionMapper.toDto(question1);

        List<Answer> mi_nueva_respuesta = question1.getAnswers()
                .stream()
                .map(answer -> {
                    answer.setText("mi nueva respuesta" + new Random().nextInt());
                    return answer;
                }).collect(Collectors.toList());

        answerService.updateAll(mi_nueva_respuesta);

        return new ResponseEntity<QuestionDTO>(questionDTO, HttpStatus.CREATED);
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
