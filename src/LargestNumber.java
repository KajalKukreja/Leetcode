/*
Problem Statement -
https://leetcode.com/problems/largest-number/
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {

	public String largestNumber(int[] nums) {
		if (nums == null || nums.length == 0) {
			return "";
		}
		final List<String> numList = new ArrayList<>();
		for (int i : nums) {
			numList.add(i + "");
		}
		Collections.sort(numList, new Comparator<String>() {
			@Override
			public int compare(final String num1, final String num2) {
				final String s1 = num1 + num2;
				final String s2 = num2 + num1;
				return s1.compareTo(s2);
			}
		});
		final StringBuilder sb = new StringBuilder();
		for (int i = numList.size() - 1; i >= 0; i--) {
			sb.append(numList.get(i));
		}
		final String s = sb.toString();
		return s.charAt(0) == '0' ? "0" : s;
	}

	String compare(final int num1, final int num2) {
		final String s1 = num1 + "" + num2;
		final String s2 = num2 + "" + num1;
		return s1.compareTo(s2) > 0 ? String.valueOf(num1) : String.valueOf(num2);
	}

	public static void main(String[] args) {
		final LargestNumber l = new LargestNumber();
		final int[] nums1 = { 10, 2 };
		System.out.println("Largest no. is " + l.largestNumber(nums1));

		final int[] nums2 = { 3, 30, 34, 5, 9 };
		System.out.println("Largest no. is " + l.largestNumber(nums2));

		final int[] nums3 = { 34323, 3432 };
		System.out.println("Largest no. is " + l.largestNumber(nums3));

		final int[] nums4 = { 10, 2, 9, 39, 17 };
		System.out.println("Largest no. is " + l.largestNumber(nums4));

		final int[] nums5 = { 0, 0 };
		System.out.println("Largest no. is " + l.largestNumber(nums5));
	}
}
