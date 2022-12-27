/*
Problem Statement -
https://leetcode.com/problems/surrounded-regions/
*/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SurroundedRegions {

	final int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public void solve(char[][] board) {
		final int m = board.length;
		final int n = board[0].length;
		for (int i = 0; i < m; i++) {
			markBoard(board, m, n, i, 0);
			markBoard(board, m, n, i, n - 1);
		}
		for (int i = 0; i < n; i++) {
			markBoard(board, m, n, 0, i);
			markBoard(board, m, n, m - 1, i);
		}
		flipBoard(board, m, n);
	}

	private void markBoard(char[][] board, int m, int n, int i, int j) {
		final Queue<List<Integer>> exploreNeighbors = new LinkedList<>();
		if (board[i][j] == 'O') {
			board[i][j] = 'E';
			exploreNeighbors.add(Arrays.asList(i, j));

			while (!exploreNeighbors.isEmpty()) {
				final List<Integer> item = exploreNeighbors.poll();
				final int r = item.get(0);
				final int c = item.get(1);

				for (int[] dir : directions) {
					final int dr = r + dir[0];
					final int dc = c + dir[1];
					if (dr >= 0 && dc >= 0 && dr < m && dc < n && board[dr][dc] == 'O') {
						board[dr][dc] = 'E';
						exploreNeighbors.add(Arrays.asList(dr, dc));
					}
				}
			}
		}
	}

	private void flipBoard(char[][] board, int m, int n) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'E') {
					board[i][j] = 'O';
				} else if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}
			}
		}
	}

	private void printBoard(char[][] board) {
		for (char[] row : board) {
			for (char col : row) {
				System.out.print(col + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		final SurroundedRegions s = new SurroundedRegions();

		char[][] board1 = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'X' } };
		s.solve(board1);
		s.printBoard(board1);

		System.out.println();
		char[][] board2 = { { 'X' } };
		s.solve(board2);
		s.printBoard(board2);

		System.out.println();
		char[][] board3 = { { 'O', 'O', 'O' }, { 'O', 'O', 'O' }, { 'O', 'O', 'O' } };
		s.solve(board3);
		s.printBoard(board3);

		System.out.println();
		char[][] board4 = { { 'O', 'O', 'O', 'O' }, { 'O', 'O', 'O', 'O' }, { 'O', 'O', 'O', 'O' },
				{ 'O', 'O', 'O', 'O' } };
		s.solve(board4);
		s.printBoard(board4);

		System.out.println();
		char[][] board5 = { { 'O', 'X', 'X', 'O', 'X' }, { 'X', 'O', 'O', 'X', 'O' }, { 'X', 'O', 'X', 'O', 'X' },
				{ 'O', 'X', 'O', 'O', 'O' }, { 'X', 'X', 'O', 'X', 'O' } };
		s.solve(board5);
		s.printBoard(board5);

	}
}
