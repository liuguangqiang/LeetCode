package com.liuguangqiang.leetcode;

import com.liuguangqiang.structure.tree.TreeNode;

/**
 * 翻转二叉树
 * <p>
 * https://leetcode.com/problems/invert-binary-tree/description/
 * <p>
 * Invert a binary tree.
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * <p>
 * to
 * <p>
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 * <p>
 * Created by Eric at 2021/4/6 10:56 上午
 */
public class InvertBinaryTree {

    /**
     * 递归；
     * 从root节点开始,交换root节点的left和right
     * 递归root的left和right节点
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        swap(root, root.left, root.right);
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public void swap(TreeNode root, TreeNode left, TreeNode right) {
        root.left = right;
        root.right = left;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(7);
        root.left = left;
        root.right = right;

        left.left = new TreeNode(1);
        left.right = new TreeNode(3);

        right.left = new TreeNode(6);
        right.right = new TreeNode(9);

        System.out.println("翻转前的二叉树");
        root.print();
        System.out.println("");
        System.out.println("翻转后的二叉树");
        root = new InvertBinaryTree().invertTree(root);
        root.print();
    }
}
