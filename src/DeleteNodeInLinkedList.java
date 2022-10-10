/*
Problem Statement -
https://leetcode.com/problems/delete-node-in-a-linked-list/
*/

public class DeleteNodeInLinkedList {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	private static void deleteNode(ListNode node) {
		if (node != null) {
			node.val = node.next.val;
			node.next = node.next.next;
		}
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
		final ListNode nodeToBeDeleted = new ListNode(5);
		final ListNode head = new ListNode(4);
		head.next = nodeToBeDeleted;
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(9);

		System.out.println("List before delete");
		printLinkedList(head);
		deleteNode(nodeToBeDeleted);
		System.out.println("List after delete");
		printLinkedList(head);
	}
}
