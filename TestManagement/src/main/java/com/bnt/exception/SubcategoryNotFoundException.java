package com.bnt.exception;

public class SubcategoryNotFoundException extends RuntimeException {
    
    public SubcategoryNotFoundException (String message){
        super(message);
    }
}
