package learn;

public class MinSubArraySum {

	private static int minSubArrayLen(int target, int[] nums) {
		int minLen = Integer.MAX_VALUE;
		int sum = 0;
		int left = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			while (sum >= target) {
				minLen = Math.min(minLen, i + 1 - left);
				sum -= nums[left];
				left++;
			}
		}
		return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
	}

	public static void main(String[] args) {
		int target1 = 7;
		int[] nums1 = { 2, 3, 1, 2, 4, 3 };
		System.out.println(minSubArrayLen(target1, nums1));

		int target2 = 4;
		int[] nums2 = { 1, 4, 4 };
		System.out.println(minSubArrayLen(target2, nums2));

		int target3 = 11;
		int[] nums3 = { 1, 1, 1, 1, 1, 1, 1, 1 };
		System.out.println(minSubArrayLen(target3, nums3));

		int target4 = 213;
		int[] nums4 = { 12, 28, 83, 4, 25, 26, 25, 2, 25, 25, 25, 12 };
		System.out.println(minSubArrayLen(target4, nums4));
	}
}
