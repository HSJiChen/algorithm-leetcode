package binaryTree.binaryTreeLevelOrderTraversalII107;

import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Ji Chen
 * @className: Solution
 * @description: 给你二叉树的根节点 root，返回其节点值自底向上的层序遍历。
 *  （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * @date 2022/4/17
 */
public class Solution {

	/**
	 * 类似于102，只不过改变了list的实现方式
	 * Time: 92.58%   Memory: 74.04%
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new LinkedList<>();
		if (root == null) {
			return res;
		}
		Queue<TreeNode> queue = new LinkedBlockingQueue<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int n = queue.size();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < n; i ++) {
				TreeNode node = queue.poll();
				list.add(node.val);
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
			res.add(0, list);
		}
		return res;
	}
}
