package com.dragon.book.javacore.chapter4.abstractClasses;

/**
 * User: dengshenyan
 * Time: 2018-05-02 13:52
 */
public class Test {
    public static void main(String[] args)  {
        Shape shape = new Circle();
        System.out.println(shape.name);
        shape.printType();
        shape.printName();
    }
}

class Shape {
    public String name = "shape";

    public Shape() {
        System.out.println("shape constructor");
    }

    public void printType() {
        System.out.println("this is shape");
    }

    public static void printName() {
        System.out.println("shape");
    }
}

class Circle extends Shape {
    public String name = "circle";

    public String cirName = "cir";

    public Circle() {
        System.out.println("circle constructor");
    }

    public void printType() {
        System.out.println("this is circle");
    }

    public static void printName() {
        System.out.println("circle");
    }
}
