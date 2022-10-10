/*
Problem Statement -
https://leetcode.com/problems/reverse-words-in-a-string-iii/
*/

public class ReverseWordsInAStringIII {

	public static String reverseWords(String s) {
		if (s.length() == 1) {
			return reverse(s.toCharArray());
		}

		final StringBuilder builder = new StringBuilder();
		final String[] words = s.split(" ");
		for (String w : words) {
			builder.append(reverse(w.toCharArray()));
			builder.append(" ");
		}
		return builder.toString().trim();
	}

	private static String reverse(char[] charArray) {
		int l = 0;
		int r = charArray.length - 1;
		while (l < r) {
			char c = charArray[l];
			charArray[l] = charArray[r];
			charArray[r] = c;
			l++;
			r--;
		}
		return String.valueOf(charArray);
	}

	public static void main(String[] args) {
		final String s1 = "Let's take LeetCode contest";
		System.out.println(reverseWords(s1));

		final String s2 = "God Ding";
		System.out.println(reverseWords(s2));

	}
}
