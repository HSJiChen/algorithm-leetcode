package binaryTree.symmetricTree101;

import binaryTree.TreeNode;

import java.util.Stack;

/**
 * @author Ji Chen
 * @className: Main
 * @description: 给你一个二叉树的根节点 root，检查它是否轴对称。
 * @date 2022/4/14
 */
public class Solution {

	/**
	 * 递归法
	 * Time: 100.00%    Memory: 77.35%
	 * @param root
	 * @return
	 */
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return false;
		}
		return isSameNode(root.left, root.right);
	}

	private boolean isSameNode(TreeNode leftNode, TreeNode rightNode) {
		if (leftNode == null && rightNode == null) {
			return true;
		} else if (leftNode == null && rightNode != null) {
			return false;
		} else if (leftNode != null && rightNode == null) {
			return false;
		} else if (leftNode.val != rightNode.val) {
			return false;
		}
		return isSameNode(leftNode.left, rightNode.right) && isSameNode(leftNode.right, rightNode.left);
	}

	/**
	 * 借助栈，使用迭代法
	 * Time: 22.55%  Memory: 51.57%
	 * @param root
	 * @return
	 */
	public boolean isSymmetric1(TreeNode root) {
		if (root == null) {
			return false;
		}
		Stack<TreeNode> treeNodeStack = new Stack<>();
		treeNodeStack.push(root.left);
		treeNodeStack.push(root.right);
		while (!treeNodeStack.isEmpty()) {
			TreeNode rightNode = treeNodeStack.pop();
			TreeNode leftNode = treeNodeStack.pop();
			if (leftNode == null && rightNode == null) {
				continue;
			} else if (leftNode == null && rightNode != null) {
				return false;
			} else if (leftNode != null && rightNode == null) {
				return false;
			} else if (leftNode.val != rightNode.val) {
				return false;
			}
			treeNodeStack.push(leftNode.left);
			treeNodeStack.push(rightNode.right);
			treeNodeStack.push(leftNode.right);
			treeNodeStack.push(rightNode.left);
		}
		return true;
	}
}
