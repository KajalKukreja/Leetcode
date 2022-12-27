/*
Problem Statement -
https://leetcode.com/problems/min-stack/
*/

public class MinStack {

	static class Element {
		int value;
		int min;

		public Element(int value, int min) {
			this.value = value;
			this.min = min;
		}
	}

	private int min = Integer.MAX_VALUE;
	private int top = -1;
	private Element[] stack;

	public MinStack() {
		stack = new Element[30000];
	}

	public void push(int val) {
		if (top < stack.length - 1) {
			min = Math.min(val, min);
			final Element elem = new Element(val, min);
			stack[++top] = elem;
		}
	}

	public void pop() {
		if (top != -1) {
			top--;
		}
		if (top != -1) {
			final Element currElem = stack[top];
			min = currElem.min;
		} else {
			min = Integer.MAX_VALUE;
		}
	}

	public int top() {
		if (top == -1) {
			return -1;
		}
		return stack[top].value;
	}

	public int getMin() {
		return min;
	}

	public static void main(String[] args) {
		MinStack obj = new MinStack();
		obj.push(2);
		obj.push(5);
		System.out.println("Top : " + obj.top());
		System.out.println("Min : " + obj.getMin());
		obj.push(0);
		System.out.println("Min : " + obj.getMin());
		obj.pop();
		System.out.println("Min : " + obj.getMin());

		System.out.println("\n");
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println("Min : " + minStack.getMin()); // return -3
		minStack.pop();
		System.out.println("Min : " + minStack.top()); // return 0
		System.out.println("Min : " + minStack.getMin()); // return -2
	}
}
