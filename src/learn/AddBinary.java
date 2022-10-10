package learn;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class AddBinary {

	private static String addBinary(String a, String b) {
		final BigDecimal num1 = binaryToDecimal(a);
		final BigDecimal num2 = binaryToDecimal(b);
		final BigDecimal res = num1.add(num2);
		return decimalToBinary(res);
	}

	private static BigDecimal binaryToDecimal(final String str) {
		if (str == null || str.isEmpty() || str.isBlank()) {
			throw new IllegalArgumentException("Input string cannot be null or empty");
		}
		BigDecimal result = new BigDecimal("0");
		for (int i = str.length() - 1, j = 0; i >= 0; i--, j++) {
			if (str.charAt(i) == '1') {
				result = result.add(new BigDecimal("2").pow(j));
			}
		}
		return result;
	}
	
	private static String decimalToBinary(BigDecimal value) {
		final StringBuilder result = new StringBuilder();
		final BigDecimal two = new BigDecimal("2");
		do {
			final int rem = value.remainder(two).intValue();
			result.append(rem);
			value = value.divide(two, RoundingMode.FLOOR);
		} while(value.compareTo(new BigDecimal("0")) == 1);
		
		return result.reverse().toString();
	}

	public static void main(String[] args) {
		String a = "0";
		String b = "0";
		System.out.println(addBinary(a, b));
		
		a = "11";
		b = "1";
		System.out.println(addBinary(a, b));

		a = "1010";
		b = "1011";
		System.out.println(addBinary(a, b));

		a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
		b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
		System.out.println(addBinary(a, b));

	}

}
