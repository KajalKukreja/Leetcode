/*
Problem Statement -
https://leetcode.com/problems/insert-delete-getrandom-o1/
*/

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InsertDeleteGetRandom {

	private final Map<Integer, Integer> randomNumbers;
	private final List<Integer> numbers;
	private final SecureRandom random;

	public InsertDeleteGetRandom() {
		randomNumbers = new HashMap<>();
		numbers = new ArrayList<>();
		random = new SecureRandom();
	}

	public boolean insert(int val) {
		if (randomNumbers.containsKey(val)) {
			return false;
		}
		numbers.add(val);
		randomNumbers.put(val, numbers.size() - 1);
		System.out.println("Added " + val + " at index " + (numbers.size() - 1));
		return true;
	}

	public boolean remove(int val) {
		if (!randomNumbers.containsKey(val)) {
			return false;
		}
		final Integer index = randomNumbers.get(val);
		Collections.swap(numbers, index, numbers.size() - 1);
		randomNumbers.put(numbers.get(index), index);
		numbers.remove(numbers.size() - 1);
		randomNumbers.remove(val);
		System.out.println("Removed " + val + " from index " + index);
		return true;
	}

	public int getRandom() {
		return numbers.get(random.nextInt(numbers.size()));
	}

	public static void main(String[] args) {
		final InsertDeleteGetRandom i = new InsertDeleteGetRandom();
		System.out.println(i.remove(0));
		System.out.println(i.remove(0));
		System.out.println(i.insert(0));
		System.out.println(i.getRandom());
		System.out.println(i.remove(0));
		System.out.println(i.insert(0));
		System.out.println(i.numbers);
		System.out.println(i.randomNumbers);
	}
}
