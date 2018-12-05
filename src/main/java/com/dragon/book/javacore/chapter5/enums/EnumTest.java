package com.dragon.book.javacore.chapter5.enums;

import java.util.Scanner;

/**
 * User: dengshenyan
 * Time: 2018-04-23 17:50
 */
public class EnumTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a size: (SMALL, MEDIUM, LARGE, EXTRA_LARGE) ");
        String input = in.next().toUpperCase();
        Size size = Enum.valueOf(Size.class, input);
        System.out.println("size=" + size);
        System.out.println("abbreviation=" + size.getAbbreviation());
        if (size == Size.EXTRA_LARGE) {
            System.out.println("Good job--you paid attention to the _.");
        }
        for(Size enumTest : Size.values()) {
            System.out.println(enumTest);
        }
    }
}


enum Size {
    SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");

    public String getAbbreviation() { return abbreviation; }

    private Size(String abbreviation) {
        this.abbreviation = abbreviation;
    }
    private String abbreviation;

}
