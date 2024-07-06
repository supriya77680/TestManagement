package com.bnt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bnt.model.Subcategory;

@Service
public interface SubcategoryService {

    public Subcategory createSubcategory(Subcategory subcategory);

    public List<Subcategory> getSubcategory();

    public Subcategory updateSubcategory(int subcategoryId, Subcategory subcategory);

    public void deleteSubcategory(int subcategoryId);
}
