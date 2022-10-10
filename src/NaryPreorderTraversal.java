/*
Problem Statement -
https://leetcode.com/problems/n-ary-tree-preorder-traversal/
*/

import java.util.ArrayList;
import java.util.List;

class Node {
	public int val;
	public List<Node> children;

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, List<Node> _children) {
		val = _val;
		children = _children;
	}
}

public class NaryPreorderTraversal {

	public static List<Integer> preorder(Node root) {
		final List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		result.add(root.val);
		if (root.children != null) {
			root.children.forEach(c -> result.addAll(preorder(c)));
		}
		return result;
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		Node child1 = new Node(3);
		Node child2 = new Node(2);
		Node child3 = new Node(4);
		Node child4 = new Node(5);
		Node child5 = new Node(6);

		root.children = new ArrayList<>();
		root.children.add(child1);
		root.children.add(child2);
		root.children.add(child3);
		child1.children = new ArrayList<>();
		child1.children.add(child4);
		child1.children.add(child5);

		System.out.println(preorder(root));
	}
}
