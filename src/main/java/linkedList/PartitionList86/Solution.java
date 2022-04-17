package linkedList.PartitionList86;

import java.util.List;

/**
 * @author Ji Chen
 * @date 2021/8/16
 */
class ListNode {
	int val;
	ListNode next;
	ListNode(){};
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
	 * Time: 100%   Memory: 89.07%
	 * 注意本例中使用的方法时间复杂度为O(N),空间复杂度为O(1)
	 * @param head
	 * @param x
	 * @return
	 */
	public ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode littleHead = new ListNode(0);
		ListNode bigHead = new ListNode(0);
		ListNode littleTemp = littleHead;
		ListNode bigTemp = bigHead;
		while(head != null){
			if(head.val < x) {
				littleTemp.next = head;
				head = head.next;
				littleTemp = littleTemp.next;
				littleTemp.next = null;
			} else {
				bigTemp.next = head;
				head = head.next;
				bigTemp = bigTemp.next;
				bigTemp.next = null;
			}

		}
		littleTemp.next = bigHead.next;
		return littleHead.next;
	}

	public static void main(String[] args) {

	}
}
