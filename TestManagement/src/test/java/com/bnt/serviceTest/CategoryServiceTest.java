package com.bnt.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.bnt.model.Category;
import com.bnt.repository.CategoryRepository;
import com.bnt.service.CategoryService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {

    @Mock
    CategoryRepository categoryRepository;

    @InjectMocks
    CategoryService categoryService;

     @Test
    void testCreatecategory(){
         Category expectedResult = new Category(1, "Java", "Java Framework Category");
        when(categoryRepository.save(expectedResult)).thenReturn(expectedResult);
        Category actualResult = categoryService.createCategory(expectedResult);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGetAllcategory(){
        List<Category> category = new ArrayList();
        category.add(new Category(1, "Java", "Java Framework Category"));
        category.add(new Category(1, "Java", "Java Framework Category"));
        when(categoryRepository.findAll()).thenReturn(category);
        List<Category> actualResult = categoryService.getCategory();
        assertEquals(category, actualResult);
    }

    @Test
    void testUpdateCategory(){
        Category expectedResult = new Category(1, "Java", "Java Framework Category");
        when(categoryRepository.save(expectedResult)).thenReturn(expectedResult);
        Category actualResult = categoryService.updateCategory(expectedResult);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testDeleteCategory(){
        categoryService.deleteCategory(1);
        verify(categoryRepository).deleteById(1);
    }
    
    
}
