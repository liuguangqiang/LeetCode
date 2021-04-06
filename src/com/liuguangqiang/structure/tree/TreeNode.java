package com.liuguangqiang.structure.tree;

/**
 * Created by Eric at 2021/3/30 10:05 上午
 */
public class TreeNode {

    public int val;

    public TreeNode left;

    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public void print() {
        print(this);
    }

    public void print(TreeNode treeNode) {
        System.out.println(treeNode.val);
        if (treeNode.left != null) {
            print(treeNode.left);
        }

        if (treeNode.right != null) {
            print(treeNode.right);
        }
    }
}
