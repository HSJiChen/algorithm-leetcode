package binaryTree.binaryTreeLevelOrderTraversal102;

import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Ji Chen
 * @className: Main
 * @description: 给你二叉树的根节点root，返回其节点值的层序遍历。（即逐层地，从左到右访问所有节点）。
 * @date 2022/4/15
 */
public class Solution {

	/**
	 * 迭代法，同样也是BFS，广度优先，对应着深度优先，借助两个数据结构，queue和list，注意queue的接口方法
	 * Time: 66.03%   Memory: 56.02%
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Queue<TreeNode> queue = new LinkedBlockingQueue<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			// 同样可以借助计数的方式，只去获取前几位，放弃使用nodeList
			List<TreeNode> nodeList = new ArrayList<>();
			List<Integer> list = new ArrayList<>();
			while (!queue.isEmpty()) {
				nodeList.add(queue.poll());
			}
			for (TreeNode node : nodeList) {
				list.add(node.val);
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
			res.add(list);
		}
		return res;
	}
}
