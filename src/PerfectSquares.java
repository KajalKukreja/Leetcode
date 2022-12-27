/*
Problem Statement -
https://leetcode.com/problems/perfect-squares/
*/

import java.util.HashMap;
import java.util.Map;

public class PerfectSquares {

	final Map<Integer, Integer> dp = new HashMap<>();

	public int numSquares(int n) {
		dp.clear();
		return solve(n);
	}

	private int solve(int n) {
		if (n <= 3) {
			return n;
		}
		final Integer nRes = dp.get(n);
		if (nRes != null) {
			return nRes;
		}
		int res = n;
		for (int i = 1; i * i <= n; i++) {
			res = Math.min(res, 1 + solve(n - i * i));
		}
		dp.put(n, res);
		return res;
	}

	public static void main(String[] args) {
		final PerfectSquares p = new PerfectSquares();
		System.out.println(p.numSquares(12));
		System.out.println(p.numSquares(25));
		System.out.println(p.numSquares(38));
		System.out.println(p.numSquares(25));
		System.out.println(p.numSquares(5));
	}
}
