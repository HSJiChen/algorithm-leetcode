package linkedList.RemDupFromSortedList83;

/**
 * @author Ji Chen
 * @date 2021/8/10
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
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode left = head;
		ListNode right = head.next;
		while (right != null) {
			while (left.val == right.val && right != null) {
				right = right.next;
			}
			left.next = right;
			left = left.next;
			right = right.next == null ? null : right.next;
		}
		return head;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(2);
		ListNode l4 = new ListNode(3);
		ListNode l5 = new ListNode(3);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		Solution m = new Solution();
		ListNode head = m.deleteDuplicates(l1);
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
}
