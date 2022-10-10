/*
Problem Statement -
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
*/

public class LowestCommonAncestor {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || (p == null && q == null)) {
			return null;
		}
		
		TreeNode lca = null;
		if (p != null && checkNode(p.val < root.val ? root.left : root.right, p)) {
			if (q != null && checkNode(q.val < root.val ? root.left : root.right, q)) {
				lca = root;
			}
		}
		return lca;
	}
	
	private static boolean checkNode(TreeNode root, TreeNode node) {
		if (root == null) {
			return false;
		}
		if (root.val == node.val) {
			return true;
		}
		return checkNode(node.val < root.val ? root.left : root.right, node);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(2);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(9);
		root.left.right.left = new TreeNode(3);
		root.left.right.right = new TreeNode(5);
		TreeNode res = lowestCommonAncestor(root, new TreeNode(2), new TreeNode(8));
		System.out.println(res != null ? res.val : null);
		
		res = lowestCommonAncestor(root, new TreeNode(2), new TreeNode(4));
		System.out.println(res != null ? res.val : null);
		
		root = new TreeNode(2);
		root.left = new TreeNode(1);
		res = lowestCommonAncestor(root, new TreeNode(2), new TreeNode(1));
		System.out.println(res != null ? res.val : null);
		
		root = null;
		res = lowestCommonAncestor(root, new TreeNode(2), new TreeNode(8));
		System.out.println(res != null ? res.val : null);
		
	}
}
