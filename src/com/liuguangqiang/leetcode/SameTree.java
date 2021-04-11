package com.liuguangqiang.leetcode;

import com.liuguangqiang.structure.tree.TreeNode;

/**
 * https://leetcode.com/problems/same-tree/
 * <p>
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 * <p>
 * Created by Eric at 2021/4/11 10:27 上午
 */
public class SameTree {

    /**
     * 使用递归思路;
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == q) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        /**
         * 如果p和q的val相等;
         * 使用递归， 继续对比p和q的左右节点;
         */
        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;
        }
    }

    public static void main(String[] arg) {
        SameTree sameTree = new SameTree();

        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(1);
        p.right = new TreeNode(2);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(1);
        q.right = new TreeNode(2);

        System.out.println(sameTree.isSameTree(p, q));
    }
}
