package binaryTree.binaryTreeZigzagLevelOrderTraversal103;

import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Ji Chen
 * @className: Main
 * @description: 给你二叉树的根节点 root，返回其节点值的锯齿形层序遍历。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * @date 2022/4/17
 */
public class Solution {

	/**
	 * 借助两个栈完成，注意放入顺序
	 * Time: 75.15%   Memory: 34.65%
	 * @param root
	 * @return
	 */
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Stack<TreeNode> stack1 = new Stack<>();
		Stack<TreeNode> stack2 = new Stack<>();
		stack1.add(root);
		while (!stack1.isEmpty() || !stack2.isEmpty()) {
			List<Integer> list = new ArrayList<>();
			if (!stack1.isEmpty()) {
				while (!stack1.isEmpty()) {
					TreeNode node = stack1.pop();
					list.add(node.val);
					if (node.left != null) {
						stack2.push(node.left);
					}
					if (node.right != null) {
						stack2.push(node.right);
					}
				}
			} else {
				while (!stack2.isEmpty()) {
					TreeNode node = stack2.pop();
					list.add(node.val);
					if (node.right != null) {
						stack1.add(node.right);
					}
					if (node.left != null) {
						stack1.add(node.left);
					}
				}
			}
			res.add(list);
		}
		return res;
	}
}
