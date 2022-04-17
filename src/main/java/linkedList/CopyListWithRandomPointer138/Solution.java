package linkedList.CopyListWithRandomPointer138;

import com.sun.javaws.IconUtil;

/**
 * @author Ji Chen
 * @date 2021/8/18
 */
class Node {
	int val;
	Node next;
	Node random;

	public Node(int val) {
		this.val = val;
		this.next = null;
		this.random = null;
	}
}

public class Solution {

	/**
	 * 迭代 + 节点拆分
	 * 自己实现的，代码不够优雅简洁，而且注意不能修改原始的链表
	 * Time: 100%     Memory: 61.8%
	 * @param head
	 * @return
	 */
	public Node copyRandomList(Node head) {
		if (head == null) {
			return null;
		}
		Node tmpCur = head;
		while (tmpCur != null) {
			Node tmp = new Node(tmpCur.val);
			tmp.next = tmpCur.next;
			tmpCur.next = tmp;
			tmpCur = tmp.next;
		}
		Node tmpCur1 = head;
		while (tmpCur1 != null) {
			tmpCur1.next.random = (tmpCur1.random == null) ? null : tmpCur1.random.next;
			tmpCur1 = tmpCur1.next.next;
		}
		Node newHead = head.next;
		Node tmpCur2 = head.next;
		Node tmpCur3 = head;
		while (tmpCur3.next != null && tmpCur2.next != null) {
			tmpCur3.next = tmpCur3.next.next;
			tmpCur2.next = tmpCur2.next.next;
			tmpCur3 = tmpCur3.next;
			tmpCur2 = tmpCur2.next;
		}
		tmpCur3.next = null;
		return newHead;
	}

	public static void main(String[] args) {
		Node node1 = new Node(7);
		Node node2 = new Node(13);
		Node node3 = new Node(11);
		Node node4 = new Node(10);
		Node node5 = new Node(1);
		node1.next = node2;
		node1.random = null;
		node2.next = node3;
		node2.random = node1;
		node3.next = node4;
		node3.random = node5;
		node4.next = node5;
		node4.random = node3;
		node5.next = null;
		node5.random = node1;
		Solution m = new Solution();
		Node cur = m.copyRandomList(node1);
		while (cur != null) {
			System.out.println(cur.val);
			System.out.println(cur.random);
			cur = cur.next;
		}
	}
}
