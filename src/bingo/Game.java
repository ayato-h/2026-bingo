package bingo;

import java.util.Scanner;

public class Game {
	private static Player player;

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
		Menu.printTitle("5 × 5 BINGO");
		setUpPlayer(scanner);
		int[][] card = BingoCard.createCard(5);
		NumberGenerator generator = new NumberGenerator();

		while (true) {
			int number = generator.nextNumber();
			System.out.println("今回の数字 ▶ " + number);
			BingoCard.openNumber(card, number);
			System.out.println();
			BingoCard.showCard(card);
			System.out.print("\n[ENTER] 次の数字");
			scanner.nextLine();
		}

	}

	public static void start3x3(Scanner scanner) {
		Menu.printTitle("3 × 3 BINGO");
		setUpPlayer(scanner);
		int[][] card = BingoCard.createCard(3);
		BingoCard.showCard(card);
	}

	public static void start7x7(Scanner scanner) {
		Menu.printTitle("7 × 7 BINGO");
		setUpPlayer(scanner);
		int[][] card = BingoCard.createCard(7);
		BingoCard.showCard(card);
	}

	private static void setUpPlayer(Scanner scanner) {
		if (player == null) {
			System.out.print("プレイヤー名 ▶ ");
			String name = scanner.nextLine();
			player = new Player(name);
		}
		System.out.println("\nようこそ、" + player.getName() + "さん");
	}
}
