/*
Problem Statement -
https://leetcode.com/problems/kth-smallest-element-in-a-bst/
*/

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInBST {

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

	final List<Integer> inOrderList = new ArrayList<>();

	public int kthSmallest(TreeNode root, int k) {
		inOrder(root);
		return inOrderList.isEmpty() ? -1 : inOrderList.get(k - 1);
	}

	private void inOrder(TreeNode root) {
		if (root != null) {
			inOrder(root.left);
			inOrderList.add(root.val);
			inOrder(root.right);
		}
	}

	public static void main(String[] args) {
		final KthSmallestElementInBST k = new KthSmallestElementInBST();

		final TreeNode root1 = new TreeNode(3);
		root1.left = new TreeNode(1);
		root1.right = new TreeNode(4);
		root1.left.right = new TreeNode(2);
		final int k1 = 1;
		System.out.println(k.kthSmallest(root1, k1));

		final TreeNode root2 = new TreeNode(5);
		root2.left = new TreeNode(3);
		root2.right = new TreeNode(6);
		root2.left.left = new TreeNode(2);
		root2.left.right = new TreeNode(4);
		root2.left.left.left = new TreeNode(1);
		final int k2 = 3;
		System.out.println(k.kthSmallest(root2, k2));
	}
}
