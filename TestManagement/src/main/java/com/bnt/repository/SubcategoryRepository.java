package com.bnt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bnt.model.Subcategory;

@Repository
public interface SubcategoryRepository extends JpaRepository<Subcategory, Integer> {

    

    
}
