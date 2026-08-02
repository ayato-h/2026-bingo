package bingo;

public class BingoCard {
	public static void showCard(int size) {
		Menu.printTitle(size + " × " + size + " BINGO CARD");
		printCard(createHeader(size), size);
		printCard(createBorder(size), size);
		for (int row = 0; row < size; row++) {
			StringBuilder line = new StringBuilder();
			line.append(String.format("%2d |", row + 1));
			for (int col = 0; col < size; col++) {
				if (size % 2 == 1 && row == size / 2 && col == size / 2) {
					line.append("FREE|");
				} else {
					line.append(" 00 |");
				}
			}
			printCard(line.toString(), size);
			printCard(createBorder(size), size);
		}
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
}