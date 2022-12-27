/*
Problem Statement -
https://leetcode.com/problems/divide-two-integers/
*/

public class DivideTwoIntegers {

	public int divide(int dividend, int divisor) {
		if (dividend <= Integer.MIN_VALUE && divisor == -1) {
			return Integer.MAX_VALUE;
		}
		final boolean sign = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0) ? true : false;
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		int quotient = 0;
		while ((dividend - divisor) >= 0) {
			int count = 0;
			while ((dividend - (divisor << 1 << count)) >= 0) {
				count++;
			}
			quotient += 1 << count;
			dividend -= divisor << count;
		}
		return sign ? quotient : -quotient;
	}

	public static void main(String[] args) {
		final DivideTwoIntegers d = new DivideTwoIntegers();
		final int dividend1 = 10;
		final int divisor1 = 3;
		System.out.println(d.divide(dividend1, divisor1));

		final int dividend2 = -2147483648;
		final int divisor2 = -1;
		System.out.println(d.divide(dividend2, divisor2));

		final int dividend3 = -2147483648;
		final int divisor3 = 1;
		System.out.println(d.divide(dividend3, divisor3));
	}

}
