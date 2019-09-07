package com.dragon.book.algorithms4;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * User: dengshenyan
 * Time: 2019-09-05 18:22
 */
public class Stack<Item> {

    private Node firstNode;

    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(Item item) {
        Node oldNode = firstNode;
        firstNode = new Node();
        firstNode.item = item;
        firstNode.next = oldNode;
        N++;
    }

    public Item pop() {
        Item item = firstNode.item;
        firstNode = firstNode.next;
        N--;
        return item;
    }
    
    public static void main(String[] args){
        Stack<String> stack = new Stack<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                stack.push(item);
            } else if(!stack.isEmpty()) {
                StdOut.print(stack.pop() + " ");
            }
        }
        StdOut.println(stack.size() + " left on the stack");
    }
}
