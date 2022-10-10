/*
Problem Statement -
https://leetcode.com/problems/reverse-linked-list/
*/

public class ReverseLinkedList {

	static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static ListNode reverseList(ListNode head) {
		ListNode prev = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}

	public static ListNode reverseListRec(ListNode head) {
		return reverseListRecursive(null, head);
	}

	private static ListNode reverseListRecursive(ListNode prev, ListNode head) {
		if (head == null) {
			return prev;
		}
		ListNode next = head.next;
		head.next = prev;
		return reverseListRecursive(head, next);
	}

	private static void printLinkedList(ListNode head) {
		if (head != null) {
			ListNode currHead = head;
			while (currHead != null) {
				System.out.print(currHead.val + " --> ");
				currHead = currHead.next;
			}
			System.out.println("null");
		}
	}

	public static void main(String[] args) {

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		ListNode reversedHead = reverseList(head);
		printLinkedList(reversedHead);

		head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		reversedHead = reverseListRec(head);
		printLinkedList(reversedHead);
	}
}
