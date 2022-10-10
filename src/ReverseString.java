/*
Problem Statement -
https://leetcode.com/problems/reverse-string/
*/

public class ReverseString {

	public static void reverseString(char[] s) {
		int l = 0;
		int r = s.length - 1;
		while (l < r) {
			char c = s[l];
			s[l] = s[r];
			s[r] = c;
			l++;
			r--;
		}
	}

	public static void main(String[] args) {
		char[] s1 = { 'h', 'e', 'l', 'l', 'o' };
		reverseString(s1);
		System.out.println(s1);
		char[] s2 = { 'H', 'a', 'n', 'n', 'a', 'h' };
		reverseString(s2);
		System.out.println(s2);
	}
}
