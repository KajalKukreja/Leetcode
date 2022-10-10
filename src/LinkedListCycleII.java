/*
Problem Statement -
https://leetcode.com/problems/linked-list-cycle-ii/ 
*/

public class LinkedListCycleII {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}
		ListNode entry = head;
		ListNode slow = head.next;
		ListNode fast = head.next.next;
		while (slow != null && fast != null && fast.next != null) {
			if (fast == slow) {
				while (entry != fast) {
					fast = fast.next;
					entry = entry.next;
				}
				return entry;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		return null;
	}

	public static void main(String[] args) {

		ListNode head = new ListNode(3);
		head.next = new ListNode(2);
		head.next.next = new ListNode(0);
		head.next.next.next = new ListNode(-4);
		head.next.next.next.next = head.next;
		ListNode repeatedNode = detectCycle(head);
		System.out.println(repeatedNode != null ? repeatedNode.val : null);

		head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		repeatedNode = detectCycle(head);
		System.out.println(repeatedNode != null ? repeatedNode.val : null);

		head = new ListNode(6);
		head.next = new ListNode(10);
		head.next.next = new ListNode(12);
		head.next.next.next = new ListNode(28);
		head.next.next.next.next = new ListNode(35);
		head.next.next.next.next.next = head.next.next;
		repeatedNode = detectCycle(head);
		System.out.println(repeatedNode != null ? repeatedNode.val : null);

	}
}
