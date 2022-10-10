package learn;

import java.util.Arrays;

public class ArrayPartitionI {

	private static int arrayPairSum(int[] nums) {
		Arrays.sort(nums);
		int sum = 0;
		for (int i = 0; i < nums.length; i = i + 2) {
			sum += nums[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 3, 4 };
		System.out.println(arrayPairSum(nums1));
		int[] nums2 = { 6, 2, 6, 5, 1, 2 };
		System.out.println(arrayPairSum(nums2));
	}
}
