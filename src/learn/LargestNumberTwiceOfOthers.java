package learn;

public class LargestNumberTwiceOfOthers {

	private static int dominantIndex(int[] nums) {
		int index = -1;
		int max = -1;
		int secondMax = -1;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > max) {
				secondMax = max;
				max = nums[i];
				index = i;
			} else if (nums[i] > secondMax) {
				secondMax = nums[i];
			}
		}
		return (secondMax * 2 <= max) ? index : -1;
	}

	public static void main(String[] args) {
		int[] nums1 = { 3, 6, 1, 0 };
		System.out.println(dominantIndex(nums1));

		int[] nums2 = { 1, 2, 3, 4 };
		System.out.println(dominantIndex(nums2));
	}
}
