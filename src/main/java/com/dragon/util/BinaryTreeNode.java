package com.dragon.util;

/**
 * User: dengshenyan
 * Time: 2019-04-04 10:
 * 二叉树Java实现
 */
public class BinaryTreeNode {
    public int value;
    public BinaryTreeNode leftNode;
    public BinaryTreeNode rightNode;

    public BinaryTreeNode() {

    }

    public BinaryTreeNode(int value) {
        this.value = value;
        leftNode = null;
        rightNode = null;
    }
}
