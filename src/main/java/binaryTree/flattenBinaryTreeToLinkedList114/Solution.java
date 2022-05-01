package binaryTree.flattenBinaryTreeToLinkedList114;

import binaryTree.TreeNode;

/**
 * @author Ji Chen
 * @className: Solution
 * @description: 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 展开后的单链表应该同样使用TreeNode，其中right子指针指向链表中下一个结点，而左子指针始终为null。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 */
public class Solution {

	/**
	 * 很好的方法，空间复杂度O(1)
	 * Time: 100.00%  Memory: 60.10%
	 * @param root
	 */
	public void flatten(TreeNode root) {
		while (root != null) {
			if (root.left == null) {
				root = root.right;
			} else {
				TreeNode leftNode = root.left;
				while (leftNode.right != null) {
					leftNode = leftNode.right;
				}
				leftNode.right = root.right;
				root.right = root.left;
				root.left = null;
				root = root.right;
			}
		}
	}
}
