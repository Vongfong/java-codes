package com.dragon.interview;

/**
 * 判断是否为2的N次幂的算法
 */
public class PowOfTwo {

    public static void main(String[] args){
        System.out.println(powOfTwo2(1024));
    }

    public static boolean powOfTwo(int n) {
        int temp;

        for (int i = 0; ; i++) {
            temp = (int) Math.pow(2, i);
            if (temp >= n) {
                break;
            }
        }

        if (temp == n) return true;

        return false;
    }

    public static boolean powOfTwo2(int n) {
        return n > 0 & (n & (n - 1)) == 0;
    }


}
