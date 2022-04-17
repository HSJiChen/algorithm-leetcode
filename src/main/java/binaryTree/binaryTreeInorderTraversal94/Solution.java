package binaryTree.binaryTreeInorderTraversal94;

import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Ji Chen
 * @className: BinaryTreeInorderTraversal94
 * @description: TODO
 * @date 2022/3/24
 */
public class Solution {

	public static void main(String[] args) {

	}

	/** 递归解法
	 *  内存占用多
	 *  Time: 100%  Memory: 12.5%
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		List<Integer> leftList = inorderTraversal(root.left);
		for (Integer i : leftList) {
			list.add(i);
		}

		list.add(root.val);

		List<Integer> rightList = inorderTraversal(root.right);
		for (Integer i : rightList) {
			list.add(i);
		}
		return list;
	}

	/** 递归解法的优化，避免使用for循环
	 *  内存占用多
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal1(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		inorder(list, root);
		return list;
	}

	private void inorder(List<Integer> list, TreeNode root) {
		if (root == null) {
			return;
		}
		inorder(list, root.left);
		list.add(root.val);
		inorder(list, root.right);
	}

	/**
	 * 迭代解法
	 * Time: 100%  Memory: 48.85%
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal2(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> treeNodeStack = new Stack<>();
		while (root != null) {
			treeNodeStack.push(root);
			root = root.left;
		}
		while (!treeNodeStack.isEmpty()) {
			TreeNode node = treeNodeStack.pop();

			list.add(node.val);

			TreeNode tmpRightNode = node.right;
			while (tmpRightNode != null){
				treeNodeStack.push(tmpRightNode);
				tmpRightNode = tmpRightNode.left;
			}
		}
		return list;
	}
}
