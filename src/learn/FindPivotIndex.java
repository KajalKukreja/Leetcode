package learn;

import java.util.Arrays;

public class FindPivotIndex {

	private static int pivotIndex(int[] nums) {
		int lSum = 0;
		int rSum = Arrays.stream(nums).sum();
		for (int i = 0; i < nums.length; i++) {
			rSum -= nums[i];
			if (lSum == rSum) {
				return i;
			}
			lSum += nums[i];
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 7, 3, 6, 5, 6 };
		System.out.println(pivotIndex(nums1));

		int[] nums2 = { 1, 2, 3 };
		System.out.println(pivotIndex(nums2));

		int[] nums3 = { 2, 1, -1 };
		System.out.println(pivotIndex(nums3));
	}
}
