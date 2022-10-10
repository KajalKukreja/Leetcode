/*
Problem Statement -
https://leetcode.com/problems/validate-binary-search-tree/
*/

public class ValidateBinarySearchTree {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static boolean isValidBST(TreeNode root) {
		return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	public static boolean checkBST(TreeNode root, long minValue, long maxValue) {
		if (root == null) {
			return true;
		}
		if (root.val <= minValue || root.val >= maxValue) {
			return false;
		}
		return checkBST(root.left, minValue, root.val) && checkBST(root.right, root.val, maxValue);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		System.out.println(isValidBST(root));

		root = new TreeNode(14);
		root.left = new TreeNode(9);
		root.right = new TreeNode(32);
		System.out.println(isValidBST(root));

		root = null;
		System.out.println(isValidBST(root));

		root = new TreeNode(5);
		root.left = new TreeNode(3);
		System.out.println(isValidBST(root));

		root = new TreeNode(10);
		root.left = new TreeNode(3);
		root.right = new TreeNode(5);
		System.out.println(isValidBST(root));

		root = new TreeNode(2);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		System.out.println(isValidBST(root));

		root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(6);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(7);
		System.out.println(isValidBST(root));

		root = new TreeNode(2147483647);
		System.out.println(isValidBST(root));
	}
}
