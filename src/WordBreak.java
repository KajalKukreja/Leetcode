/*
Problem Statement -
https://leetcode.com/problems/word-break/
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {

	static class TrieNode {
		private Map<Character, TrieNode> children;
		private boolean isCompleteWord;

		public TrieNode() {
			children = new HashMap<>();
			isCompleteWord = false;
		}

		@Override
		public String toString() {
			return String.format("Node[ children=%s, isCompleteWord=%s ]", children, isCompleteWord);
		}
	}

	static class Trie {
		private TrieNode root = new TrieNode();

		private void insert(final String word) {
			TrieNode current = root;
			for (Character c : word.toCharArray()) {
				TrieNode node = current.children.get(c);
				if (node == null) {
					node = new TrieNode();
					current.children.put(c, node);
				}
				current = node;
			}
			current.isCompleteWord = true;
		}

		private TrieNode searchPrefix(String prefix, TrieNode current) {
			System.out.println("Searching " + prefix);
			for (Character c : prefix.toCharArray()) {
				final TrieNode node = current.children.get(c);
				if (node == null) {
					return null;
				}
				current = node;
			}
			return current;
		}

		private String readRemainingWord(TrieNode current) {
			final StringBuilder sb = new StringBuilder("");
			if (current == null) {
				return sb.toString();
			}
			while (!current.children.isEmpty()) {
				current.children.keySet().forEach(sb::append);
				current = current.children.entrySet().iterator().next().getValue();
			}
			return sb.toString();
		}
	}

	private Map<String, List<String>> notUseful;

	public boolean wordBreak(String s, List<String> wordDict) {
		notUseful = new HashMap<>();
		return wordBreakRecursive(s, wordDict, null);
	}

	private boolean wordBreakRecursive(final String s, final List<String> wordDict, TrieNode current) {
		final Trie trie = new Trie();
		trie.insert(s);
		if (current == null) {
			current = trie.root;
		}
		TrieNode currRoot = current;
		for (String word : wordDict) {
			final List<String> obj = notUseful.get(s);
			if (obj == null || !obj.contains(word)) {
				final TrieNode node = trie.searchPrefix(word, currRoot);
				if (node == null) {
					List<String> list = notUseful.get(s);
					if (list == null) {
						list = new ArrayList<>();
						list.add(word);
						notUseful.put(s, list);
					} else {
						list.add(word);
					}
				} else {
					currRoot = node;
					if (currRoot.isCompleteWord) {
						return true;
					}
					final String remainingWord = trie.readRemainingWord(currRoot);
					if (wordBreakRecursive(remainingWord, wordDict, currRoot)) {
						return true;
					} else {
						currRoot = current;
					}
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		final WordBreak wb = new WordBreak();
		final String s1 = "leetcode";
		final List<String> wordDict1 = Arrays.asList("leet", "code");
		System.out.println(wb.wordBreak(s1, wordDict1));

		final String s2 = "applepenapple";
		final List<String> wordDict2 = Arrays.asList("apple", "pen");
		System.out.println(wb.wordBreak(s2, wordDict2));

		final String s3 = "catsandog";
		final List<String> wordDict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
		System.out.println(wb.wordBreak(s3, wordDict3));

		final String s4 = "cars";
		final List<String> wordDict4 = Arrays.asList("car", "ca", "rs");
		System.out.println(wb.wordBreak(s4, wordDict4));

		final String s5 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		final List<String> wordDict5 = Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa",
				"aaaaaaaaa", "aaaaaaaaaa");
		// Timed out at this case
		// System.out.println(wb.wordBreak(s5, wordDict5));
	}
}
