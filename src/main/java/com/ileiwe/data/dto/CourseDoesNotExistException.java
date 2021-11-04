package com.ileiwe.data.dto;

public class CourseDoesNotExistException extends RuntimeException{
    public CourseDoesNotExistException(String s) {
        super(s);
    }
}
