package binaryTree.sameTree100;

import binaryTree.TreeNode;

/**
 * @author Ji Chen
 * @className: Main
 * @description: 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 *               如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * @date 2022/4/4
 */
public class Solution {

	/**
	 * 深度优先搜索法， 利用递归法
	 * Time: 100%  Memory: 12.21%
	 * @param p
	 * @param q
	 * @return
	 */
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null) {
			if (q == null) {
				return true;
			} else {
				return false;
			}
		}

		if (q == null) {
			return false;
		}

		if (p.val != q.val) {
			return false;
		}

		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
}
