/*
Problem Statement -
https://leetcode.com/problems/basic-calculator-ii/
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class BasicCalculatorII {

	final List<Character> operators;
	final Map<Character, Integer> precedence;

	public BasicCalculatorII() {
		operators = Arrays.asList('*', '/', '+', '-');
		precedence = new HashMap<>();
		precedence.put('*', 2);
		precedence.put('/', 2);
		precedence.put('+', 1);
		precedence.put('-', 1);
	}

	private boolean isOperator(final char c) {
		return operators.contains(c);
	}

	private boolean hasEqualOrHighPrecedence(final char stackTop, final char op) {
		return precedence.get(stackTop).compareTo(precedence.get(op)) > -1;
	}

	private String convertInfixToPostfix(final String s) {
		final Stack<Character> opStack = new Stack<>();
		final StringBuilder postfix = new StringBuilder();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			final char curr = s.charAt(i);
			if (curr != ' ') {
				if (isOperator(curr)) {
					sb.append(" ");
					postfix.append(sb);
					sb = new StringBuilder();
					while (!opStack.isEmpty() && hasEqualOrHighPrecedence(opStack.peek(), curr)) {
						postfix.append(opStack.pop());
						postfix.append(" ");
					}
					opStack.push(curr);
				} else {
					sb.append(curr);
				}
			}
		}
		if (sb.length() > 0) {
			postfix.append(sb);
		}
		while (!opStack.isEmpty()) {
			postfix.append(" ");
			postfix.append(opStack.pop());
		}
		return postfix.toString();
	}

	private int applyOp(int num1, int num2, String op) {
		if ("+".equals(op)) {
			return num1 + num2;
		} else if ("-".equals(op)) {
			if (num2 < 0) {
				return num1 + Math.abs(num2);
			}
			return num1 - num2;
		} else if ("*".equals(op)) {
			return num1 * num2;
		} else if ("/".equals(op)) {
			return (int) num1 / num2;
		}
		return 0;
	}

	private int calculate(String s) {
		final Stack<String> stack = new Stack<>();
		final String postfixString = convertInfixToPostfix(s);
		System.out.println("String : " + s);
		System.out.println("Postfix : " + postfixString);
		final StringTokenizer tokenizer = new StringTokenizer(postfixString, " ");
		while (tokenizer.hasMoreTokens()) {
			final String item = tokenizer.nextToken();
			if (isOperator(item.charAt(0))) {
				final int num2 = Integer.parseInt(stack.pop());
				final int num1 = Integer.parseInt(stack.pop());
				final int ans = applyOp(num1, num2, item);
				stack.push(String.valueOf(ans));
				System.out.println(num1 + item + num2 + " = " + ans);
			} else {
				stack.push(item);
			}
			// System.out.println("Stack : " + stack);
		}
		System.out.println(applyOp(2, -3, "-"));
		return stack.isEmpty() ? 0 : Integer.parseInt(stack.pop());
	}

	public static void main(String[] args) {
		final BasicCalculatorII cal = new BasicCalculatorII();

		String s = "2+3*4";
		System.out.println("Expected : 14    ans : " + cal.calculate(s));

		System.out.println();
		s = "3*4+2*5";
		System.out.println("Expected : 22    ans : " + cal.calculate(s));

		System.out.println();
		s = " 3+5/2 ";
		System.out.println("Expected : 5    ans : " + cal.calculate(s));

		System.out.println();
		s = "42";
		System.out.println("Expected : 42    ans : " + cal.calculate(s));

		System.out.println();
		s = "0-2147483647";
		System.out.println("Expected : -2147483647    ans : " + cal.calculate(s));

		System.out.println();
		s = "1-1+1";
		System.out.println("Expected : 1    ans : " + cal.calculate(s));

		System.out.println();
		s = "1*2-3/4+5*6-7*8+9/10";
		System.out.println("Expected : -24    ans : " + cal.calculate(s));

		System.out.println();
		s = "1*2+3*4-5*6+7*8-9*10";
		System.out.println("Expected : -50    ans : " + cal.calculate(s));

		System.out.println();
		s = "1+2*5/3+6/4*2";
		System.out.println("Expected : 6    ans : " + cal.calculate(s));

		System.out.println();
		s = "22-3*2+18/6/2-1";
		System.out.println("Expected : 16    ans : " + cal.calculate(s));

		System.out.println();
		s = "12+1*4/5";
		System.out.println("Expected : 12    ans : " + cal.calculate(s));
	}
}
