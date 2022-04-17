package binaryTree.validateBinarySearchTree98;

import binaryTree.TreeNode;

import java.util.Stack;

/**
 * @author Ji Chen
 * @className: Main
 * @description: 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * @date 2022/4/1
 */
public class Solution {

	/**
	 * 树结构天然可以使用递归的方式去解答，所以首先想到用递归去解决
	 * 那么关键在于终止条件
	 * ！！！注意
	 * 这个是错误解法，因为这个只保证了节点左边 < 节点 < 节点右边，但是没有保证整个左边子树小于右边
	 * @param root
	 * @return
	 */
	public boolean isValidBSTWrong(TreeNode root) {
		if (root == null) {
			return true;
		}

		boolean leftFlag;
		if (root.left == null) {
			leftFlag = true;
		} else {
			leftFlag = (root.val > root.left.val) && isValidBSTWrong(root.left);
		}

		boolean rightFlag;
		if (root.right == null) {
			rightFlag = true;
		} else {
			rightFlag = (root.val < root.right.val) && isValidBSTWrong(root.right);
		}

		return leftFlag && rightFlag;
	}

	/**
	 * 继续递归思路，但是忽略了不仅仅是单个节点的大小关系，而且存在节点左侧的所有节点数据都应该小于节点
	 * 此法甚巧
	 *
	 * Time: 100%   Memory: 14.11%
	 *
	 * 时间复杂度：O(n)，n为二叉树节点数。 在递归过程中，所有的节点最多被访问一次，所以时间复杂度为O(n)
	 * 空间复杂度：O(n)，n为二叉树节点数。递归函数在递归过程中需要为每一层递归函数分配栈空间，
	 *          所以这里需要额外的空间且该空间取决于递归的深度，即二叉树的高度。最坏情况下二叉树为一条链，
	 *          树的高度为 n ，递归最深达到 n 层，故最坏情况下空间复杂度为 O(n)。
	 */
	public boolean isValidBST1(TreeNode root) {
		long min = Long.MIN_VALUE;
		long max = Long.MAX_VALUE;
		return checkValidBST(root, min, max);
	}

	private boolean checkValidBST(TreeNode root, long min, long max) {
		if (root == null) {
			return true;
		}
		if (root.val >= max || root.val <= min) {
			return false;
		}
		return checkValidBST(root.left, min, root.val) && checkValidBST(root.right, root.val, max);
	}

	/**
	 * 思路三：考虑树结构为搜索二叉树，即中序遍历的结果为递增，因此可利用这个性质进行校验
	 *  中序遍历的方式有：1）递归； 2）迭代（利用栈结构）
	 *
	 *  Time: 19.52%  Memory: 28.34%
	 *
	 *  时间复杂度：O(n), n为二叉树节点数。每个节点最多被访问一次，所以时间复杂度为O(n)。
	 *  空间复杂度：O(n), n为二叉树节点数。同理，栈中最多只有有n个节点，所以空间复杂度为O(n)。
	 * @param root
	 * @return
	 */
	public boolean isValidBST2(TreeNode root) {
		if (root == null) {
			return true;
		}
		Stack<TreeNode> treeNodeStack = new Stack<>();
		while (root != null) {
			treeNodeStack.push(root);
			root = root.left;
		}
		long min = Long.MIN_VALUE;
		while (!treeNodeStack.isEmpty()) {
			TreeNode node = treeNodeStack.pop();
			if (node.val <= min) {
				return false;
			}
			min = node.val;
			TreeNode tmpRightNode = node.right;
			while (tmpRightNode != null) {
				treeNodeStack.push(tmpRightNode);
				tmpRightNode = tmpRightNode.left;
			}
		}
		return true;
	}
}
