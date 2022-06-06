package com.example.postgresdemo.controller;

import com.example.postgresdemo.dto.AnswerDTO;
import com.example.postgresdemo.exception.ResourceNotFoundException;
import com.example.postgresdemo.mapper.AnswerMapperImpl;
import com.example.postgresdemo.model.Answer;
import com.example.postgresdemo.repository.QuestionRepository;
import com.example.postgresdemo.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



import javax.validation.Valid;

@RestController
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @Autowired
    private QuestionRepository questionService;

    @Autowired
    private AnswerMapperImpl mapper;

    /*
    @GetMapping("/questions/{questionId}/answers")
    public List<Answer> getAnswersByQuestionId(@PathVariable int questionId) {
        return answerService.findById(questionId);
    }*/

    @PostMapping("/questions/{questionId}/answers")
    public AnswerDTO addAnswer(@PathVariable Integer questionId,
                               @Valid @RequestBody Answer answer) {
        Answer answer1 = answerService.findById(questionId)
                .map(question -> {
                    answer.setQuestion(question);
                    return answerService.saveOrUpdate(answer);
                }).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + questionId));

        return mapper.toDto(answer1);
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
