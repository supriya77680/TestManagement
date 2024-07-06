package com.bnt.controllerTest;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.bnt.controller.SubcategoryController;
import com.bnt.model.Category;
import com.bnt.model.Subcategory;
import com.bnt.repository.SubcategoryRepository;
import com.bnt.service.serviceImpl.SubcategoryServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class SubcategoryControllerTest {
    
    @Mock
    SubcategoryServiceImpl subcategoryService;

    @Mock
    SubcategoryRepository subcategoryRepository;

    @InjectMocks
    SubcategoryController subcategoryController;

      @Test
    void testCreateSubcategory(){
        Subcategory subcategory = new Subcategory(1, "Annotation", "Annotation in Spring", new Category(1, "Springboot", "Springboot Framework"));
        ResponseEntity<Subcategory> expectedResult = ResponseEntity.status(HttpStatus.CREATED).body(subcategory);
        when(subcategoryService.createSubcategory(subcategory)).thenReturn(subcategory);
        ResponseEntity<Subcategory> actualResult = subcategoryController.createSubcategory(subcategory);
        assertEquals(expectedResult.getStatusCode(), actualResult.getStatusCode());
        assertEquals(expectedResult.getBody(), actualResult.getBody());
    }

    @Test
    void testGetAllSubcategory(){
        List<Subcategory> subcategory = new ArrayList();
        subcategory.add(new Subcategory(1, "Annotation", "Annotation in Spring", new Category(1, "Springboot", "Springboot Framework")));
        subcategory.add(new Subcategory(1, "Annotation", "Annotation in Spring", new Category(1, "Springboot", "Springboot Framework")));
        ResponseEntity<List<Subcategory>> expectedResult = ResponseEntity.status(HttpStatus.FOUND).body(subcategory);
        when(subcategoryService.getSubcategory()).thenReturn(subcategory);
        ResponseEntity<List<Subcategory>> actualResult = subcategoryController.getSubcategory();
        assertEquals(expectedResult.getStatusCode(), actualResult.getStatusCode());
        assertEquals(expectedResult.getBody(), actualResult.getBody());
    }

    @Test
    void testUpdateSubcategory() {
        int subcategoryId = 1;
        Subcategory updatedSubcategory = new Subcategory(subcategoryId, "Updated Annotation", "Updated Annotation in Spring", new Category(1, "Springboot", "Springboot Framework"));
        when(subcategoryService.updateSubcategory(subcategoryId, updatedSubcategory)).thenReturn(updatedSubcategory);
        ResponseEntity<Subcategory> actualaresult = subcategoryController.updateSubCategory(subcategoryId, updatedSubcategory);
        assertEquals(HttpStatus.ACCEPTED, actualaresult.getStatusCode());
        assertEquals(updatedSubcategory, actualaresult.getBody());
    }

    @Test
    void testDeletesubcategory(){
        ResponseEntity<String> expectedResult = subcategoryController.deleteSubcategory(3);
        verify(subcategoryService).deleteSubcategory(3);
        assertEquals(HttpStatus.OK, expectedResult.getStatusCode());
        assertEquals("Deleted subcategory with id : 3", expectedResult.getBody());
    }
    
}
