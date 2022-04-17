package binaryTree.recoverBinarySearchTree99;

import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Ji Chen
 * @className: Main
 * @description: 给你二叉搜索树的根节点 root ，该树中的恰好两个节点的值被错误地交换。
 *               请在不改变其结构的情况下，恢复这棵树。
 * @date 2022/4/1
 */
public class Solution {

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		node1.left = node3;
		node3.right = node2;
		Solution main = new Solution();
		main.recoverTree1(node1);
	}

	/**
	 * 首先的思路是根据二叉搜索树中序遍历的结果为递增数组的特性，那么那两个节点必然不符合这个特性。
	 * 所以中序遍历后找到错误节点，然后交换。
	 * 问题的难点在于如果根据中序遍历结果找到错误节点！！！
	 * 该方法为 显式中序遍历
	 * Time: 15.46%   Memory: 10.79%
	 * 时间复杂度： O(n)
	 * 空间复杂度： O(n)
	 * @param root
	 */
	public void recoverTree1(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> treeNodeStack = new Stack<>();
		TreeNode tmpRoot = root;
		while (root != null) {
			treeNodeStack.push(root);
			root = root.left;
		}

		List<Integer> nums = new ArrayList<>();
		while (!treeNodeStack.isEmpty()) {
			TreeNode node = treeNodeStack.pop();
			nums.add(node.val);
			TreeNode tmpNode = node.right;
			if (tmpNode != null) {
				while (tmpNode != null) {
					treeNodeStack.push(tmpNode);
					tmpNode = tmpNode.left;
				}
			}
		}

		int n = nums.size();
		int index1 = -1, index2 = -1;
		for (int i = 0; i < n - 1; ++i) {
			if (nums.get(i + 1) < nums.get(i)) {
				index2 = i + 1;
				if (index1 == -1) {
					index1 = i;
				} else {
					break;
				}
			}
		}
		int x = nums.get(index1), y = nums.get(index2);

		recover(tmpRoot, x, y);
	}

	private void recover(TreeNode root, int x, int y) {
		if (root == null) {
			return;
		}
		if (root.val == x) {
			root.val = y;
		} else if (root.val == y) {
			root.val = x;
		}
		recover(root.left, x, y);
		recover(root.right,x , y);
	}
}
