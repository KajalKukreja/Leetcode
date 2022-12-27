/*
Problem Statement -
https://leetcode.com/problems/reverse-integer/
*/

import java.util.Stack;

public class ReverseInteger {

	public int reverse(int x) {
		final Stack<Character> stack = new Stack<>();
		boolean isNegative = false;
		for (char c : String.valueOf(x).toCharArray()) {
			if (c == '-') {
				isNegative = true;
			} else {
				stack.push(c);
			}
		}
		final StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		try {
			return Integer.parseInt(sb.toString()) * (isNegative ? -1 : 1);
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public static void main(String[] args) {
		final ReverseInteger r = new ReverseInteger();
		final int n1 = 123;
		System.out.println("Reverse of " + n1 + " is " + r.reverse(n1));
		final int n2 = -123;
		System.out.println("Reverse of " + n2 + " is " + r.reverse(n2));
		final int n3 = 120;
		System.out.println("Reverse of " + n3 + " is " + r.reverse(n3));
	}
}
