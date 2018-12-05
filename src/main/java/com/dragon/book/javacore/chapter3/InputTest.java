package com.dragon.book.javacore.chapter3;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class InputTest {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        Date date = new Date();
        GregorianCalendar calendar = new GregorianCalendar();
        System.out.println(calendar.get(GregorianCalendar.DAY_OF_MONTH) + " " + calendar.get(GregorianCalendar.MONTH));

        System.out.println(new Date().toString());

        System.out.println("What is your name?");
        String name = in.nextLine();

        System.out.println("How old are you?");
        int age = in.nextInt();

        System.out.println("Hello " + name + " next year you will'be " + (age + 1));

    }
}
