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
import com.bnt.model.Subcategory;
import com.bnt.service.SubcategoryService;

@RestController
@RequestMapping("/subcategory")
public class SubcategoryController {

@Autowired
private SubcategoryService subcategoryService;

    @PostMapping("/createSubcategory")
    public ResponseEntity<Subcategory> createSubcategory(@RequestBody Subcategory subcategory){
        Subcategory createSubcategory = subcategoryService.createSubcategory(subcategory);
     return ResponseEntity.status(HttpStatus.CREATED).body(createSubcategory);   
    }

    @GetMapping("/getSubcategory")
    public ResponseEntity<List<Subcategory>> getSubcategory(){
        List<Subcategory> getSubcategory = subcategoryService.getSubcategory();
        return ResponseEntity.status(HttpStatus.FOUND).body(getSubcategory);
    }

   @PutMapping("/updateSubcategory/{id}")
    public ResponseEntity<Subcategory> updateCategory(@PathVariable int id, @RequestParam String subcategory_name, @RequestParam String subcategory_description, @RequestParam(required = false) Integer category_id, @RequestBody(required = false) Category category){
        Subcategory subcategory = new Subcategory(id, subcategory_name, subcategory_description, new Category(id, subcategory_name, subcategory_description));
        Subcategory updatedCategory = subcategoryService.updateCategory(subcategory);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedCategory);
    } 

    @DeleteMapping("/deleteSubcategory/{id}")
    public ResponseEntity<String> deleteSubcategory(@PathVariable int id){
        subcategoryService.deleteSubcategory(id);
        return ResponseEntity.ok("Deleted subcategory with id : " + id);
    }
    
}
