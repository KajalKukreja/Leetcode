/*
Problem Statement -
https://leetcode.com/problems/remove-nth-node-from-end-of-list/
*/

public class RemoveNthNodeFromEndOfLinkedList {

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

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode front = head, back = head;
        while(n-- > 0) {
        	front = front.next;
        }
        if(front == null) {
        	return head.next;
        }
        while(front.next != null){
            front = front.next;
            back = back.next;
        }
        back.next = back.next.next;
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
		} else {
			System.out.println("[]");
		}
	}

	public static void main(String[] args) {

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		ListNode newHead = removeNthFromEnd(head, 2);
		printLinkedList(newHead);

		head = new ListNode(1);
		newHead = removeNthFromEnd(head, 1);
		printLinkedList(newHead);

		head = new ListNode(1);
		head.next = new ListNode(2);
		newHead = removeNthFromEnd(head, 1);
		printLinkedList(newHead);

		head = new ListNode(1);
		head.next = new ListNode(2);
		newHead = removeNthFromEnd(head, 2);
		printLinkedList(newHead);

		head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		newHead = removeNthFromEnd(head, 2);
		printLinkedList(newHead);
		
		head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		newHead = removeNthFromEnd(head, 3);
		printLinkedList(newHead);

	}
}
