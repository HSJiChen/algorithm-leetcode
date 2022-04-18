package binaryTree.convertSortedArrayToBinarySearchTree108;

import binaryTree.TreeNode;

/**
 * @author Ji Chen
 * @className: Solution
 * @description: 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 *            高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 */
public class Solution {

	/**
	 * 递归法
	 * Time: 100.00%  Memory: 34.66%
	 * @param nums
	 * @return
	 */
	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		} else if (nums.length == 1) {
			return new TreeNode(nums[0]);
		}
		int mid = nums.length / 2 + 1;
		int[] before = new int[mid -1];
		int[] after = new int[nums.length - mid];
		TreeNode midNode = new TreeNode(nums[mid - 1]);
		for (int i = 0; i < mid - 1; i ++) {
			before[i] = nums[i];
		}
		for (int j = mid; j < nums.length; j ++) {
			after[j - mid] = nums[j];
		}
		midNode.left = sortedArrayToBST(before);
		midNode.right = sortedArrayToBST(after);
		return midNode;
	}
}
