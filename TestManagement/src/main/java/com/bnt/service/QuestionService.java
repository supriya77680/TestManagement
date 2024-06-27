package com.bnt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnt.model.Question;
import com.bnt.repository.QuestionRepository;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public Question createQuestion(Question question) {
        return questionRepository.save(question);   
    }

    public List<Question> getAllQuestion() {
        return questionRepository.findAll();
    }

    public Optional<Question> getQuestionById(int id){
      return questionRepository.findById(id);
    }

    public Question updateQuestion(Question question){
        return questionRepository.save(question);
    }

    public void deleteQuestion(int id){
        questionRepository.deleteById(id);
    }
    
}
