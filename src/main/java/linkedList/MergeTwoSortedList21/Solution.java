package linkedList.MergeTwoSortedList21;

import java.util.List;

/**
 * @author Ji Chen
 * @date 2021/8/3
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
	 * 自己的第一次解法, 迭代法，对于二选一的时候对两个if 有更优雅的使用方式
	 * time: 100%  memory: 40.8%
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode tmpHead = new ListNode(0);
		ListNode cur = tmpHead;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				cur.next = l1;
				l1 = l1.next;
			} else {
				cur.next = l2;
				l2 = l2.next;
			}
			cur = cur.next;
		}
		/*if (l1 != null) {
			cur.next = l1;
		}
		if (l2 != null) {
			cur.next = l2;
		}*/
		//这里可以更优雅
		cur.next = l1 == null ? l2 : l1;
		return tmpHead.next;
	}

	/**
	 * 递归法
	 * time: 100%  memory: 58.4%
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		} else if (l1.val <= l2.val) {
			l1.next = mergeTwoLists1(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists1(l1, l2.next);
			return l2;
		}
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l12 = new ListNode(2);
		ListNode l13 = new ListNode(4);
		l1.next = l12;
		l12.next = l13;
		ListNode l2 = new ListNode(1);
		ListNode l22 = new ListNode(3);
		ListNode l23 = new ListNode(4);
		l2.next = l22;
		l22.next = l23;
		Solution m = new Solution();
		ListNode head = m.mergeTwoLists1(l1, l2);
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
}
