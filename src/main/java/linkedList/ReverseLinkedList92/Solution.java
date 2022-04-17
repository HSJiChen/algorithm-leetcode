package linkedList.ReverseLinkedList92;

/**
 * @author Ji Chen
 * @date 2021/8/17
 */
class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) {
		this.val = val;
	}
	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

public class Solution {

	/**
	 * 头插法，debug很多次，思路没问题，代码不够优雅
	 * Time: 100%   Memory: 60.36%
	 * @param head
	 * @param left
	 * @param right
	 * @return
	 */
	public ListNode reverseBetween(ListNode head, int left, int right) {
		if (head == null || head.next == null || left == right) {
			return head;
		}
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode beforeLeft = dummyHead;
		ListNode leftNode = dummyHead;
		ListNode rightNode = dummyHead;
		ListNode afterRight = dummyHead;
		ListNode tmp = dummyHead;
		for (int i = 0; i <= right; i++) {
			if (i == left - 1) {
				beforeLeft = tmp;
			}
			if (i == left) {
				leftNode = tmp;
			}
			if (i == right) {
				rightNode = tmp;
			}
			tmp = tmp.next;
		}
		ListNode cur = leftNode.next;
		ListNode target = rightNode.next;
		while (cur != target && cur != null) {
			ListNode tmpCur = cur.next;
			cur.next = beforeLeft.next;
			beforeLeft.next = cur;
			leftNode.next = tmpCur;
			cur = tmpCur;
		}
		return dummyHead.next;
	}

	/**
	 * 官方推荐方法一，穿针引线
	 * @param head
	 * @param left
	 * @param right
	 * @return
	 */
	public ListNode reverseBetween1(ListNode head, int left, int right) {
		// 因为头节点有可能发生变化，使用虚拟头节点可以避免复杂的分类讨论
		ListNode dummyNode = new ListNode(-1);
		dummyNode.next = head;

		ListNode pre = dummyNode;
		// 第 1 步：从虚拟头节点走 left - 1 步，来到 left 节点的前一个节点
		// 建议写在 for 循环里，语义清晰
		for (int i = 0; i < left - 1; i++) {
			pre = pre.next;
		}

		// 第 2 步：从 pre 再走 right - left + 1 步，来到 right 节点
		ListNode rightNode = pre;
		for (int i = 0; i < right - left + 1; i++) {
			rightNode = rightNode.next;
		}

		// 第 3 步：切断出一个子链表（截取链表）
		ListNode leftNode = pre.next;
		ListNode curr = rightNode.next;

		// 注意：切断链接
		pre.next = null;
		rightNode.next = null;

		// 第 4 步：同第 206 题，反转链表的子区间
		reverseLinkedList(leftNode);

		// 第 5 步：接回到原来的链表中
		pre.next = rightNode;
		leftNode.next = curr;
		return dummyNode.next;
	}

	private void reverseLinkedList(ListNode head) {
		// 也可以使用递归反转一个链表
		ListNode pre = null;
		ListNode cur = head;

		while (cur != null) {
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
	}

	/**
	 * 官方推荐方法二，也是头插法，但是实现起来比我的优雅，简洁
	 * @param head
	 * @param left
	 * @param right
	 * @return
	 */
	public ListNode reverseBetween2(ListNode head, int left, int right) {
		// 设置 dummyNode 是这一类问题的一般做法
		ListNode dummyNode = new ListNode(-1);
		dummyNode.next = head;
		ListNode pre = dummyNode;
		for (int i = 0; i < left - 1; i++) {
			pre = pre.next;
		}
		ListNode cur = pre.next;
		ListNode next;
		for (int i = 0; i < right - left; i++) {
			next = cur.next;
			cur.next = next.next;
			next.next = pre.next;
			pre.next = next;
		}
		return dummyNode.next;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		Solution m = new Solution();
		System.out.println(m.reverseBetween(l1, 2, 4));
	}
}
