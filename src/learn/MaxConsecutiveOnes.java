package learn;

public class MaxConsecutiveOnes {

	private static int findMaxConsecutiveOnes(int[] nums) {
		int maxOnes = 0;
		int count = 0;
		for (int i : nums) {
			if (i == 1) {
				count++;
				maxOnes = Math.max(maxOnes, count);
			} else if (i == 0) {
				count = 0;
			}
		}
		return maxOnes;
	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 1, 0, 1, 1, 1 };
		System.out.println(findMaxConsecutiveOnes(nums1));

		int[] nums2 = { 1, 0, 1, 1, 0, 1 };
		System.out.println(findMaxConsecutiveOnes(nums2));
	}
}
