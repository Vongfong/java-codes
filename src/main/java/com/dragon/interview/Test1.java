package com.dragon.interview;

public class Test1 {
    public static void changeStr(String str) {
        str = "Welcome";
        System.out.println(str);
    }

    public static void main(String[] args){
        String str1 = "hello";
        String str2 = "he" + "llo";
//        System.out.println(str1 == str2);

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("ping");
            }
        });
        t.run();
        pong();
    }

    static void pong() {
        System.out.println("pong");
    }
}
