package bingo.game;

import java.util.Scanner;

import bingo.util.Color;
import bingo.util.Input;
import bingo.util.Menu;

public class Game {
	public static void showGameMenu(Scanner scanner) {
		while (true) {
			Menu.showGameMenu();
			int select = Input.nextInt(scanner, 0, 3);
			switch (select) {
			case 1:
				start5x5(scanner);
				break;
			case 2:
				start3x3(scanner);
				break;
			case 3:
				start7x7(scanner);
				break;
			case 0:
				return;
			}
		}
	}

	public static void start5x5(Scanner scanner) {
		int[][] card = BingoCard.createCard(5);
		NumberGenerator generator = new NumberGenerator();

		while (true) {
			int number = generator.nextNumber();
			BingoCard.openNumber(card, number);
			System.out.println();
			BingoCard.showCard(card);
			String drawNumberText = "─── Draw " + number + " ───";
			Menu.printCenter(drawNumberText);
			System.out.print("\n" + Color.ORANGE + "[ENTER]" + Color.RESET + " 次の数字");
			scanner.nextLine();
		}

	}

	public static void start3x3(Scanner scanner) {
		Menu.printTitle("3 × 3 BINGO");
		int[][] card = BingoCard.createCard(3);
		BingoCard.showCard(card);
	}

	public static void start7x7(Scanner scanner) {
		Menu.printTitle("7 × 7 BINGO");
		int[][] card = BingoCard.createCard(7);
		BingoCard.showCard(card);
	}
}
