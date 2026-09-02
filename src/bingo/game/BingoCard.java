package bingo.game;

import java.util.ArrayList;
import java.util.Collections;

import bingo.util.Color;
import bingo.util.Menu;

public class BingoCard {
	public static int[][] createCard(int size) {
		ArrayList<Integer> numbers = new ArrayList<>();

		for (int i = 1; i <= 99; i++) {
			numbers.add(i);
		}
		Collections.shuffle(numbers);

		int[][] card = new int[size][size];
		int index = 0;

		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				if (size % 2 == 1
						&& row == size / 2
						&& col == size / 2) {

					card[row][col] = 0;

				} else {
					card[row][col] = numbers.get(index++);
				}
			}
		}
		return card;
	}

	public static void showCard(int[][] card, int turn) {
		int size = card.length;

		Menu.printTitle(size + " × " + size + " BINGO CARD");
		String turnText = "─── TURN " + turn + " ───";
		Menu.printCenter(turnText);
		printCard(createHeader(size), size);
		printCard(createBorder(size), size);

		for (int row = 0; row < size; row++) {
			StringBuilder line = new StringBuilder();
			line.append(String.format("%2d |", row + 1));

			for (int col = 0; col < size; col++) {

				if (size % 2 == 1
						&& row == size / 2
						&& col == size / 2) {

					if (isBingoCell(card, row, col)) {
						line.append(Color.RED + "FREE" + Color.RESET + "|");

					} else if (isReachCell(card, row, col)) {
						line.append(Color.ORANGE + "FREE" + Color.RESET + "|");

					} else {
						line.append(Color.YELLOW + "FREE" + Color.RESET + "|");
					}

				} else if (card[row][col] == -1) {

					if (isBingoCell(card, row, col)) {
						line.append(" " + Color.RED + "//" + Color.RESET + " |");

					} else if (isReachCell(card, row, col)) {
						line.append(" " + Color.ORANGE + "//" + Color.RESET + " |");

					} else {
						line.append(" " + Color.YELLOW + "//" + Color.RESET + " |");
					}

				} else {
					line.append(String.format("%3d |", card[row][col]));
				}
			}

			printCard(line.toString(), size);
			printCard(createBorder(size), size);
		}
	}

	private static boolean isBingoCell(int[][] card, int row, int col) {
		int size = card.length;

		if (isBingoRow(card, row)) {
			return true;
		}

		if (isBingoColumn(card, col)) {
			return true;
		}

		if (row == col && isBingoDiagonalLeft(card)) {
			return true;
		}

		if (row + col == size - 1 && isBingoDiagonalRight(card)) {
			return true;
		}

		return false;
	}

	private static boolean isBingoRow(int[][] card, int row) {
		for (int col = 0; col < card.length; col++) {
			if (!isOpen(card, row, col)) {
				return false;
			}
		}

		return true;
	}

	private static boolean isBingoColumn(int[][] card, int col) {
		for (int row = 0; row < card.length; row++) {
			if (!isOpen(card, row, col)) {
				return false;
			}
		}

		return true;
	}

	private static boolean isBingoDiagonalLeft(int[][] card) {
		for (int i = 0; i < card.length; i++) {
			if (!isOpen(card, i, i)) {
				return false;
			}
		}

		return true;
	}

	private static boolean isBingoDiagonalRight(int[][] card) {
		for (int i = 0; i < card.length; i++) {
			if (!isOpen(card, i, card.length - 1 - i)) {
				return false;
			}
		}

		return true;
	}

	public static boolean isBingo(int[][] card) {
		int size = card.length;

		for (int row = 0; row < size; row++) {
			if (isBingoRow(card, row)) {
				return true;
			}
		}

		for (int col = 0; col < size; col++) {
			if (isBingoColumn(card, col)) {
				return true;
			}
		}

		if (isBingoDiagonalLeft(card)) {
			return true;
		}

		if (isBingoDiagonalRight(card)) {
			return true;
		}

		return false;
	}

	private static boolean isReachCell(int[][] card, int row, int col) {
		int size = card.length;

		if (isReachRow(card, row)) {
			return true;
		}

		if (isReachColumn(card, col)) {
			return true;
		}

		if (row == col && isReachDiagonalLeft(card)) {
			return true;
		}

		if (row + col == size - 1 && isReachDiagonalRight(card)) {
			return true;
		}

		return false;
	}

	private static boolean isReachRow(int[][] card, int row) {
		int openCount = 0;

		for (int col = 0; col < card.length; col++) {
			if (isOpen(card, row, col)) {
				openCount++;
			}
		}

		return openCount == card.length - 1;
	}

	private static boolean isReachColumn(int[][] card, int col) {
		int openCount = 0;

		for (int row = 0; row < card.length; row++) {
			if (isOpen(card, row, col)) {
				openCount++;
			}
		}

		return openCount == card.length - 1;
	}

	private static boolean isReachDiagonalLeft(int[][] card) {
		int openCount = 0;

		for (int i = 0; i < card.length; i++) {
			if (isOpen(card, i, i)) {
				openCount++;
			}
		}

		return openCount == card.length - 1;
	}

	private static boolean isReachDiagonalRight(int[][] card) {
		int openCount = 0;

		for (int i = 0; i < card.length; i++) {
			if (isOpen(card, i, card.length - 1 - i)) {
				openCount++;
			}
		}

		return openCount == card.length - 1;
	}

	private static boolean isOpen(int[][] card, int row, int col) {
		int size = card.length;

		if (size % 2 == 1
				&& row == size / 2
				&& col == size / 2) {
			return true;
		}

		return card[row][col] == -1;
	}

	private static String createHeader(int size) {
		StringBuilder sb = new StringBuilder();
		sb.append("   ");
		for (int i = 0; i < size; i++) {
			sb.append(String.format("  %c  ", 'A' + i));
		}
		return sb.toString();
	}

	private static String createBorder(int size) {
		StringBuilder sb = new StringBuilder();
		sb.append("   ");
		for (int i = 0; i < size; i++) {
			sb.append("+----");
		}
		sb.append("+");
		return sb.toString();
	}

	private static void printCard(String text, int size) {
		final int width = 40;
		int cardWidth = createBorder(size).length();
		int padding = Math.max(0, (width - cardWidth) / 2);

		System.out.println(" ".repeat(padding) + text);
	}

	public static void openNumber(int[][] card, int number) {

		for (int row = 0; row < card.length; row++) {
			for (int col = 0; col < card[row].length; col++) {
				if (card[row][col] == number) {
					card[row][col] = -1;
				}
			}
		}

	}
}