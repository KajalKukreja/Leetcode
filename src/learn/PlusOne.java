package learn;

import java.math.BigInteger;
import java.util.Arrays;

public class PlusOne {

	private static int[] plusOne(int[] digits) {
		final StringBuilder sb = new StringBuilder();
		Arrays.stream(digits).forEach(i -> sb.append(i));
		BigInteger num = new BigInteger(sb.toString());
		num = num.add(new BigInteger("1"));
		char[] strChars = num.toString().toCharArray();
		int[] result = new int[strChars.length];
		for (int i = 0; i < strChars.length; i++) {
			result[i] = Integer.parseInt("" + strChars[i]);
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] digits1 = { 1, 2, 3 };
		System.out.println(Arrays.toString(plusOne(digits1)));

		int[] digits2 = { 4, 3, 2, 1 };
		System.out.println(Arrays.toString(plusOne(digits2)));

		int[] digits3 = { 9 };
		System.out.println(Arrays.toString(plusOne(digits3)));

		int[] digits4 = { 1, 9, 9 };
		System.out.println(Arrays.toString(plusOne(digits4)));

		int[] digits5 = { 9, 8, 9 };
		System.out.println(Arrays.toString(plusOne(digits5)));
		
		int[] digits6 = {5,6,2,0,0,4,6,2,4,9 };
		System.out.println(Arrays.toString(plusOne(digits6)));
	}
}
