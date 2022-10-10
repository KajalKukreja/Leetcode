/*
Problem Statement -
https://leetcode.com/problems/maximum-subarray/ 
*/

public class MaximumSubarray {

	public static int maxSubArrayKadanesAlgo(int[] nums) {
		if (nums == null || nums.length < 1) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}

		int sum = 0;
		int maxSum = Integer.MIN_VALUE;
		for (int n : nums) {
			sum += n;
			maxSum = Math.max(maxSum, sum);
			if (sum < 0) {
				sum = 0;
			}
		}
		return maxSum;
	}

	public static int maxSubArrayDivideAndConquer(int[] nums) {
		if (nums == null || nums.length < 1) {
			return 0;
		}
		return findMaxSum(nums, 0, nums.length - 1);
	}

	private static int findMaxSum(int[] nums, int s, int e) {
		if (s == e) {
			return nums[s];
		}
		// divide
		int m = s + (e - s) / 2;
		// conquer
		int leftMax = findMaxSum(nums, s, m);
		int rightMax = findMaxSum(nums, m + 1, e);
		int arrMax = findMaxCrossSum(nums, s, m, e);
		return Math.max(arrMax, Math.max(leftMax, rightMax));
	}

	private static int findMaxCrossSum(int[] nums, int s, int m, int e) {
		int lSum = 0;
		int lMax = Integer.MIN_VALUE;
		int rSum = 0;
		int rMax = Integer.MIN_VALUE;

		for (int i = m; i >= s; i--) {
			lSum += nums[i];
			lMax = Math.max(lMax, lSum);
		}
		for (int i = m + 1; i <= e; i++) {
			rSum += nums[i];
			rMax = Math.max(rMax, rSum);
		}
		return lMax + rMax;
	}

	public static void main(String[] args) {

		int[] numbers = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(maxSubArrayKadanesAlgo(numbers));
		System.out.println(maxSubArrayDivideAndConquer(numbers));

		int[] numbers2 = { 5, 4, -1, 7, 8 };
		System.out.println(maxSubArrayKadanesAlgo(numbers2));
		System.out.println(maxSubArrayDivideAndConquer(numbers2));

		int[] numbers3 = null;
		System.out.println(maxSubArrayKadanesAlgo(numbers3));
		System.out.println(maxSubArrayDivideAndConquer(numbers3));

		int[] numbers4 = { 12 };
		System.out.println(maxSubArrayKadanesAlgo(numbers4));
		System.out.println(maxSubArrayDivideAndConquer(numbers4));

	}
}
