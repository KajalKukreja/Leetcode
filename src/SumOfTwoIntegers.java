/*
Problem Statement -
https://leetcode.com/problems/sum-of-two-integers/
*/

public class SumOfTwoIntegers {

	public int getSum(int a, int b) {
		int carry;
		while (b != 0) {
			carry = (a & b);
			a = a ^ b;
			b = (carry) << 1;
		}
		return a;
	}

	public static void main(String[] args) {
		final SumOfTwoIntegers s = new SumOfTwoIntegers();
		final int a1 = 1;
		final int b1 = 2;
		System.out.println(a1 + " + " + b1 + " is " + s.getSum(a1, b1));

		final int a2 = 2;
		final int b2 = 3;
		System.out.println(a2 + " + " + b2 + " is " + s.getSum(a2, b2));

		final int a3 = 9;
		final int b3 = 5;
		System.out.println(a3 + " + " + b3 + " is " + s.getSum(a3, b3));

		final int a4 = 10;
		final int b4 = 9;
		System.out.println(a4 + " + " + b4 + " is " + s.getSum(a4, b4));
	}
}
