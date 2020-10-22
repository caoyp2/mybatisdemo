package com.spring;

public class StudentFactory {

    public Student getStudent(){
        return new Student();
    }

    public static Student staticGetStudent(){
        return new Student();
    }
}
