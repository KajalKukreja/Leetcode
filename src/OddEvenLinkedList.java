/*
Problem Statement -
https://leetcode.com/problems/odd-even-linked-list/
*/

public class OddEvenLinkedList {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	private static ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) {
			return head;
		}

		ListNode oddHead = head;
		ListNode oddCurrHead = head;
		ListNode evenHead = head.next;
		ListNode evenCurrHead = head.next;

		while (oddCurrHead != null && evenCurrHead != null) {
			// change next pointers
			oddCurrHead.next = oddCurrHead.next != null ? oddCurrHead.next.next : null;
			evenCurrHead.next = evenCurrHead.next != null ? evenCurrHead.next.next : null;

			// go to next odd/even index
			oddCurrHead = oddCurrHead.next;
			evenCurrHead = evenCurrHead.next;
		}

		oddCurrHead = oddHead;
		while (oddCurrHead.next != null) {
			oddCurrHead = oddCurrHead.next;
		}

		// now add even head at end of odd head
		oddCurrHead.next = evenHead;

		return oddHead;
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
		ListNode head = new ListNode(4);
		head.next = new ListNode(9);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(6);
		head.next.next.next.next = new ListNode(8);
		head.next.next.next.next.next = new ListNode(5);

		System.out.println("Original list");
		printLinkedList(head);
		System.out.println("Processed list");
		printLinkedList(oddEvenList(head));

		System.out.println();
		head = new ListNode(2);
		head.next = new ListNode(1);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(5);
		head.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next.next = new ListNode(7);

		System.out.println("Original list");
		printLinkedList(head);
		System.out.println("Processed list");
		printLinkedList(oddEvenList(head));
	}
}
