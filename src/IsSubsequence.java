/*
Problem Statement -
https://leetcode.com/problems/is-subsequence/
*/

public class IsSubsequence {

	public static boolean isSubsequence(String s, String t) {
		if (s.equals(t)) {
			return true;
		}
		if (s.length() > t.length()) {
			return false;
		}
		StringBuilder sb = new StringBuilder(t);
		for (char c : s.toCharArray()) {
			int index = sb.indexOf(String.valueOf(c));
			if (index == -1) {
				return false;
			}
			sb = new StringBuilder(sb.substring(index + 1));
		}
		return true;
	}

	public static void main(String[] args) {

		final String s1 = "abc";
		final String t1 = "ahbgdc";
		System.out.println(isSubsequence(s1, t1));

		final String s2 = "axc";
		final String t2 = "ahbgdc";
		System.out.println(isSubsequence(s2, t2));

		final String s3 = "ace";
		final String t3 = "abcde";
		System.out.println(isSubsequence(s3, t3));

		final String s4 = "aaaaaa";
		final String t4 = "bbaaaa";
		System.out.println(isSubsequence(s4, t4));
	}
}
