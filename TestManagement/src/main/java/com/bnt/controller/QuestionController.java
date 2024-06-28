package com.bnt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bnt.model.Question;
import com.bnt.service.QuestionService;

@RestController
@RequestMapping("/mcq")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping("/createQuestion")
    public ResponseEntity<Question> createQuestion(@RequestBody Question question){
        Question createQuestion = questionService.createQuestion(question);
        return ResponseEntity.status(HttpStatus.CREATED).body(createQuestion);
    }

    @GetMapping("/getAllQuestion")
    public ResponseEntity<List<Question>> getAllQuestion(){
        List<Question> getAllQuestion = questionService.getAllQuestion();
        return ResponseEntity.status(HttpStatus.FOUND).body(getAllQuestion);
    }

    @GetMapping("/getQuestion/{id}")
    public ResponseEntity <Optional<Question>> getQuestionById(@PathVariable int id){
        Optional<Question> getQuestionById = questionService.getQuestionById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(getQuestionById);
    }

    @PutMapping("/updateQuestion/{id}")
    public Question updateQuestion(@PathVariable("id") int id,@RequestBody Question question){
        return questionService.updateQuestion(id, question);
    }

    @DeleteMapping("/deleteQuestion/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable int id){
        questionService.deleteQuestion(id);
        return ResponseEntity.ok("Deleted the question with id : " + id);
    }

   
}
