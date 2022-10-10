/*
Problem Statement -
https://leetcode.com/problems/rotate-array/
*/

public class RotateArray {

	public static void rotateLessEfficient(int[] nums, int k) {
		while (k-- > 0) {
			int v = nums[nums.length - 1];
			for (int j = nums.length - 1; j > 0; j--) {
				nums[j] = nums[j - 1];
			}
			nums[0] = v;
		}
	}

	public static void rotate(int[] nums, int k) {
		k = k % nums.length;
		reverse(nums, 0, nums.length - k - 1);
		reverse(nums, nums.length - k, nums.length - 1);
		reverse(nums, 0, nums.length - 1);
	}

	private static void reverse(int[] nums, int s, int e) {
		while (s < e) {
			int t = nums[s];
			nums[s] = nums[e];
			nums[e] = t;
			s++;
			e--;
		}
	}

	private static void printArray(int[] nums) {
		for (int n : nums) {
			System.out.print(n + "  ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		rotate(nums, 3);
		printArray(nums);

		int nums2[] = { -1, -100, 3, 99 };
		rotate(nums2, 2);
		printArray(nums2);

		int nums3[] = { -1 };
		rotate(nums3, 2);
		printArray(nums3);

		int nums4[] = { 8, 10 };
		rotate(nums4, 2);
		printArray(nums4);

		int nums5[] = { 1, 2 };
		rotate(nums5, 3);
		printArray(nums5);

	}
}
