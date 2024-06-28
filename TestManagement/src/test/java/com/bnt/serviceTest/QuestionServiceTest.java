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

import com.bnt.model.Category;
import com.bnt.model.Question;
import com.bnt.model.Subcategory;
import com.bnt.repository.QuestionRepository;
import com.bnt.service.QuestionService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class QuestionServiceTest {

    @Mock
    QuestionRepository questionRepository;

    @InjectMocks
    QuestionService questionService;

    @Test
    void testCreateQuestion(){
         Question expectedResult = new Question(1, "In Spring Boot @RestController annotation is equivalent to", "@Controller and @PostMapping", "@Controller and @Component", "@Controller and @ResponseBody", "@Controller and @ResponseStatus","@Controller and @ResponseBody","3", "-1",new Subcategory(1, "Exception Handling", "Exception Handling Form in java", new Category(1, "Java", "Core java Category")));
       when(questionRepository.save(expectedResult)).thenReturn(expectedResult);
        Question actualResult = questionService.createQuestion(expectedResult);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGetAllQuestion(){
        List<Question> question = new ArrayList();
        question.add(new Question(1, "In Spring Boot @RestController annotation is equivalent to", "@Controller and @PostMapping", "@Controller and @Component", "@Controller and @ResponseBody", "@Controller and @ResponseStatus","@Controller and @ResponseBody","3", "-1",new Subcategory(1, "Exception Handling", "Exception Handling Form in java", new Category(1, "Java", "Core java Category"))));
        question.add(new Question(1, "In Spring Boot @RestController annotation is equivalent to", "@Controller and @PostMapping", "@Controller and @Component", "@Controller and @ResponseBody", "@Controller and @ResponseStatus","@Controller and @ResponseBody","3", "-1",new Subcategory(1, "Exception Handling", "Exception Handling Form in java", new Category(1, "Java", "Core java Category"))));
        when(questionRepository.findAll()).thenReturn(question);
        List<Question> actualResult = questionService.getAllQuestion();
        assertEquals(question, actualResult);
    }

    @Test
    void testGetQuestionById(){
        Optional<Question> question = Optional.of(new Question(1, "In Spring Boot @RestController annotation is equivalent to", "@Controller and @PostMapping", "@Controller and @Component", "@Controller and @ResponseBody", "@Controller and @ResponseStatus","@Controller and @ResponseBody","3", "-1",new Subcategory(1, "Exception Handling", "Exception Handling Form in java", new Category(1, "Java", "Core java Category"))));
        when(questionRepository.findById(1)).thenReturn(question);
        Optional<Question> actualResult = questionService.getQuestionById(1);
        assertEquals(question, actualResult);
    }

    @Test
    void testUpdateQuestion() {
        Question expectedResult = new Question(1, "In Spring Boot @RestController annotation is equivalent to", "@Controller and @PostMapping","@Controller and @Component","@Controller and @ResponseBody","@Controller and @ResponseStatus","@Controller and @ResponseBody","3","-1",new Subcategory(1, "Exception Handling", "Exception Handling Form in java", new Category(1, "Java", "Core java Category")));
        when(questionRepository.save((expectedResult))).thenReturn(expectedResult);
        Question actualResult = questionService.updateQuestion(1, expectedResult);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testDeleteQuestion(){
        questionService.deleteQuestion(1);
        verify(questionRepository).deleteById(1);
    }
    
}
