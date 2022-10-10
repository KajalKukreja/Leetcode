/*
Problem Statement -
https://leetcode.com/problems/copy-list-with-random-pointer/
*/

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

	static class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}

	private static Node copyRandomList(Node head) {
		if (head == null) {
			return head;
		}
		final Map<Node, Node> map = new HashMap<>();
		Node currHead = head;

		while (currHead != null) {
			final Node newNode = new Node(currHead.val);
			map.put(currHead, newNode);
			currHead = currHead.next;
		}

		currHead = head;
		while (currHead != null) {
			map.get(currHead).next = map.get(currHead.next);
			map.get(currHead).random = map.get(currHead.random);
			currHead = currHead.next;
		}
		return map.get(head);
	}

	private static void printLinkedList(Node head) {
		if (head != null) {
			Node currHead = head;
			while (currHead != null) {
				System.out.print(currHead.val + " ");
				currHead = currHead.next;
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);

		head.random = null;
		head.next.random = head;
		head.next.next.random = null;

		System.out.println("Original list");
		printLinkedList(head);
		System.out.println("Copy list");
		printLinkedList(copyRandomList(head));

	}
}
