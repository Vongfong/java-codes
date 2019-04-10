package com.dragon.cyc.pointOffer;

/**
 * User: dengshenyan
 * Time: 2019-04-10 22:13
 * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 */
public class No103JumpFloor {
    public int JumpFloor(int target) {
        if (target <= 2) {
            return target;
        }
        int first = 1, second = 2;
        int third = 0;
        for (int i = 3; i <= target; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }
}
