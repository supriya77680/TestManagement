package com.bnt.controllerTest;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.bnt.controller.CategoryController;
import com.bnt.model.Category;
import com.bnt.repository.CategoryRepository;
import com.bnt.service.CategoryService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class CategoryControllerTest {

    @Mock
    CategoryService categoryService;

    @Mock
    CategoryRepository categoryRepository;

    @InjectMocks
    CategoryController categoryController;

     @Test
    void testCreateCategory(){
        Category category = new Category(1, "Java", "Java Framework Category");
        ResponseEntity<Category> expectedResult = ResponseEntity.status(HttpStatus.CREATED).body(category);
        when(categoryService.createCategory(category)).thenReturn(category);
        ResponseEntity<Category> actualResult = categoryController.createCategory(category);
        assertEquals(expectedResult.getStatusCode(), actualResult.getStatusCode());
        assertEquals(expectedResult.getBody(), actualResult.getBody());
    }

    @Test
    void testGetAllcategory(){
        List<Category> category = new ArrayList();
        category.add(new Category(1, "Java", "Java Framework Category"));
        category.add(new Category(1, "Java", "Java Framework Category"));
        ResponseEntity<List<Category>> expectedResult = ResponseEntity.status(HttpStatus.FOUND).body(category);
        when(categoryService.getCategory()).thenReturn(category);
        ResponseEntity<List<Category>> actualResult = categoryController.getCategory();
        assertEquals(expectedResult.getStatusCode(), actualResult.getStatusCode());
        assertEquals(expectedResult.getBody(), actualResult.getBody());
    }

     @Test
    void testUpdateCategory(){
        Category category =new Category(1, "Java", "Java Framework Category");
        ResponseEntity <Category> expectedResult = ResponseEntity.status(HttpStatus.ACCEPTED).body(category);
        when(categoryService.updateCategory(category)).thenReturn(category);
        ResponseEntity <Category> actualResult = categoryController.updateCategory(1, "Java", "Java Framework Category");
        assertEquals(expectedResult.getStatusCode(), actualResult.getStatusCode());
        assertEquals(expectedResult.getBody(), actualResult.getBody());
    }

    @Test
    void testDeletecategory(){
        ResponseEntity<String> expectedResult = categoryController.deleteCategory(3);
        verify(categoryService).deleteCategory(3);
        assertEquals(HttpStatus.OK, expectedResult.getStatusCode());
        assertEquals("Deleted category with id : 3", expectedResult.getBody());

    }
    
}
