package linkedList.ConvertListToTree109;

/**
 * @author Ji Chen
 * @date 2021/7/20
 */

class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode() {}
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
  }
}

public class Solution {

	/**
	 * 自己完成，思路比较简单，中间很多细节值得注意
	 * 比如：1、buildTree方法里面使用head和end，不要使用null
	 *      2、在双指针确定中点时，while中的判断条件是后一节点空和next为空的判断
	 * time: 100%    memory: 29.78%
	 * @param head
	 * @return
	 */
	public TreeNode sortedListToBST(ListNode head) {
		return buildTree(head, null);
	}

	private TreeNode buildTree(ListNode head, ListNode end) {
		if (head == end) {
			return null;
		}
		TreeNode left = null;
		TreeNode right = null;
		TreeNode mid = null;
		ListNode midNode = getMid(head, end);
		mid = new TreeNode(midNode.val);
		left = buildTree(head, midNode);
		right = buildTree(midNode.next, end);
		mid.left = left;
		mid.right = right;
		return mid;
	}

	private ListNode getMid(ListNode head, ListNode end) {
		ListNode left = head;
		ListNode right = head;
		while (right != end && right.next != end) {
			left = left.next;
			right = right.next.next;
		}
		return left;
	}

	/**
	 * 另一种较优解法，分治+中序遍历
	 * @param args
	 */

	public static void main(String[] args) {
		Solution m = new Solution();
		ListNode l1 = new ListNode(-10);
		ListNode l2 = new ListNode(-3);
		ListNode l3 = new ListNode(0);
		ListNode l4 = new ListNode(5);
		ListNode l5 = new ListNode(9);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		System.out.println(m.sortedListToBST(l1).val);
	}
}
