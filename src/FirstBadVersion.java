/*
Problem Statement -
https://leetcode.com/problems/first-bad-version/
*/

public class FirstBadVersion {

	public int firstBadVersion(int n) {
		return binarySearch(1, n);
	}

	private int binarySearch(int s, int e) {
		if (s > e) {
			return -1;
		}
		int m = s + (e - s) / 2;
		if (isBadVersion(m)) {
			int ans = binarySearch(s, m - 1);
			return ans == -1 ? m : Math.min(m, ans);
		} else {
			return binarySearch(m + 1, e);
		}
	}

	private boolean isBadVersion(int version) {
		return version >= 1702766719;
	}

	public static void main(String[] args) {
		// Some other examples -

		// n = 1, bad = 1
		// n = 2, bad = 2
		// n = 3, bad = 1
		// n = 5, bad = 4
		// n = 2126753390, bad = 1702766719

		final FirstBadVersion f = new FirstBadVersion();
		int n = 2126753390;
		// int bad = 1702766719;
		System.out.println(f.firstBadVersion(n));
	}
}
