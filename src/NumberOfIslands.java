/*
Problem Statement -
https://leetcode.com/problems/number-of-islands/
*/

public class NumberOfIslands {

	public int numIslands(char[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1') {
					dfs(grid, i, j);
					count++;
				}
			}
		}
		return count;
	}

	private void dfs(char[][] grid, int i, int j) {
		if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == '1') {
			grid[i][j] = 0;
			dfs(grid, i + 1, j);
			dfs(grid, i - 1, j);
			dfs(grid, i, j + 1);
			dfs(grid, i, j - 1);
		}
	}

	public static void main(String[] args) {
		final NumberOfIslands n = new NumberOfIslands();

		char[][] grid1 = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '0', '0', '0' } };
		System.out.println("Number of islands : " + n.numIslands(grid1));
		System.out.println();

		char[][] grid2 = { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
				{ '0', '0', '0', '1', '1' } };
		System.out.println("Number of islands : " + n.numIslands(grid2));
		System.out.println();

		char[][] grid3 = { { '0', '0', '1', '0', '0' }, { '1', '0', '1', '0', '1' }, { '1', '0', '1', '0', '1' },
				{ '0', '1', '1', '1', '0' } };
		System.out.println("Number of islands : " + n.numIslands(grid3));

		System.out.println();

		char[][] grid4 = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '0', '0', '0' } };
		System.out.println("Number of islands : " + n.numIslands(grid4));
	}
}
