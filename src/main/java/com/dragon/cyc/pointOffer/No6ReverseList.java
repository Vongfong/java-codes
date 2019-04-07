package com.dragon.cyc.pointOffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * User: dengshenyan
 * Time: 2019-03-22 17:39
 * 从尾到头打印链表
 */
public class No6ReverseList {

    private  class ListNode {
        ListNode next;
        int val;

        public ListNode(ListNode next, int val) {
            this.next = next;
            this.val = val;
        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 使用递归
     * @param listNode
     * @return
     */
    public static ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (listNode != null) {
            ret.addAll(printListFromTailToHead1(listNode));
            ret.add(listNode.val);
        }

        return ret;

    }

    /**
     * 使用头插法
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        // 头插发构建逆序列表
        ListNode head = new ListNode(-1);
        while (listNode != null) {
            ListNode memo = listNode.next;
            listNode.next = head.next;
            head.next = listNode;
            listNode = memo;
        }

        // 构建ArrayList
        ArrayList<Integer> ret = new ArrayList<>();
        head = head.next;
        while (head != null) {
            ret.add(head.val);
            head = head.next;
        }

        return ret;

    }

    /**
     * 使用栈
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.add(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> ret = new ArrayList<>();
        while (!stack.isEmpty()) {
            ret.add(stack.pop());
        }

        return ret;
    }

}
