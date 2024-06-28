package com.bnt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bnt.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer>{

} 
