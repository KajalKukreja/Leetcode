/*
Problem Statement -
https://leetcode.com/problems/sort-colors/
*/

public class SortColors {

	public void sortColors(final int[] nums) {
		int red = 0;
		int white = 0;
		int blue = 0;
		for (int i : nums) {
			if (i == 0) {
				red++;
			} else if (i == 1) {
				white++;
			} else if (i == 2) {
				blue++;
			}
		}
		int i = 0;
		int k = 0;
		while (i < red) {
			nums[k] = 0;
			k++;
			i++;
		}
		i = 0;
		while (i < white) {
			nums[k] = 1;
			k++;
			i++;
		}
		i = 0;
		while (i < blue) {
			nums[k] = 2;
			k++;
			i++;
		}
	}

	void printArray(final int[] array) {
		for (int i : array) {
			System.out.print(i + " ");
		}
	}

	public static void main(String[] args) {
		final SortColors s = new SortColors();
		final int[] nums1 = { 2, 0, 2, 1, 1, 0 };
		System.out.print("Original list : ");
		s.printArray(nums1);
		s.sortColors(nums1);
		System.out.print("\nSorted list : ");
		s.printArray(nums1);

		final int[] nums2 = { 2, 0, 1 };
		System.out.print("\n\nOriginal list : ");
		s.printArray(nums2);
		s.sortColors(nums2);
		System.out.print("\nSorted list : ");
		s.printArray(nums2);

		final int[] nums3 = { 0, 2, 1 };
		System.out.print("\n\nOriginal list : ");
		s.printArray(nums3);
		s.sortColors(nums3);
		System.out.print("\nSorted list : ");
		s.printArray(nums3);

		final int[] nums4 = { 2, 1, 0 };
		System.out.print("\n\nOriginal list : ");
		s.printArray(nums4);
		s.sortColors(nums4);
		System.out.print("\nSorted list : ");
		s.printArray(nums4);

		final int[] nums5 = { 1, 2, 0 };
		System.out.print("\n\nOriginal list : ");
		s.printArray(nums5);
		s.sortColors(nums5);
		System.out.print("\nSorted list : ");
		s.printArray(nums5);

		final int[] nums6 = { 1, 2, 2, 2, 2, 0, 0, 0, 1, 1 };
		System.out.print("\n\nOriginal list : ");
		s.printArray(nums6);
		s.sortColors(nums6);
		System.out.print("\nSorted list : ");
		s.printArray(nums6);
	}
}
