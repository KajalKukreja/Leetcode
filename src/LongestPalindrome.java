/*
Problem Statement -
https://leetcode.com/problems/longest-palindrome/
*/

import java.util.HashSet;
import java.util.Set;

public class LongestPalindrome {

	public static int longestPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		final Set<Character> chars = new HashSet<>();
		int length = 0;
		for (char c : s.toCharArray()) {
			if (chars.contains(c)) {
				chars.remove(c);
				length++;
			} else {
				chars.add(c);
			}
		}
		return length * 2 + (chars.isEmpty() ? 0 : 1);
	}

	public static void main(String[] args) {
		final String s1 = "abccccdd";
		System.out.println(longestPalindrome(s1));

		final String s2 = "a";
		System.out.println(longestPalindrome(s2));

		final String s3 = "abbbcccc";
		System.out.println(longestPalindrome(s3));
	}
}
