/*
Problem Statement -
https://leetcode.com/problems/find-pivot-index/
*/

import java.util.Arrays;

public class FindPivotIndex {

	public static int pivotIndex(int[] nums) {
		int lSum = 0;
		int rSum = Arrays.stream(nums).sum();

		for (int i = 0; i < nums.length; i++) {
			if (lSum == rSum - nums[i]) {
				return i;
			}
			lSum += nums[i];
			rSum -= nums[i];
		}
		return -1;
	}

	public static int pivotIndexUsingPrefixSum(int[] nums) {
		int total = 0;
		int prefixSum = 0;

		for (int n : nums) {
			total += n;
		}

		for (int i = 0; i < nums.length; i++) {
			prefixSum += nums[i];
			if (prefixSum * 2 == total + nums[i]) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 7, 3, 6, 5, 6 };
		System.out.println(pivotIndex(nums));

		int[] nums2 = { 1, 2, 3 };
		System.out.println(pivotIndex(nums2));

		int[] nums3 = { 2, 1, -1 };
		System.out.println(pivotIndex(nums3));

	}

}
