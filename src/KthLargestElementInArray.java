/*
Problem Statement -
https://leetcode.com/problems/kth-largest-element-in-an-array/
*/

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;

public class KthLargestElementInArray {

	public int findKthLargest(int[] nums, int k) {
		final Map<Integer, Integer> frequency = new LinkedHashMap<>();
		for (int i : nums) {
			frequency.merge(i, 1, Integer::sum);
		}
		System.out.println(frequency);

		final TreeSet<Integer> sortedList = new TreeSet<>(Collections.reverseOrder());
		sortedList.addAll(frequency.keySet());
		System.out.println("Sorted keys : " + sortedList);

		int j = 0;
		for (Integer i : sortedList) {
			Integer freq = frequency.get(i);
			while (freq-- > 0) {
				nums[j++] = i;
			}
		}
		if (k - 1 >= 0 && k - 1 < nums.length) {
			return nums[k - 1];
		}
		return -1;
	}

	public static void main(String[] args) {
		final KthLargestElementInArray k = new KthLargestElementInArray();
		final int[] nums1 = { 3, 2, 1, 5, 6, 4 };
		final int k1 = 2;
		System.out.println("Element at location " + k1 + " is " + k.findKthLargest(nums1, k1));

		final int[] nums2 = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
		final int k2 = 4;
		System.out.println("Element at location " + k2 + " is " + k.findKthLargest(nums2, k2));

		final int[] nums3 = { 5, 7, 3, 96, 73, 10 };
		final int k3 = 2;
		System.out.println("Element at location " + k3 + " is " + k.findKthLargest(nums3, k3));
	}
}
