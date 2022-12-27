/*
Problem Statement -
https://leetcode.com/problems/3sum/
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public List<List<Integer>> threeSum(int[] nums) {
		final List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int l = i + 1;
			int r = nums.length - 1;
			while (l < r) {
				int sum = nums[i] + nums[l] + nums[r];
				if (sum > 0) {
					r--;
				} else if (sum < 0) {
					l++;
				} else {
					result.add(Arrays.asList(nums[i], nums[l], nums[r]));
					l++;
					while (nums[l] == nums[l - 1] && l < r) {
						l++;
					}
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		final ThreeSum t = new ThreeSum();
		final int[] nums1 = { -1, 0, 1, 2, -1, -4 };
		System.out.println(t.threeSum(nums1));
	}
}
