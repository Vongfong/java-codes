package com.dragon.interview;

public class Test2 {

    private int anInt;



    static boolean foo(char c) {
        System.out.print(c);
        return true;
    }

    void testByte() {
        byte i = 127;
        i += 1;
        System.out.println(i);

        char y = '3';
        System.out.println(anInt);

        float a = 0.3f;
        double b = a * 3;
        System.out.println(a == b);
    }


    public static void main(String[] args){
        int i = 0;
        for (foo('A'); foo('B') && i < 2; foo('C')) {
            i++;
            foo('D');
        }
        new Test2().testByte();
    }
}
