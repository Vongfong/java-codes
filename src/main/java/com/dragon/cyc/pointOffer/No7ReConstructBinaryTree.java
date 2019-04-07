package com.dragon.cyc.pointOffer;

import com.dragon.util.BinaryTreeNode;

/**
 * 剑指offer面试题6：重构二叉树
 * 题目：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建出下图的二叉树并输出他的根节点。
 *                     1
 *                   /   \
 *                  2     3
 *                 /     / \
 *                4     5   6
 *                 \        /
 *                 7        8
 * User: dengshenyan
 * Time: 2019-04-04 16:39
 */
public class No7ReConstructBinaryTree {
    public static void main(String[] args) {
        int[] preOrder={1,2,4,7,3,5,6,8};
        int[] inOrder={4,7,2,1,5,3,8,6};
        printTree(reConstruct(preOrder, inOrder));
    }

    /**
     * 判断输入合法性
     * @param preOrder 前序遍历序列
     * @param inOrder 中序遍历序列
     * @return 构建的树的根节点
     */
    public static BinaryTreeNode reConstruct(int[] preOrder, int[] inOrder) {
        if (preOrder == null || inOrder == null || preOrder.length != inOrder.length || preOrder.length < 1) {
            return null;
        }
        return constrct(preOrder, 0, preOrder.length-1, inOrder, 0, inOrder.length - 1);
    }

    /**
     * 根据前序遍历和中序遍历构建二叉树
     * @param preOrder 前序遍历序列
     * @param ps 前序遍历开始位置
     * @param pe 前序遍历结束位置
     * @param inOrder 中序遍历序列
     * @param is 中序遍历开始位置
     * @param ie 中序遍历结束位置
     * @return
     */
    public static BinaryTreeNode constrct(int[] preOrder, int ps, int pe, int[] inOrder, int is, int ie) {
        // 开始位置大于结束位置说明遍历到了叶节点
        if (ps > pe) {
            return null;
        }
        // 前序遍历的开始位置即该序列的根节点
        int value = preOrder[ps];
        int index = -1;
        // index在中序遍历序列中的索引
        for (int i = 0; i < inOrder.length; i++) {
            if (inOrder[i] == value) {
                index = i;
            }
        }
        // 找不到对应索引即说明序列输入有误
        if (index == -1) {
            throw new IllegalStateException("Iviad input " + index);
        }
        BinaryTreeNode node = new BinaryTreeNode();
        node.value = value;
        /**
         * 当前左节点的个数index-is
         * 左子树对应的前序遍历序列的位置preOrder[ps+1, ps+index-is]
         * 左子树对应的中序遍历序列的位置inOrder[is, index-1]
         */
        node.leftNode = constrct(preOrder, ps+1, ps+index-is, inOrder, is, index-1);
        /**
         * 当前右节点的个数ie-index
         * 右子树对应的前序遍历序列位置preOrder[ps+index-is+1, pe]
         * 右子树对应的中序遍历序列位置inOrder[index+1, ie]
         */
        node.rightNode = constrct(preOrder, ps+index-is+1, pe, inOrder,index+1, ie);
        return node;
    }
    // 中序遍历递归打印
    public static void printTree(BinaryTreeNode node) {
        if (node != null) {
            printTree(node.leftNode);
            System.out.println(node.value + " ");
            printTree(node.rightNode);
        }
    }
}
