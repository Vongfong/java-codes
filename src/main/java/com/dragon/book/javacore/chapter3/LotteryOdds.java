package com.dragon.book.javacore.chapter3;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class LotteryOdds {
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        System.out.println("How many numbers do you need to draw?");
        int k = in.nextInt();

        System.out.println("What is the highest number you can draw?");
        int n = in.nextInt();

        int[] numbers = new int[n];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }

        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) {
            int r = (int) (Math.random() * n);
            result[i] = numbers[r];

            numbers[r] = numbers[n -1];
            n--;
        }

        Arrays.sort(result);
        for (int r : result) {
            System.out.println(r);
        }
        BigInteger lotteryOdds = BigInteger.valueOf(1);
        for (int i = 1; i <= k; i++) {
            lotteryOdds = lotteryOdds.multiply(BigInteger.valueOf(n - i + 1).divide(BigInteger.valueOf(i)));
        }


        System.out.println("Your odds is  1 in " + lotteryOdds);

//        int[] a = new int[] {1, 3, 5};
//        int[] smallPrime = {1,3,5,7};
    }
}
