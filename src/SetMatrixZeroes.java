/*
Problem Statement -
https://leetcode.com/problems/set-matrix-zeroes/
*/

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {

	public void setZeroes(int[][] matrix) {
		final Set<Integer> rowZero = new HashSet<>();
		final Set<Integer> colZero = new HashSet<>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					rowZero.add(i);
					colZero.add(j);
				}
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (rowZero.contains(i) || colZero.contains(j)) {
					matrix[i][j] = 0;
				}
			}
		}
	}

	private void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		final SetMatrixZeroes s = new SetMatrixZeroes();
		int[][] matrix1 = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		System.out.println("Original matrix");
		s.printMatrix(matrix1);
		s.setZeroes(matrix1);
		System.out.println("After updating zeroes");
		s.printMatrix(matrix1);

		int[][] matrix2 = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
		System.out.println("Original matrix");
		s.printMatrix(matrix2);
		s.setZeroes(matrix2);
		System.out.println("After updating zeroes");
		s.printMatrix(matrix2);

		int[][] matrix3 = { { 1, 2, 3, 4 }, { 5, 0, 7, 8 }, { 0, 10, 11, 12 }, { 13, 14, 15, 0 } };
		System.out.println("Original matrix");
		s.printMatrix(matrix3);
		s.setZeroes(matrix3);
		System.out.println("After updating zeroes");
		s.printMatrix(matrix3);
	}
}
