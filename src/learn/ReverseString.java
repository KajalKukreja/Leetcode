package learn;

public class ReverseString {

	private static void reverseString(char[] s) {
		int i = 0;
		int j = s.length - 1;
		while (i < j) {
			char temp = s[i];
			s[i] = s[j];
			s[j] = temp;
			i++;
			j--;
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
