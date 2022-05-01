package binaryTree.pathSum112;

import binaryTree.TreeNode;

/**
 * @author Ji Chen
 * @className: Solution
 * @description: 给你二叉树的根节点root和一个表示目标和的整数targetSum。
 *  判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和targetSum。
 *  如果存在，返回true；否则，返回false。
 *  叶子节点是指没有子节点的节点
 * @date 2022/4/19
 */
public class Solution {

	/**
	 * 递归法，DFS
	 * Time: 100.00%   Memory: 67.45%
	 * @param root
	 * @param targetSum
	 * @return
	 */
	public boolean hasPathSum(TreeNode root, int targetSum) {
		if (root == null) {
			return false;
		}
		if (root.left == null && root.right == null) {
			if (root.val == targetSum) {
				return true;
			} else {
				return false;
			}
		}
		return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
	}
}
