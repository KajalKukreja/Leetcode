/*
Problem Statement -
https://leetcode.com/problems/lru-cache/
*/

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

	final Map<Integer, Integer> cache;
	final int capacity;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		cache = new LinkedHashMap<>(capacity, 0.75f, true) {
			
			@Override
			protected boolean removeEldestEntry(Map.Entry<Integer, Integer> e) {
				return cache.size() > capacity;
			}
		};
	}

	public int get(int key) {
		return cache.getOrDefault(key, -1);
	}

	public void put(int key, int value) {
		cache.put(key, value);
	}

	public static void main(String[] args) {
		final LRUCache lRUCache = new LRUCache(2);
		lRUCache.put(1, 1);
		lRUCache.put(2, 2);
		System.out.println("Accessed " + lRUCache.get(1));
		System.out.println("Cache : " + lRUCache.cache);
		lRUCache.put(3, 3);
		System.out.println("Cache : " + lRUCache.cache);
		System.out.println("Accessed " + lRUCache.get(2));
		lRUCache.put(4, 4);
		System.out.println("Cache : " + lRUCache.cache);
		System.out.println("Accessed " + lRUCache.get(1));
		System.out.println("Accessed " + lRUCache.get(3));
		System.out.println("Accessed " + lRUCache.get(4));
		System.out.println("Cache : " + lRUCache.cache);
	}
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
