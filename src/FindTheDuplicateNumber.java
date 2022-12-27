/*
Problem Statement -
https://leetcode.com/problems/find-the-duplicate-number/
*/

import java.util.HashSet;
import java.util.Set;

public class FindTheDuplicateNumber {

	private static int findDuplicate(int[] nums) {
		final Set<Integer> set = new HashSet<>();
		for (int i : nums) {
			if (!set.add(i)) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {

		final int[] nums1 = { 1, 3, 4, 2, 2 };
		System.out.println(findDuplicate(nums1));

		final int[] nums2 = { 3, 1, 3, 4, 2 };
		System.out.println(findDuplicate(nums2));
	}
}
