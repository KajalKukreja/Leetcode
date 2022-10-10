package learn;

public class ImplementStrStr {

	private static int strStr(String haystack, String needle) {
		if (needle.isBlank() || needle.equals(haystack)) {
			return 0;
		}
		if (needle.length() > haystack.length()) {
			return -1;
		}
		for (int i = 0; i < haystack.length(); i++) {
			if (i + needle.length() > haystack.length()) {
				break;
			}
			final String substr = haystack.substring(i, i + needle.length());
			if (substr.equals(needle)) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {

		String haystack = "hello";
		String needle = "ll";
		System.out.println(strStr(haystack, needle));
		
		haystack = "aaaaa";
		needle = "bba";
		System.out.println(strStr(haystack, needle));
		
		haystack = "a";
		needle = "a";
		System.out.println(strStr(haystack, needle));
		
		haystack = "a";
		needle = "";
		System.out.println(strStr(haystack, needle));
		
		haystack = "abcd";
		needle = "bck";
		System.out.println(strStr(haystack, needle));
		
		haystack = "mississippi";
		needle = "issip";
		System.out.println(strStr(haystack, needle));
		
		haystack = "mississippi";
		needle = "pi";
		System.out.println(strStr(haystack, needle));
	}
}
