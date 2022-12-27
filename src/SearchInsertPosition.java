/*
Problem Statement -
https://leetcode.com/problems/search-insert-position/
*/

public class SearchInsertPosition {

	public static int searchInsert(int[] nums, int target) {
		return binarySearch(nums, target, 0, nums.length - 1);
	}

	private static int binarySearch(int[] nums, int target, int s, int e) {
		if (s > e) {
			return s;
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
		int[] nums = { 1, 3, 5, 6 };
		System.out.println(searchInsert(nums, 5));
		System.out.println(searchInsert(nums, 2));
		System.out.println(searchInsert(nums, 7));
	}
}
