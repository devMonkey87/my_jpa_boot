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
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.Collections;
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

        AnswerDTO answerDTO = mapper.toDto(answer1, new CycleAvoidingMappingContext());

        return new AnswerDTO();
    }
//
//    @PutMapping("/questions/{questionId}/answers/{answerId}")
//    public Answer updateAnswer(@PathVariable Long questionId,
//                               @PathVariable Long answerId,
//                               @Valid @RequestBody Answer answerRequest) {
//        if(!questionRepository.existsById(questionId)) {
//            throw new ResourceNotFoundException("Question not found with id " + questionId);
//        }
//
//        return answerRepository.findById(answerId)
//                .map(answer -> {
//                    answer.setText(answerRequest.getText());
//                    return answerRepository.save(answer);
//                }).orElseThrow(() -> new ResourceNotFoundException("Answer not found with id " + answerId));
//    }
//
//    @DeleteMapping("/questions/{questionId}/answers/{answerId}")
//    public ResponseEntity<?> deleteAnswer(@PathVariable Long questionId,
//                                          @PathVariable Long answerId) {
//        if(!questionRepository.existsById(questionId)) {
//            throw new ResourceNotFoundException("Question not found with id " + questionId);
//        }
//
//        return answerRepository.findById(answerId)
//                .map(answer -> {
//                    answerRepository.delete(answer);
//                    return ResponseEntity.ok().build();
//                }).orElseThrow(() -> new ResourceNotFoundException("Answer not found with id " + answerId));
//
//    }
}
