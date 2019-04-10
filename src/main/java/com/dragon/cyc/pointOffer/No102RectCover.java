package com.dragon.cyc.pointOffer;

/**
 * User: dengshenyan
 * Time: 2019-04-09 23:26
 * 我们可以用 2*1 的小矩形横着或者竖着去覆盖更大的矩形。请问用 n 个 2*1 的小矩形无重叠地覆盖一个 2*n 的大矩形，总共有多少种方法？
 * 本质上还是一个斐波那契数列
 */
public class No102RectCover {
    public int RectCover(int target) {
        if(target <= 2)
            return target;
        int pre1 = 1, pre2 = 2;
        int result = 0;
        for(int i = 3; i <= target; i++) {
            result = pre2 + pre1;
            pre1 = pre2;
            pre2 = result;
        }
        return result;
    }
}
