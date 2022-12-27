/*
Problem Statement -
https://leetcode.com/problems/subsets/
*/

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	private static List<List<Integer>> subsets(int[] nums) {
		final List<List<Integer>> allSubsets = new ArrayList<>();
		allSubsets.add(new ArrayList<>());

		for (int n : nums) {
			final int size = allSubsets.size();
			for (int i = 0; i < size; i++) {
				final List<Integer> subset = new ArrayList<>(allSubsets.get(i));
				subset.add(n);
				allSubsets.add(subset);
			}
		}
		return allSubsets;
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 2, 3 };
		System.out.println(subsets(nums1));

		final int[] nums2 = { 0 };
		System.out.println(subsets(nums2));

		final int[] nums3 = { 1, 2 };
		System.out.println(subsets(nums3));

		final int[] nums4 = { 3, 2, 4, 1 };
		System.out.println(subsets(nums4));
	}
}
