/*
Problem Statement -
https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
*/

public class TwoSumSortedArray {

	public static int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		for (int i = 0; i < numbers.length; i++) {
			int value = numbers[i];
			int diff = target - value;
			int index = -1;
			if (diff >= value && i + 1 < numbers.length) {
				index = binarySearch(numbers, i + 1, numbers.length - 1, diff);
			} else if (i - 1 >= 0) {
				index = binarySearch(numbers, 0, i - 1, diff);
			}
			if (index != -1) {
				result[0] = i + 1;
				result[1] = index + 1;
				break;
			}
		}
		return result;
	}

	private static int binarySearch(int[] numbers, int s, int e, int target) {
		if (s > e) {
			return -1;
		}
		int mid = s + (e - s) / 2;
		if (numbers[mid] == target) {
			return mid;
		}
		if (target < numbers[mid]) {
			return binarySearch(numbers, s, mid - 1, target);
		} else {
			return binarySearch(numbers, mid + 1, e, target);
		}
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

		int[] nums2 = { 5, 25, 75 };
		printArray(twoSum(nums2, 100));

	}
}
