package linkedList.ReverseBetween91;

/**
 * @author Ji Chen
 * @date 2021/7/13
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
	 * 第一次自己实现的，显然不够优雅
	 * time：100%  memory:15.26%
	 * @param head
	 * @param left
	 * @param right
	 * @return
	 */
	public ListNode reverseBetween(ListNode head, int left, int right) {
		if (left >= right || head == null || head.next == null) {
			return head;
		}
		ListNode preHead = new ListNode(0);
		preHead.next = head;
		ListNode pre = preHead;
		ListNode cur = head;
		ListNode connHead = null;
		ListNode tempHead = null;
		ListNode tempTail = null;
		ListNode connTail = null;
		for (int i = 1; i <= right + 1; i ++) {
			if (i == left) {
				connHead = pre;
				tempHead = cur;
			}
			if (i <= left) {
				pre = cur;
				cur = cur.next;
			}
			if (i > left && i < right + 1) {
				ListNode help = cur.next;
				cur.next = pre;
				pre = cur;
				cur = help;
			}
			if (i == right + 1) {
				tempTail = pre;
				connTail = cur;
			}
		}
		connHead.next = tempTail;
		tempHead.next = connTail;
		return preHead.next;
	}

	/**
	 * 头插法，非常厉害
	 * time: 100%  memory: 69.22%
	 * @param head
	 * @param left
	 * @param right
	 * @return
	 */
	public ListNode reverseBetween1(ListNode head, int left, int right) {
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		//初始化指针
		ListNode pre = dummyHead;
		ListNode cur = dummyHead.next;
		//移动到起始位置
		for (int i = 0; i < left - 1; i++) {
			pre = pre.next;
			cur = cur.next;
		}
		//开始进行头插法
		for (int i = 0; i < right - left; i++) {
			ListNode remove = cur.next;
			cur.next = cur.next.next;
			remove.next = pre.next;
			pre.next = remove;
		}
		return dummyHead.next;
	}

	/**
	 * 头插法，非常厉害
	 * time: 100%  memory: 91.63%
	 * @param head
	 * @param left
	 * @param right
	 * @return
	 */
	public ListNode reverseBetween3(ListNode head, int left, int right) {
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		//初始化指针
		ListNode pre = dummyHead;
		//移动到起始位置
		for (int i = 0; i < left - 1; i++) {
			pre = pre.next;
		}
		//这样做可以减少一点的空间内存消耗，定位的时候确定用最小的代价
		ListNode cur = pre.next;
		//将循环里的变量放到外面，也可以减少内存空间消耗
		ListNode remove = null;
		//开始进行头插法
		for (int i = 0; i < right - left; i++) {
			remove = cur.next;
			//直接用中间变量remove，这样可以减少内存空间
			cur.next = remove.next;
			remove.next = pre.next;
			pre.next = remove;
		}
		return dummyHead.next;
	}

	public static void main(String[] args) {
		Solution m = new Solution();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;

		/*ListNode l1 = new ListNode(3);
		ListNode l2 = new ListNode(5);
		l1.next = l2;*/

		ListNode head = m.reverseBetween1(l1, 2, 4);
		System.out.println(head.val);
	}
}
