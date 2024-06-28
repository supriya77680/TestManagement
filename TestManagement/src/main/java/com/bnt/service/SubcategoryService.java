package com.bnt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnt.model.Subcategory;
import com.bnt.repository.SubcategoryRepository;

@Service
public class SubcategoryService {

    @Autowired
    SubcategoryRepository subcategoryRepository;

    public Subcategory createSubcategory(Subcategory subcategory) {
       return subcategoryRepository.save(subcategory);
    }

    public void deleteSubcategory(int id) {
        subcategoryRepository.deleteById(id);
    }

    public Subcategory updateCategory(Subcategory category) {
        return subcategoryRepository.save(category);
    }

    public List<Subcategory> getSubcategory() {
        return subcategoryRepository.findAll();
    }

    
    
}
