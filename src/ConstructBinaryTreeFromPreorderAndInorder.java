/*
Problem Statement -
https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
*/

import java.util.Arrays;

public class ConstructBinaryTreeFromPreorderAndInorder {

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

	private void printArray(int[] array) {
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0) {
			return null;
		}
		System.out.print("Preorder : ");
		printArray(preorder);
		System.out.print("Inorder : ");
		printArray(inorder);

		final TreeNode root = new TreeNode(preorder[0]);

		int index = 0;
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == root.val) {
				index = i;
				break;
			}
		}
		final int[] newLeftPreOrder = Arrays.copyOfRange(preorder, 1, index + 1);
		final int[] newRightPreOrder = Arrays.copyOfRange(preorder, index + 1, preorder.length);
		final int[] newLeftInorder = Arrays.copyOfRange(inorder, 0, index);
		final int[] newRightInorder = Arrays.copyOfRange(inorder, index + 1, inorder.length);
		root.left = buildTree(newLeftPreOrder, newLeftInorder);
		root.right = buildTree(newRightPreOrder, newRightInorder);
		return root;
	}

	private void printTree(TreeNode root) {
		if (root == null) {
			System.out.print("null ");
		} else {
			System.out.print(root.val + " ");
			printTree(root.left);
			printTree(root.right);
		}
	}

	public static void main(String[] args) {
		final ConstructBinaryTreeFromPreorderAndInorder c = new ConstructBinaryTreeFromPreorderAndInorder();
		final int[] preorder1 = { 3, 9, 20, 15, 7 };
		final int[] inorder1 = { 9, 3, 15, 20, 7 };
		final TreeNode root1 = c.buildTree(preorder1, inorder1);
		c.printTree(root1);
	}
}
