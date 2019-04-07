package com.dragon.cyc.pointOffer;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的 Push 和 Pop 操作。
 * User: dengshenyan
 * Time: 2019-04-07 11:29
 */
public class No9StackImplQueue {
    Stack<Integer> in = new Stack<>();
    Stack<Integer> out = new Stack<>();

    public void push(Integer val) {
        in.push(val);
    }

    public Integer pop() throws Exception {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        if (out.isEmpty()) {
            throw new Exception("queue is empty");
        }
        return out.pop();
    }

}
