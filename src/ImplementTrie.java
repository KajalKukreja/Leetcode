/*
Problem Statement -
https://leetcode.com/problems/implement-trie-prefix-tree/
*/

import java.util.HashMap;
import java.util.Map;

public class ImplementTrie {

	static class TrieNode {
		private Map<Character, TrieNode> children;
		private boolean endOfWord;

		public TrieNode() {
			children = new HashMap<>();
			endOfWord = false;
		}

		@Override
		public String toString() {
			return String.format("Node[ children=%s, endOfWord=%s]", children, endOfWord);
		}
	}

	private final TrieNode root;

	public ImplementTrie() {
		root = new TrieNode();
	}

	public void insert(String word) {
		TrieNode current = root;
		for (Character c : word.toCharArray()) {
			TrieNode node = current.children.get(c);
			if (node == null) {
				node = new TrieNode();
				System.out.println("Inserted " + c);
				current.children.put(c, node);
			}
			current = node;
		}
		current.endOfWord = true;
	}

	public boolean search(String word) {
		TrieNode current = root;
		for (Character c : word.toCharArray()) {
			final TrieNode node = current.children.get(c);
			if (node == null) {
				return false;
			}
			current = node;
		}
		return current.endOfWord;
	}

	public boolean startsWith(String prefix) {
		TrieNode current = root;
		for (Character c : prefix.toCharArray()) {
			final TrieNode node = current.children.get(c);
			if (node == null) {
				return false;
			}
			current = node;
		}
		return true;
	}

	public static void main(String[] args) {
		final ImplementTrie t = new ImplementTrie();
		t.insert("cat");
		System.out.println(t.root);
		t.insert("apple");
		System.out.println(t.root);
		t.insert("app");
		System.out.println(t.root);
		System.out.println("Do we have cat? " + t.search("cat"));
		System.out.println("Do we have prefix c? " + t.startsWith("c"));
		System.out.println("Do we have apple? " + t.search("apple"));
		System.out.println("Do we have app? " + t.search("app"));
		System.out.println("Do we have prefix ap? " + t.startsWith("ap"));
		System.out.println("Do we have prefix fa? " + t.startsWith("fa"));
	}
}
