package com.bnt.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.bnt.model.Question;
import com.bnt.repository.QuestionRepository;
import com.bnt.service.QuestionService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ServiceTest {

    @Mock
    QuestionRepository questionRepository;

    @InjectMocks
    QuestionService questionService;

    @Test
    void testCreateQuestion(){
        Question expectedResult = new Question(1, "SpringBoot", "In Spring Boot @RestController annotation is equivalent to", "@Controller and @PostMapping", "@Controller and @Component", "@Controller and @ResponseBody", "@Controller and @ResponseStatus","@Controller and @ResponseBody","3", "-1");
        when(questionRepository.save(expectedResult)).thenReturn(expectedResult);
        Question actualResult = questionService.createQuestion(expectedResult);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGetAllQuestion(){
        List<Question> question = new ArrayList();
        question.add(new Question(1, "SpringBoot", "In Spring Boot @RestController annotation is equivalent to", "@Controller and @PostMapping", "@Controller and @Component", "@Controller and @ResponseBody", "@Controller and @ResponseStatus","@Controller and @ResponseBody","3", "-1"));
        question.add(new Question(2, "Java", "Which of this is not a keyword", "final", "static", "null", "this","null","3", "-1"));
        when(questionRepository.findAll()).thenReturn(question);
        List<Question> actualResult = questionService.getAllQuestion();
        assertEquals(question, actualResult);
    }

    @Test
    void testGetQuestionById(){
        Optional<Question> question = Optional.of(new Question(1, "SpringBoot", "In Spring Boot @RestController annotation is equivalent to", "@Controller and @PostMapping", "@Controller and @Component", "@Controller and @ResponseBody", "@Controller and @ResponseStatus","@Controller and @ResponseBody","3", "-1"));
        when(questionRepository.findById(1)).thenReturn(question);
        Optional<Question> actualResult = questionService.getQuestionById(1);
        assertEquals(question, actualResult);
    }

    @Test
    void testUpdateQuestion(){
        Question expectedResult = new Question(1, "SpringBoot", "In Spring Boot @RestController annotation is equivalent to", "@Controller and @PostMapping", "@Controller and @Component", "@Controller and @ResponseBody", "@Controller and @ResponseStatus","@Controller and @ResponseBody","3", "-1");
        when(questionRepository.save(expectedResult)).thenReturn(expectedResult);
        Question actualResult = questionService.updateQuestion(expectedResult);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testDeleteQuestion(){
    //    when(questionRepository.existsById(1)).thenReturn(true);
        questionService.deleteQuestion(1);
        verify(questionRepository).deleteById(1);
    }
    
}
