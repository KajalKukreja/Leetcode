/*
Problem Statement -
https://leetcode.com/problems/binary-tree-level-order-traversal/
*/

import java.util.ArrayList;
import java.util.List;

class TreeNode {
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

public class BinaryTreeLevelOrderTraversal {

	private static int getHeight(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) {
			return 0;
		}
		return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}

	private static List<Integer> getLevel(TreeNode root, int level) {
		final List<Integer> result = new ArrayList<>();
		if (level == 0) {
			result.add(root.val);
		} else {
			if (root.left != null) {
				result.addAll(getLevel(root.left, level - 1));
			}
			if (root.right != null) {
				result.addAll(getLevel(root.right, level - 1));
			}
		}
		return result;
	}

	public static List<List<Integer>> levelOrder(TreeNode root) {
		final List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		for (int i = 0; i <= getHeight(root); i++) {
			result.add(getLevel(root, i));
		}
		return result;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println(levelOrder(root));

		root = null;
		System.out.println(levelOrder(root));

		root = new TreeNode(1);
		System.out.println(levelOrder(root));
	}
}
