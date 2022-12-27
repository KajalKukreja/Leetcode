/*
Problem Statement -
https://leetcode.com/problems/evaluate-reverse-polish-notation/
*/

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class EvaluateReversePolishNotation {

	final List<String> operators = Arrays.asList("*", "/", "+", "-");

	private boolean isOperator(final String op) {
		return operators.contains(op);
	}

	int applyOp(final int num1, final int num2, final String op) {
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
			return num1 / num2;
		}
		return 0;
	}

	public int evalRPN(String[] tokens) {
		final Stack<String> valStack = new Stack<>();
		for (int i = 0; i < tokens.length; i++) {
			final String currToken = tokens[i];
			if (isOperator(currToken)) {
				final int num2 = Integer.parseInt(valStack.pop());
				final int num1 = Integer.parseInt(valStack.pop());
				final int ans = applyOp(num1, num2, currToken);
				valStack.push(String.valueOf(ans));
				System.out.println(num1 + currToken + num2 + " = " + ans);
				System.out.println("Pushed ans : " + ans);
			} else {
				valStack.push(currToken);
				System.out.println("Pushed val : " + currToken);
			}
		}
		return valStack.isEmpty() ? 0 : Integer.parseInt(valStack.pop());
	}

	public static void main(String[] args) {
		final EvaluateReversePolishNotation e = new EvaluateReversePolishNotation();

		final String[] tokens1 = { "2", "1", "+", "3", "*" };
		System.out.println("Expected : 9    ans : " + e.evalRPN(tokens1));

		System.out.println();
		final String[] tokens2 = { "4", "13", "5", "/", "+" };
		System.out.println("Expected : 6    ans : " + e.evalRPN(tokens2));

		System.out.println();
		final String[] tokens3 = { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
		System.out.println("Expected : 22    ans : " + e.evalRPN(tokens3));

		System.out.println();
		final String[] tokens4 = { "4", "-2", "/", "2", "-3", "-", "-" };
		System.out.println("Expected : -7    ans : " + e.evalRPN(tokens4));
	}
}
