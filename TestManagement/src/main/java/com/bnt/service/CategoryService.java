package com.bnt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bnt.model.Category;

@Service
public interface CategoryService {

    public Category createCategory(Category category) ;

    public List<Category> getCategory();

    public Category updateCategory(Category category);

    public void deleteCategory(int categoryId);
}