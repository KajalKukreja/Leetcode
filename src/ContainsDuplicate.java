import java.util.HashSet;
import java.util.Set;

/*
Problem Statement -
https://leetcode.com/problems/contains-duplicate/
*/

public class ContainsDuplicate {

	public static boolean containsDuplicate(int[] nums) {
		if (nums != null && nums.length > 1) {
			final Set<Integer> numberSet = new HashSet<Integer>();
			for (int n : nums) {
				if (!numberSet.add(n)) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {

		int[] numbers = { 1, 3, 4, 6, 6, 8 };
		System.out.println(containsDuplicate(numbers));

		int[] numbers2 = { 1, 2, 3, 4, 5 };
		System.out.println(containsDuplicate(numbers2));

		int[] numbers3 = null;
		System.out.println(containsDuplicate(numbers3));

		int[] numbers4 = { 1 };
		System.out.println(containsDuplicate(numbers4));

	}
}
