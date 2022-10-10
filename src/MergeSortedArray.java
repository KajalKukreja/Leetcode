/*
Problem Statement -
https://leetcode.com/problems/merge-sorted-array/
*/

public class MergeSortedArray {

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int p1 = m - 1;
		int p2 = n - 1;
		int size = m + n - 1;
		while (p2 >= 0) {
			if (p1 >= 0 && nums1[p1] > nums2[p2]) {
				nums1[size--] = nums1[p1--];
			} else {
				nums1[size--] = nums2[p2--];
			}
		}
	}

	private static void printArray(int[] nums) {
		for (int n : nums) {
			System.out.print(n + "  ");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		int[] nums1 = { 1, 2, 3, 0, 0, 0 };
		int[] nums2 = { 2, 5, 6 };
		int m1 = 3;
		int n1 = 3;
		merge(nums1, m1, nums2, n1);
		printArray(nums1);

		int[] nums3 = { 1 };
		int[] nums4 = {};
		int m2 = 1;
		int n2 = 0;
		merge(nums3, m2, nums4, n2);
		printArray(nums3);

		int[] nums5 = { 0 };
		int[] nums6 = { 1 };
		int m3 = 0;
		int n3 = 1;
		merge(nums5, m3, nums6, n3);
		printArray(nums5);
	}

}
