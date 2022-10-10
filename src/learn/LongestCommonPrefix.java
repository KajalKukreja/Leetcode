package learn;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LongestCommonPrefix {

	private static String longestCommonPrefix(String[] strs) {
		String prefix = "";
		if (strs.length == 0) {
			return prefix;
		}
		final List<String> list = Arrays.asList(strs);
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if (s1.length() == s2.length()) {
					return 0;
				}
				return s1.length() > s2.length() ? 1 : -1;
			}
		});
		prefix = list.get(0);
		boolean allMatched = false;
		while (!allMatched && !prefix.isEmpty()) {
			final String p = prefix;
			allMatched = list.stream().allMatch(s -> s.startsWith(p));
			if (!allMatched) {
				prefix = prefix.substring(0, prefix.length() - 1);
			}
		}
		return prefix;
	}

	public static void main(String[] args) {
		final String[] array1 = { "flower", "flow", "flight" };
		System.out.println(longestCommonPrefix(array1));

		final String[] array2 = { "dog", "racecar", "car" };
		System.out.println(longestCommonPrefix(array2));

		final String[] array3 = { "mango", "manage", "man" };
		System.out.println(longestCommonPrefix(array3));
	}
}
