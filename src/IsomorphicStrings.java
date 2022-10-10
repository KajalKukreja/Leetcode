/*
Problem Statement -
https://leetcode.com/problems/isomorphic-strings/
*/

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class IsomorphicStrings {

	public static boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		final Hashtable<Character, Character> replacements = new Hashtable<>();
		final Set<Character> charsUsed = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			char n = t.charAt(i);
			final Object value = replacements.get(c);
			if (value == null) {
				if (charsUsed.contains(n)) {
					return false;
				}
				replacements.put(c, n);
				charsUsed.add(n);
			} else if ((char) value != n) {
				return false;
			}
		}

		final StringBuilder builder = new StringBuilder();
		for (char c : s.toCharArray()) {
			final Object value = replacements.get(c);
			if (value != null) {
				builder.append(value);
			}
		}
		return t.equals(builder.toString());
	}

	public static void main(String[] args) {

		final String s1 = "egg";
		final String t1 = "add";
		System.out.println(isIsomorphic(s1, t1));

		final String s2 = "foo";
		final String t2 = "bar";
		System.out.println(isIsomorphic(s2, t2));

		final String s3 = "paper";
		final String t3 = "title";
		System.out.println(isIsomorphic(s3, t3));

		final String s4 = "bbbaaaba";
		final String t4 = "aaabbbba";
		System.out.println(isIsomorphic(s4, t4));

		final String s5 = "badc";
		final String t5 = "baba";
		System.out.println(isIsomorphic(s5, t5));
	}
}
