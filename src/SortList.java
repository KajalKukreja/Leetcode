/*
Problem Statement -
https://leetcode.com/problems/sort-list/
*/

public class SortList {

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

	private static ListNode merge(ListNode l1, ListNode l2) {

		// Dummy node
		final ListNode head = new ListNode();
		ListNode currHead = head;

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				currHead.next = l1;
				l1 = l1.next;
			} else {
				currHead.next = l2;
				l2 = l2.next;
			}
			currHead = currHead.next;
		}
		while (l1 != null) {
			currHead.next = l1;
			l1 = l1.next;
			currHead = currHead.next;
		}

		while (l2 != null) {
			currHead.next = l2;
			l2 = l2.next;
			currHead = currHead.next;
		}
		return head.next;
	}

	private static ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode firstTail = head;
		ListNode secondHead = head;
		ListNode secondTail = head;

		while (secondHead != null && secondTail != null && secondTail.next != null) {
			firstTail = secondHead;
			secondHead = secondHead.next;
			secondTail = secondTail.next.next;
		}

		// break the actual list at mid node
		firstTail.next = null;

		// sort first list
		final ListNode leftHead = sortList(head);

		// sort second list
		final ListNode rightHead = sortList(secondHead);

		// now merge both the lists
		return merge(leftHead, rightHead);
	}

	private static ListNode insertNode(ListNode head, int val) {
		if (head == null) {
			return new ListNode(val);
		}
		ListNode currHead = head;
		while (currHead.next != null) {
			currHead = currHead.next;
		}
		currHead.next = new ListNode(val);
		return head;
	}

	private static void printLinkedList(ListNode head) {
		if (head != null) {
			ListNode currHead = head;
			while (currHead != null) {
				System.out.print(currHead.val + " ");
				currHead = currHead.next;
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		ListNode head = null;
		head = insertNode(head, -1);
		head = insertNode(head, 5);
		head = insertNode(head, 3);
		head = insertNode(head, 4);
		head = insertNode(head, 0);
		System.out.println("Before sorting");
		printLinkedList(head);
		System.out.println("After sorting");
		printLinkedList(sortList(head));

		head = null;
		head = insertNode(head, 4);
		head = insertNode(head, 2);
		head = insertNode(head, 1);
		head = insertNode(head, 3);
		System.out.println("Before sorting");
		printLinkedList(head);
		System.out.println("After sorting");
		printLinkedList(sortList(head));
	}
}
