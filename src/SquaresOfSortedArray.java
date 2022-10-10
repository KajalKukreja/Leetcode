/*
Problem Statement -
https://leetcode.com/problems/squares-of-a-sorted-array/
*/

public class SquaresOfSortedArray {

	public static int[] sortedSquares(int[] nums) {
		int[] result = new int[nums.length];
		int l = 0;
		int r = nums.length - 1;
		int i = nums.length - 1;
		while (i >= 0) {
			int num1 = Math.abs(nums[l]);
			int num2 = Math.abs(nums[r]);
			if (num1 > num2) {
				result[i--] = num1 * num1;
				l++;
			} else {
				result[i--] = num2 * num2;
				r--;
			}
		}
		return result;
	}

	private static void printArray(int[] nums) {
		for (int n : nums) {
			System.out.print(n + "  ");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		int[] nums = { -4, -1, 0, 3, 10 };
		printArray(sortedSquares(nums));

		int[] nums2 = { -7, -3, 2, 3, 11 };
		printArray(sortedSquares(nums2));

	}
}
