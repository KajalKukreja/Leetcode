package learn;

public class TwoSumII {

	private static int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		for (int i = 0; i < numbers.length; i++) {
			int curr = numbers[i];
			int needValue = target - curr;
			int index = -1;
			if (needValue >= curr && i + 1 < numbers.length) {
				index = binarySearch(numbers, i + 1, numbers.length - 1, needValue);
			} else if (i - 1 >= 0) {
				index = binarySearch(numbers, 0, i - 1, needValue);
			}
			if (index != -1) {
				result[0] = i + 1;
				result[1] = index + 1;
				break;
			}
		}
		return result;
	}

	private static int binarySearch(int[] nums, int start, int end, int target) {
		if (start > end) {
			return -1;
		}
		int mid = start + (end - start) / 2;
		if (nums[mid] == target) {
			return mid;
		}
		if (target < nums[mid]) {
			return binarySearch(nums, start, mid - 1, target);
		} else {
			return binarySearch(nums, mid + 1, end, target);
		}
	}

	private static void printArray(int[] array) {
		for (int i : array) {
			System.out.print(i + "  ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] numbers1 = { 2, 7, 11, 15 };
		int target1 = 9;
		printArray(twoSum(numbers1, target1));

		int[] numbers2 = { 2, 3, 4 };
		int target2 = 6;
		printArray(twoSum(numbers2, target2));

		int[] numbers3 = { -1, 0 };
		int target3 = -1;
		printArray(twoSum(numbers3, target3));
	}
}
