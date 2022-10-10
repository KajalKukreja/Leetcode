/*
Problem Statement -
https://leetcode.com/problems/binary-search/
*/

public class BinarySearch {

	public static int search(int[] nums, int target) {
		return binarySearch(nums, target, 0, nums.length - 1);
	}

	private static int binarySearch(int[] nums, int target, int s, int e) {
		if (s > e) {
			return -1;
		}
		int m = s + (e - s) / 2;
		if (nums[m] == target) {
			return m;
		}
		if (target < nums[m]) {
			return binarySearch(nums, target, s, m - 1);
		} else {
			return binarySearch(nums, target, m + 1, e);
		}
	}

	public static void main(String[] args) {

		int[] numbers = { -1, 0, 3, 5, 9, 12 };
		System.out.println(search(numbers, 9));

		int[] numbers2 = { -1, 0, 3, 5, 9, 12 };
		System.out.println(search(numbers2, 2));

	}
}
