package com.leetcode.tree;

/**
 * Description : TODO
 * Author : qiushi
 * Version : 1.0.0
 * CreateTime : 2019年10月11日 16:11:00
 */

import com.google.common.collect.Lists;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTree {
    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    TreeNode root;

    public BinaryTree(int[] array) {
        root = makeBinaryTreeByArray(array, 1);
    }

    /**
     * 采用递归的方式创建一颗二叉树
     * 传入的是二叉树的数组表示法
     * 构造后是二叉树的二叉链表表示法
     */
    public static TreeNode makeBinaryTreeByArray(int[] array, int index) {
        if (index < array.length) {
            int value = array[index];
            if (value != 0) {
                TreeNode t = new TreeNode(value);
                array[index] = 0;
                t.left = makeBinaryTreeByArray(array, index * 2);
                t.right = makeBinaryTreeByArray(array, index * 2 + 1);
                return t;
            }
        }
        return null;
    }

    /**
     * 深度优先遍历，相当于先根遍历
     * 采用非递归实现
     * 需要辅助数据结构：栈
     */
    public void depthOrderTraversal() {
        if (root == null) {
            System.out.println("empty tree");
            return;
        }
        //     ArrayDeque<TreeNode> stack=new ArrayDeque<TreeNode>();
        Stack<TreeNode> stack = new Stack();   //也可以用栈实现
        stack.push(root);
        while (stack.isEmpty() == false) {
            TreeNode node = stack.pop();
            System.out.print(node.value + "    ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        System.out.print("\n");
    }

    /**
     * 广度优先遍历
     * 采用非递归实现
     * 需要辅助数据结构：队列
     */
    public void levelOrderTraversal() {
        if (root == null) {
            System.out.println("empty tree");
            return;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        while (queue.isEmpty() == false) {
            TreeNode node = queue.remove();
            System.out.print(node.value + "    ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        System.out.print("\n");
    }

    public List<List<Integer>> zhiziPrint(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        List<Integer> list = Lists.newArrayList();
        list.add(root.value);
        result.add(list);
        stack1

        while (!stack1.isEmpty() || !stack2.isEmpty()){
            if (!stack1.isEmpty()){

            }
        }

        return result;
    }



















    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        List<Integer> list = new ArrayList<>();

        // 先添加第一个元素
        list.add(root.value);
        result.add(list);
        stack1.push(root);

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            list = new ArrayList<>();
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    TreeNode tmpNode = stack1.peek();
                    if (tmpNode.right != null) {
                        list.add(tmpNode.right.value);
                        stack2.push(tmpNode.right);
                    }
                    if (tmpNode.left != null) {
                        list.add(tmpNode.left.value);
                        stack2.push(tmpNode.left);
                    }
                    stack1.pop();
                }
            } else {
                while (!stack2.isEmpty()) {
                    TreeNode tmpNode = stack2.peek();
                    if (tmpNode.left != null) {
                        list.add(tmpNode.left.value);
                        stack1.push(tmpNode.left);
                    }
                    if (tmpNode.right != null) {
                        list.add(tmpNode.right.value);
                        stack1.push(tmpNode.right);
                    }
                    stack2.pop();
                }
            }
            if (list.size() > 0) {
                result.add(list);
            }
        }
        return result;
    }

    /**
     *                  13
     *                 /  \
     *               65    5
     *              /  \    \
     *             97  25   37
     *            /    /\   /
     *           22   4 28 32
     */
    public static void main(String[] args) {
        int[] arr = {0, 13, 65, 5, 97, 25, 0, 37, 22, 0, 4, 28, 0, 0, 32, 0};
        BinaryTree tree = new BinaryTree(arr);
        tree.depthOrderTraversal();
        tree.levelOrderTraversal();
    }
}