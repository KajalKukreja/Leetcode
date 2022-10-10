package learn;

public class RemoveElement {

	private static int removeElement(int[] nums, int val) {
		int k = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[k] = nums[i];
				k++;
			}
		}
		return k;
	}

	public static void main(String[] args) {
		int[] nums1 = { 3, 2, 2, 3 };
		int val1 = 3;
		System.out.println(removeElement(nums1, val1));

		int[] nums2 = { 0, 1, 2, 2, 3, 0, 4, 2 };
		int val2 = 2;
		System.out.println(removeElement(nums2, val2));

		int[] nums3 = { 3, 2, 5, 6, 5, 7 };
		int val3 = 5;
		System.out.println(removeElement(nums3, val3));
	}
}
