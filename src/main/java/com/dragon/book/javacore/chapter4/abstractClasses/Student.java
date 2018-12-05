package com.dragon.book.javacore.chapter4.abstractClasses;

public class Student extends Person {

    private String description;

    public Student(String n, String description) {
        super(n);
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
