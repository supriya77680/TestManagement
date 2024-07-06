package com.bnt.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnt.exception.CategoryNotFoundException;
import com.bnt.exception.SubcategoryAlreadyPresentException;
import com.bnt.exception.SubcategoryNotFoundException;
import com.bnt.model.Category;
import com.bnt.model.Subcategory;
import com.bnt.repository.SubcategoryRepository;
import com.bnt.service.SubcategoryService;

import lombok.extern.slf4j.Slf4j;

import com.bnt.repository.CategoryRepository;

@Service
@Slf4j
public class SubcategoryServiceImpl implements SubcategoryService{

    @Autowired
    SubcategoryRepository subcategoryRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Subcategory createSubcategory(Subcategory subcategory) {
        log.info("Subcategory is created");
        String subcategoryName = subcategory.getSubcategoryName();
        List<Subcategory> existingSubcategories = subcategoryRepository.findByName(subcategoryName);
        if(!existingSubcategories.isEmpty()){
            throw new SubcategoryAlreadyPresentException("Subcategory with name " + subcategoryName + " is already present");
        }
        String categoryName = subcategory.getCategory().getCategoryName();
        Optional<Category> optionalCategory = categoryRepository.findByCategoryName(categoryName);
        Category category = optionalCategory.orElseThrow(() -> new CategoryNotFoundException("Category '" + categoryName + "' is not present"));
        subcategory.setCategory(category);
        return subcategoryRepository.save(subcategory);
    }    

    @Override
    public List<Subcategory> getSubcategory() {
        log.info("All subcategory retrieved");
        try{
            return subcategoryRepository.findAll();
        }catch(Exception ex){
            throw new SubcategoryNotFoundException("Subcategory table is empty");
        }   
    }
    
    @Override
    public Subcategory updateSubcategory(int subcategoryId, Subcategory subcategory) {
        log.info("Updating subcategory with id: {}", subcategoryId);

        Optional<Subcategory> optionalSubcategory = subcategoryRepository.findById(subcategoryId);
        if (optionalSubcategory.isEmpty()) {
            String message = "Subcategory with id " + subcategoryId + " is not present in database";
            log.error(message);
            throw new SubcategoryNotFoundException(message);
        }

        Subcategory existingSubcategory = optionalSubcategory.get();
        existingSubcategory.setSubcategoryId(subcategoryId);
        existingSubcategory.setSubcategoryName(subcategory.getSubcategoryName());
        existingSubcategory.setSubcategoryDescription(subcategory.getSubcategoryDescription());
        existingSubcategory.setCategory(existingSubcategory.getCategory());

        return subcategoryRepository.save(existingSubcategory);
        
    } 

    @Override
    public void deleteSubcategory(int subcategoryId) {
        log.info("Subcategory deleted with id{}", subcategoryId);
        Optional<Subcategory> existingSubcategory= subcategoryRepository.findById(subcategoryId);
        if(!existingSubcategory.isPresent()){
            throw new SubcategoryNotFoundException("Subcategory not found with id : " + subcategoryId);
        }
        subcategoryRepository.deleteById(subcategoryId);
    }
}