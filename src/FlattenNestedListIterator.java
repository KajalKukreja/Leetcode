/*
Problem Statement -
https://leetcode.com/problems/flatten-nested-list-iterator/
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {
	// @return true if this NestedInteger holds a single integer, rather than a
	// nested list.
	public boolean isInteger();

	// @return the single integer that this NestedInteger holds, if it holds a
	// single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger();

	// @return the nested list that this NestedInteger holds, if it holds a nested
	// list
	// Return empty list if this NestedInteger holds a single integer
	public List<NestedInteger> getList();
}

//But...For testing locally we need to implement this
class NestedIntegerImpl implements NestedInteger {

	int val;
	List<NestedInteger> list = new ArrayList<>();

	public NestedIntegerImpl(final int val) {
		this.val = val;
	}

	public NestedIntegerImpl(final List<NestedInteger> list) {
		this.list = list;
	}

	@Override
	public boolean isInteger() {
		return list.isEmpty();
	}

	@Override
	public Integer getInteger() {
		return val;
	}

	@Override
	public List<NestedInteger> getList() {
		return list;
	}

	@Override
	public String toString() {
		return list.isEmpty() ? val + "" : list.toString();
	}
}

public class FlattenNestedListIterator implements Iterator<Integer> {
	final LinkedList<Integer> linkedList = new LinkedList<>();

	public FlattenNestedListIterator(List<NestedInteger> nestedList) {
		processList(nestedList);
	}

	void processList(final List<NestedInteger> nestedList) {
		for (NestedInteger n : nestedList) {
			if (n.isInteger()) {
				linkedList.add(n.getInteger());
			} else {
				processList(n.getList());
			}
		}
	}

	@Override
	public Integer next() {
		return linkedList.remove();
	}

	@Override
	public boolean hasNext() {
		return linkedList.peek() != null;
	}

	public static void main(String[] args) {
		List<NestedInteger> nestedList = new ArrayList<>();
		nestedList.add(new NestedIntegerImpl(Arrays.asList(new NestedIntegerImpl(1), new NestedIntegerImpl(1))));
		nestedList.add(new NestedIntegerImpl(2));
		nestedList.add(new NestedIntegerImpl(Arrays.asList(new NestedIntegerImpl(1), new NestedIntegerImpl(1))));
		FlattenNestedListIterator i = new FlattenNestedListIterator(nestedList);
		System.out.println("Input list : " + nestedList);
		System.out.print("Iterated list : ");
		while (i.hasNext()) {
			System.out.print(i.next() + " ");
		}

		System.out.println("\n");

		nestedList = new ArrayList<>();
		nestedList.add(new NestedIntegerImpl(1));
		nestedList.add(new NestedIntegerImpl(Arrays.asList(new NestedIntegerImpl(4),
				new NestedIntegerImpl(Arrays.asList(new NestedIntegerImpl(6))))));
		i = new FlattenNestedListIterator(nestedList);
		System.out.println("Input list : " + nestedList);
		System.out.print("Iterated list : ");
		while (i.hasNext()) {
			System.out.print(i.next() + " ");
		}
	}
}