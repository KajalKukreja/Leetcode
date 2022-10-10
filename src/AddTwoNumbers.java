/*
Problem Statement -
https://leetcode.com/problems/add-two-numbers/
*/

import java.math.BigInteger;

public class AddTwoNumbers {

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

	private static BigInteger getNumberFromLinkedList(ListNode head) {
		BigInteger number = BigInteger.ZERO;
		int power = 0;

		if (head == null) {
			return number;
		}
		while (head != null) {
			BigInteger value = new BigInteger(String.valueOf(head.val));
			if (power > 0) {
				value = value.multiply(BigInteger.TEN.pow(power));
			}
			number = number.add(value);
			head = head.next;
			power++;
		}
		return number;
	}

	private static ListNode createReverseLinkedListFromNumber(BigInteger num) {
		final BigInteger zero = BigInteger.ZERO;
		final BigInteger ten = BigInteger.TEN;
		ListNode head = null;

		if (num.equals(zero)) {
			return new ListNode(0);
		}
		while (num.compareTo(zero) == 1) {
			final int remainder = num.remainder(ten).intValue();
			num = num.divide(ten);
			head = insertNode(head, remainder);
		}
		return head;
	}

	private static ListNode insertNode(ListNode head, int val) {
		final ListNode newNode = new ListNode(val);

		if (head == null) {
			head = newNode;
		} else {
			ListNode currHead = head;
			while (currHead.next != null) {
				currHead = currHead.next;
			}
			currHead.next = newNode;
		}
		return head;
	}

	private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		final BigInteger num1 = getNumberFromLinkedList(l1);
		final BigInteger num2 = getNumberFromLinkedList(l2);
		return createReverseLinkedListFromNumber(num1.add(num2));
	}

	private static ListNode addTwoNumbersOptimized(ListNode l1, ListNode l2) {
		final ListNode head = new ListNode(0);
		ListNode currHead = head;
		int carry = 0;

		while (l1 != null || l2 != null || carry != 0) {
			int num1 = l1 != null ? l1.val : 0;
			int num2 = l2 != null ? l2.val : 0;
			int sum = carry + num1 + num2;
			int value = sum % 10;
			carry = sum / 10;
			final ListNode newNode = new ListNode(value);
			currHead.next = newNode;
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
			currHead = currHead.next;
		}
		return head.next;
	}

	public static void main(String[] args) {
		ListNode l1 = createReverseLinkedListFromNumber(new BigInteger("342"));
		System.out.println("Number 1 is " + getNumberFromLinkedList(l1));
		ListNode l2 = createReverseLinkedListFromNumber(new BigInteger("465"));
		System.out.println("Number 2 is " + getNumberFromLinkedList(l2));
		System.out.println("Sum is " + getNumberFromLinkedList(addTwoNumbers(l1, l2)));

		System.out.print("\nReversed result from optimized method is ");
		ListNode result = addTwoNumbersOptimized(l1, l2);
		while (result != null) {
			System.out.print(result.val);
			result = result.next;
		}
		System.out.println();
	}
}
