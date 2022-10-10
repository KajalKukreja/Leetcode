/*
Problem Statement -
https://leetcode.com/problems/two-sum/
*/

import java.util.Hashtable;

public class TwoSum {

	public static int[] twoSum(int[] nums, int target) {
		// Here, key is the actual number and value is it's index in the array
		final Hashtable<Integer, Integer> hashtable = new Hashtable<>();
		int[] res = new int[2];

		for (int i = 0; i < nums.length; i++) {
			if (hashtable.containsKey(nums[i])) {
				res[0] = hashtable.get(nums[i]);
				res[1] = i;
				break;
			} else {
				int remaining = target - nums[i];
				hashtable.put(remaining, i);
			}
		}
		return res;
	}

	private static void printArray(int[] nums) {
		for (int n : nums) {
			System.out.print(n + "  ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] nums = { 2, 7, 11, 15 };
		printArray(twoSum(nums, 9));

		int[] nums2 = { 3, 2, 4 };
		printArray(twoSum(nums2, 6));

		int[] nums3 = { 3, 3 };
		printArray(twoSum(nums3, 6));

		int[] nums4 = { 3, 2, 3 };
		printArray(twoSum(nums4, 6));

		int[] nums5 = { 0, 4, 3, 0 };
		printArray(twoSum(nums5, 0));
	}
}
