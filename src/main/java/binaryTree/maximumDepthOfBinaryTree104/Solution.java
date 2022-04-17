package binaryTree.maximumDepthOfBinaryTree104;

import binaryTree.TreeNode;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Ji Chen
 * @className: Solution
 * @description: 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * @date 2022/4/17
 */
public class Solution {

	/**
	 * DFS, 二叉树应该时刻提醒自己有没有递归的解法
	 * Time: 100%  Memory: 84.16%
	 * @param root
	 * @return
	 */
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}

	/**
	 * BFS, 但是时间复杂度和空间复杂度较差
	 * Time: 21.10%   Memory: 11.04%
	 * @param root
	 * @return
	 */
	public int maxDepth1(TreeNode root) {
		int maxDepth = 0;
		if (root == null) {
			return maxDepth;
		}
		Queue<TreeNode> queue = new LinkedBlockingQueue<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			maxDepth ++;
			int n = queue.size();
			for (int i = 0; i < n; i ++) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
		}
		return maxDepth;
	}
}
