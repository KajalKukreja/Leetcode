/*
Problem Statement -
https://leetcode.com/problems/top-k-frequent-elements/
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TopKFrequentElements {

	public int[] topKFrequent(int[] nums, int k) {
		final Map<Integer, Integer> frequencies = new TreeMap<>();
		for (int i : nums) {
			frequencies.merge(i, 1, Integer::sum);
		}
		System.out.println("Frequencies : " + frequencies);

		final List<Map.Entry<Integer, Integer>> resultList = new ArrayList<>(frequencies.entrySet());
		Collections.sort(resultList, new Comparator<Map.Entry<Integer, Integer>>() {
			@Override
			public int compare(Map.Entry<Integer, Integer> i, Map.Entry<Integer, Integer> j) {
				return j.getValue().compareTo(i.getValue());
			}
		});
		System.out.println("Sorted by frequencies : " + resultList);

		int[] result = new int[k];
		for (int i = 0; i < k; i++) {
			result[i] = resultList.get(i).getKey();
		}
		return result;
	}

	void printArray(int[] nums) {
		for (int i : nums) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		final TopKFrequentElements t = new TopKFrequentElements();
		final int[] nums1 = { 1, 1, 1, 2, 2, 3 };
		final int k1 = 2;
		System.out.println("\nTop " + k1 + " elements -");
		t.printArray(t.topKFrequent(nums1, k1));

		final int[] nums2 = { 5, 2, 3, 2, 1, 5, 5, 2, 2, 2, 1 };
		final int k2 = 2;
		System.out.println("\nTop " + k2 + " elements -");
		t.printArray(t.topKFrequent(nums2, k2));
	}
}
