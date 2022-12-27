/*
Problem Statement -
https://leetcode.com/problems/group-anagrams/
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	private List<Integer> primeNumbers = getPrimeNumbers();

	public List<List<String>> groupAnagrams(String[] strs) {
		final Map<Double, List<String>> result = new HashMap<>();
		for (String s : strs) {
			final double hash = hashTheString(s);
			final List<String> existingList = result.get(hash);
			if (existingList != null) {
				existingList.add(s);
			} else {
				final List<String> list = new ArrayList<>();
				list.add(s);
				result.put(hash, list);
			}
		}
		return new ArrayList<>(result.values());
	}

	double hashTheString(final String str) {
		double hash = 1;
		for (char c : str.toCharArray()) {
			hash *= primeNumbers.get(c - 'a');
		}
		return hash;
	}

	List<Integer> getPrimeNumbers() {
		final List<Integer> primeNos = new ArrayList<>();
		int prime = 1;
		for (int i = 0; i < 26; i++) {
			prime = nextPrime(prime);
			primeNos.add(prime);
		}
		return primeNos;
	}

	int nextPrime(int number) {
		for (int i = number + 1; i < Integer.MAX_VALUE; i++) {
			if (isPrime(i)) {
				return i;
			}
		}
		return -1;
	}

	boolean isPrime(int num) {
		if (num <= 3) {
			return (num == 2 || num == 3) ? true : false;
		}
		if (num % 2 == 0 || num % 3 == 0) {
			return false;
		}
		for (int i = 5; i < Math.sqrt(Integer.MAX_VALUE); i++) {
			if (i != num && num % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		final GroupAnagrams g = new GroupAnagrams();
		final String[] strs1 = { "eat", "tea", "tan", "ate", "nat", "bat" };
		System.out.println(g.groupAnagrams(strs1));

		final String[] strs2 = { "" };
		System.out.println(g.groupAnagrams(strs2));

		final String[] strs3 = { "cab", "tin", "pew", "duh", "may", "ill", "buy", "bar", "max", "doc" };
		System.out.println(g.groupAnagrams(strs3));

		final String[] strs4 = { "eat", "tea", "tan", "ate", "nat", "bat", "ac", "bd", "aac", "bbd", "aacc", "bbdd",
				"acc", "bdd" };
		System.out.println(g.groupAnagrams(strs4));

		final String[] strs5 = { "run", "had", "lot", "kim", "fat", "net", "fin", "rca", "chi", "lei", "lox", "iva",
				"liz", "hug", "hot", "irk", "lap", "tan", "tux", "yuk", "hep", "map", "ran", "ell", "kit", "put", "non",
				"aol", "add", "lad", "she", "job", "mes", "pen", "vic", "fag", "bud", "ken", "nod", "jam", "coy", "hui",
				"sue", "nap", "ton", "coy", "rut", "fit", "cut", "eta", "our", "oho", "zip" };
		System.out.println(g.groupAnagrams(strs5));

		final String[] strs6 = { "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" };
		System.out.println(g.groupAnagrams(strs6));

		final String[] strs7 = { "sol", "pan", "mci", "bar", "fag", "why", "fit", "bid", "twa", "jam", "orb", "oho",
				"ate", "wet", "dig", "vic", "are", "fer", "fun", "set", "tad", "pam", "max", "axe", "fag", "emu", "wig",
				"hie", "tie", "hug", "sac", "lon", "mit", "yon", "art", "maw", "hon", "nat", "log", "ken", "tar", "hop",
				"beg", "gel", "doe", "ray", "dip" };
		System.out.println(g.groupAnagrams(strs7));

		final String[] strs8 = {
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab" };
		System.out.println(g.groupAnagrams(strs8));
	}
}
