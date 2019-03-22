package com.dragon.cyc.pointOffer;

/**
 * User: dengshenyan
 * Time: 2019-03-21 17:32
 * 替换空格
 */
public class Question5 {

    public static String replaceSpace(StringBuffer str) {
        int P1 = str.length() -1;
        for (int i = 0; i <= P1; i++) {
            if (str.charAt(i) == ' ') {
                str.append("  ");
            }
        }
        int P2 = str.length() - 1;
        while (P1 >= 0 && P2 > P1) {
            char c = str.charAt(P1--);
            if (c == ' ') {
                str.setCharAt(P2--, '0');
                str.setCharAt(P2--, '2');
                str.setCharAt(P2--, '%');
            } else {
                str.setCharAt(P2--, c);
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("ACCC B DDD EEEE F  D D FF       ");
        System.out.println(replaceSpace(str));
    }
}
