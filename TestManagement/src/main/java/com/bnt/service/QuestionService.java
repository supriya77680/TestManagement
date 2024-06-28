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

    public void deleteQuestion(int id){
        questionRepository.deleteById(id);
    }

    public Question updateQuestion(Integer id, Question updateQuestion){
        Optional<Question> existinqQuestion = questionRepository.findById(id);
        if(existinqQuestion.isPresent()){
            Question question = existinqQuestion.get();
            question.setQuestion(updateQuestion.getQuestion());
            question.setOption_one(updateQuestion.getOption_one());
            question.setOption_two(updateQuestion.getOption_two());
            question.setOption_three(updateQuestion.getOption_three());
            question.setOption_four(updateQuestion.getOption_four());
            question.setCorrect_option(updateQuestion.getCorrect_option());
            question.setPositive_mark(updateQuestion.getPositive_mark());
            question.setNegative_mark(updateQuestion.getNegative_mark());
            question.setSubcategory(updateQuestion.getSubcategory());
            return questionRepository.save(question);
        }
        else return null;
    }
    
}
