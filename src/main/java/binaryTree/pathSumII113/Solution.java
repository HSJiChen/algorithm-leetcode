package binaryTree.pathSumII113;

import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ji Chen
 * @className: Solution
 * @description: 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 *     叶子节点 是指没有子节点的节点。
 * @date 2022/4/20
 */
public class Solution {

	public List<List<Integer>> res = new ArrayList<>();

	/**
	 * dfs
	 * Time: 99.99%  Memory:
	 * @param root
	 * @param targetSum
	 * @return
	 */
	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		if (root == null) {
			return res;
		}
		List<Integer> list = new ArrayList<>();
		helper(root, targetSum, list);
		return res;
	}

	public void helper(TreeNode root, int targetSum, List<Integer> list) {
		if (root == null) {
			return;
		}
		list.add(root.val);
		if (root.left == null && root.right == null && targetSum == root.val) {
			res.add(new ArrayList<>(list));
			return;
		}
		helper(root.left, targetSum - root.val, list);
		helper(root.right, targetSum - root.val, list);
		list.remove(list.size() - 1);
	}
}
