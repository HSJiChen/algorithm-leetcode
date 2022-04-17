package linkedList.RemDupFromSortedList82;

/**
 * @author Ji Chen
 * @date 2021/8/4
 */
class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {

	/**
	 * 第一次直觉用双指针，注意while循那里的思考
	 * Time: 52.7%   Memory: 11.2%
	 * @param head
	 * @return
	 */
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode tmpHead = new ListNode(0);
		tmpHead.next = head;
		ListNode left = tmpHead;
		ListNode right = head;
		while(right != null && right.next != null) {
			if(right.val != right.next.val) {
				left.next = right;
				left = left.next;
				right = right.next;
			} else {
				while(right.next != null && right.val == right.next.val) {
					right = right.next;
				}
				right = right.next;
				left.next = right;
			}
		}
		return tmpHead.next;
	}

	public static void main(String[] args) {

	}
}
