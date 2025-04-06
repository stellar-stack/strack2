package com.strack.strack.service;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String sorryNoStudentFound) {
        super(sorryNoStudentFound);
    }
}
