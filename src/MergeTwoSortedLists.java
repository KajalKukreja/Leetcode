/*
Problem Statement -
https://leetcode.com/problems/merge-two-sorted-lists/
*/

public class MergeTwoSortedLists {

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

	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		if (list1 == null && list2 == null) {
			return null;
		}
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}
		if (list1.val <= list2.val) {
			list1.next = mergeTwoLists(list1.next, list2);
			return list1;
		} else {
			list2.next = mergeTwoLists(list1, list2.next);
			return list2;
		}
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

		ListNode head1 = new ListNode(1);
		head1.next = new ListNode(3);
		head1.next.next = new ListNode(4);
		ListNode head2 = new ListNode(1);
		head2.next = new ListNode(2);
		head2.next.next = new ListNode(4);
		printLinkedList(mergeTwoLists(head1, head2));

		head1 = new ListNode(4);
		head1.next = new ListNode(8);
		head1.next.next = new ListNode(9);
		head2 = new ListNode(1);
		head2.next = new ListNode(20);
		printLinkedList(mergeTwoLists(head1, head2));

	}
}
