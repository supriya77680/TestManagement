package com.bnt.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bnt.model.Category;
import com.bnt.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/createCategory")
    public ResponseEntity<Category> createCategory(@RequestBody Category category){
        Category createCategory = categoryService.createCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(createCategory);
    }

    @GetMapping("/getCategory")
    public ResponseEntity<List<Category>> getCategory(){
        List<Category> getCategory = categoryService.getCategory();
        return ResponseEntity.status(HttpStatus.FOUND).body(getCategory);
    }

    @PutMapping("/updateCategory/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable int id, @RequestParam String category_name, @RequestParam String category_description ){
        Category category = new Category(id, category_name, category_description);
        Category updatedCategory = categoryService.updateCategory(category);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedCategory);
    } 
    
    @DeleteMapping("/deleteCategory/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable int id){
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("Deleted category with id : " + id);
    }
}
