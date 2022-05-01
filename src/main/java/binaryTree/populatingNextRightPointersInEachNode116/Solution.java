package binaryTree.populatingNextRightPointersInEachNode116;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Ji Chen
 * @className: Solution
 * @description: 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有next 指针都被设置为 NULL。
 * @date 2022/4/30
 */
public class Solution {

	/**
	 * BFS，层序遍历，空间复杂度为O(N)
	 * Time: 5.10%  Memory: 31.61%
	 * @param root
	 * @return
	 */
	public Node connect(Node root) {
		if (root == null) {
			return root;
		}
		Queue<Node> queue = new LinkedBlockingQueue<>();
		Node tmpRoot = root;
		queue.add(tmpRoot);
		while (!queue.isEmpty()) {
			int n = queue.size();
			for (int i = 0; i < n; i++) {
				Node node = queue.poll();
				if (i < n -1) {
					node.next = queue.peek();
				}
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
		}
		return root;
	}

	/**
	 * 空间复杂度为O(1)
	 * Time: 100%   Memory: 20.60%
	 * @param root
	 * @return
	 */
	public Node connect1(Node root) {
		if (root == null) {
			return root;
		}
		Node pre = root;
		while (pre.left != null) {
			Node tmp = pre;
			while (tmp != null) {
				tmp.left.next = tmp.right;
				if (tmp.next != null) {
					tmp.right.next = tmp.next.left;
				}
				tmp = tmp.next;
			}
			pre = pre.left;
		}
		return root;
	}
}

class Node {
	public int val;
	public Node left;
	public Node right;
	public Node next;

	public Node() {}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, Node _left, Node _right, Node _next) {
		val = _val;
		left = _left;
		right = _right;
		next = _next;
	}
};
