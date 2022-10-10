/*
Problem Statement -
https://leetcode.com/problems/running-sum-of-1d-array/
*/

public class RunningSumOf1DArray {

	public static int[] runningSumUsingPrefixSum(int[] nums) {
		int[] prefixSum = new int[nums.length];
		prefixSum[0] = nums[0];
		if (nums.length == 1) {
			return prefixSum;
		}
		for (int i = 1; i < nums.length; i++) {
			prefixSum[i] = prefixSum[i - 1] + nums[i];
		}
		return prefixSum;
	}

	public static int[] runningSumInPlace(int[] nums) {
		int sum = nums[0];
		if (nums.length == 1) {
			return new int[] { sum };
		}
		for (int i = 1; i < nums.length; i++) {
			sum += nums[i];
			nums[i] = sum;
		}
		return nums;
	}

	private static void printArray(int[] nums) {
		for (int i : nums) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };
		printArray(runningSumUsingPrefixSum(nums));
		printArray(runningSumInPlace(nums));

		int[] nums2 = { 1, 1, 1, 1, 1 };
		printArray(runningSumUsingPrefixSum(nums2));
		printArray(runningSumInPlace(nums2));

		int[] nums3 = { 3, 1, 2, 10, 1 };
		printArray(runningSumUsingPrefixSum(nums3));
		printArray(runningSumInPlace(nums3));

	}
}
