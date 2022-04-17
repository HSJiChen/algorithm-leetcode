package binaryTree.uniqueBinarySearchTreesII95;

import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ji Chen
 * @className: Main
 * @date 2022/3/24
 */
public class Solution {

	public static void main(String[] args) {
		for (TreeNode node : generateTrees(3)) {
			System.out.println(node.val);
		}
	}

	/**
	 * 回溯法。
	 * 注意：此方法的截止条件必须为返回null，否则会出现部分node缺失
	 * Time：98.37%  Memory: 49.90%
	 * @param n
	 * @return
	 */
	public static List<TreeNode> generateTrees(int n) {
		return generateNode(1, n);
	}

	private static List<TreeNode> generateNode(int start, int end) {
		List<TreeNode> nodeList = new ArrayList<>();
		if (start > end) {
			nodeList.add(null);
			return nodeList;
		}

		for (int i = start; i < end + 1; i ++) {
			List<TreeNode> leftNodeList = generateNode(start, i - 1);
			List<TreeNode> rightNodeList = generateNode(i + 1, end);
			for (TreeNode leftNode : leftNodeList) {
				for (TreeNode rightNode : rightNodeList) {
					TreeNode node = new TreeNode(i);
					node.left = leftNode;
					node.right = rightNode;
					nodeList.add(node);
				}
			}
		}
		return nodeList;
	}
}
