package com.sebskyo.encryptinator.algorithms;

public class Utility {
	public static int gcd(int i, int j) {
		return j == 0 ? i : gcd(j, i % j);
	}

	public static int totient(int i, int j) {
		return (i - 1) * (j - 1);
	}

	private static int[][] inverse(int[][] table, int totient) { // [row][column]
		if (table[1][0] == 1)
			return table;

		int[][] nextTable = new int[2][2];
		int factor = table[0][0] / table[1][0];
		int[] products = new int[2];

		for (int c = 0; c < 2; c++) {
			nextTable[0][c] = table[1][c];
			products[c] = factor * table[1][c];
			nextTable[1][c] = table[0][c] - products[c];
			while (nextTable[1][c] < 0)
				nextTable[1][c] += totient;
		}

		return inverse(nextTable, totient);
	}

	public static int inverse(int exponent, int totient) {
		return inverse(new int[][]{{totient, totient}, {exponent, 1}}, totient)[1][1];
	}
}
