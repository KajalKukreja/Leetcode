/*
Problem Statement -
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
*/

public class LowestCommonAncestorOfBinaryTree {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

		@Override
		public String toString() {
			return String.valueOf(val);
		}
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) {
			return root;
		}
		final TreeNode left = lowestCommonAncestor(root.left, p, q);
		final TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (left != null && right != null) {
			return root;
		}
		return left != null ? left : right;
	}

	public static void main(String[] args) {
		final LowestCommonAncestorOfBinaryTree l = new LowestCommonAncestorOfBinaryTree();

		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);

		TreeNode p = root.left;
		TreeNode q = root.right;

		System.out.println(l.lowestCommonAncestor(root, p, q));

		p = root.left;
		q = root.left.right.right;
		System.out.println(l.lowestCommonAncestor(root, p, q));

		root = new TreeNode(1);
		root.left = new TreeNode(2);
		p = root;
		q = root.left;
		System.out.println(l.lowestCommonAncestor(root, p, q));

		root = new TreeNode(-1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(-2);
		root.left.right = new TreeNode(4);
		root.left.left.left = new TreeNode(8);
		p = root.left.left.left;
		q = root.left.right;
		System.out.println(l.lowestCommonAncestor(root, p, q));
	}
}
