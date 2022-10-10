/*
Problem Statement -
https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
*/

public class PopulatingNextRightPointers {

	static class Node {
		int val;
		Node left;
		Node right;
		Node next;

		public Node() {}
		public Node(int _val) {
			val = _val;
		}
		public Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	}

	private static Node connect(Node root) {
		if (root == null || (root.left == null && root.right == null)) {
			return root;
		}
		if (root.left != null && root.right != null) {
			root.left.next = root.right;
		}
		if (root.next != null) {
			root.right.next = root.next.left;
		}
		connect(root.left);
		connect(root.right);
		return root;
	}

	private static int getHeight(Node root) {
		if (root == null || (root.left == null && root.right == null)) {
			return 0;
		}
		return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}

	private static void printLevelOrder(Node root) {
		if (root != null && root.left != null && root.right != null) {
			for (int level = 0; level <= getHeight(root); level++) {
				printLevel(root, level);
			}
		}
	}

	private static void printLevel(Node root, int level) {
		if (level == 0) {
			System.out.print(root.val + " ");
		} else {
			printLevel(root.left, level - 1);
			printLevel(root.right, level - 1);
		}
	}

	private static void printNextPointers(Node root) {
		if (root != null && root.left != null && root.right != null) {
			for (int level = 0; level <= getHeight(root); level++) {
				printNextPointersOnLevel(root, level);
			}
		}
	}

	private static void printNextPointersOnLevel(Node root, int level) {
		if (level == 0) {
			if (root.next != null) {
				System.out.print(root.val + " " + root.next.val + ", ");
			} else {
				System.out.print(root.val + " #, ");
			}
		} else {
			printNextPointersOnLevel(root.left, level - 1);
			printNextPointersOnLevel(root.right, level - 1);
		}
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		System.out.println("Original Tree");
		printLevelOrder(root);
		System.out.println();
		System.out.println("Next pointers");
		printNextPointers(root);

		System.out.println();
		System.out.println();

		System.out.println("Connected Tree");
		printLevelOrder(connect(root));
		System.out.println();
		System.out.println("Next pointers");
		printNextPointers(root);

		System.out.println();
		System.out.println();

		root = new Node(-1);
		root.left = new Node(0);
		root.right = new Node(1);
		root.left.left = new Node(2);
		root.left.right = new Node(3);
		root.right.left = new Node(4);
		root.right.right = new Node(5);
		root.left.left.left = new Node(6);
		root.left.left.right = new Node(7);
		root.left.right.left = new Node(8);
		root.left.right.right = new Node(9);
		root.right.left.left = new Node(10);
		root.right.left.right = new Node(11);
		root.right.right.left = new Node(12);
		root.right.right.right = new Node(13);

		System.out.println("Original Tree");
		printLevelOrder(root);
		System.out.println();
		System.out.println("Next pointers");
		printNextPointers(root);

		System.out.println();
		System.out.println();

		System.out.println("Connected Tree");
		printLevelOrder(connect(root));
		System.out.println();
		System.out.println("Next pointers");
		printNextPointers(root);
	}
}
