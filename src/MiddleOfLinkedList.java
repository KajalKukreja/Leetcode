/*
Problem Statement -
https://leetcode.com/problems/middle-of-the-linked-list/
*/

public class MiddleOfLinkedList {

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

	public static ListNode middleNode(ListNode head) {
		ListNode currHead = head;
		int nodeCount = 0;
		while (currHead != null) {
			currHead = currHead.next;
			nodeCount++;
		}
		int mid = nodeCount / 2;
		int newHeadIndex = 0;
		while (head != null && newHeadIndex < mid) {
			head = head.next;
			newHeadIndex++;
		}
		return head;
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
		ListNode middleNode = middleNode(head);
		printLinkedList(middleNode);

		head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		middleNode = middleNode(head);
		printLinkedList(middleNode);
	}
}
