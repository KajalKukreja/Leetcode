package learn;

public class ReverseArray {
	
	private static void reverse(int[] nums, int n) {
		int i = 0;
		int j = n - 1;
		while (i < j) {
			swap(nums, i, j);
			i++;
			j--;
		}
	}

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6 };
		reverse(nums, 6);
		for (int i : nums) {
			System.out.print(i + "  ");
		}
	}
}
