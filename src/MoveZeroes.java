/*
Problem Statement -
https://leetcode.com/problems/move-zeroes/
*/

public class MoveZeroes {

	public static void moveZeroes(int[] nums) {
		if (nums.length > 1) {
			int p1 = 0;
			int p2 = 1;
			while (p2 < nums.length) {
				if (nums[p1] == 0) {
					if (nums[p2] == 0) {
						p2++;
					} else {
						int v = nums[p1];
						nums[p1] = nums[p2];
						nums[p2] = v;
						p1++;
						p2++;
					}
				} else {
					p1++;
					p2++;
				}
			}
		}
	}

	public static void moveZeroesAnotherWay(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		int cur = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				int temp = nums[cur];
				nums[cur++] = nums[i];
				nums[i] = temp;
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
		int[] nums = { 0, 1, 0, 3, 12 };
		moveZeroes(nums);
		printArray(nums);

		int nums2[] = { 0 };
		moveZeroes(nums2);
		printArray(nums2);

		int nums3[] = { 3, 2, 1 };
		moveZeroes(nums3);
		printArray(nums3);

		int nums4[] = { 0, 5 };
		moveZeroes(nums4);
		printArray(nums4);

		int nums5[] = { 1, 0, 1 };
		moveZeroes(nums5);
		printArray(nums5);
	}
}
