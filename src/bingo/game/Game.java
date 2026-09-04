package bingo.game;

import java.util.Scanner;

import bingo.model.Player;
import bingo.service.BingoService;
import bingo.service.ScoreService;
import bingo.util.Color;
import bingo.util.Input;
import bingo.util.Menu;

public class Game {
	public static void showGameMenu(Scanner scanner, Player player) {
		while (true) {
			Menu.showGameMenu();
			int select = Input.nextInt(scanner, 0, 3);
			switch (select) {
			case 1:
				startGame(scanner, player, 3);
				break;
			case 2:
				startGame(scanner, player, 5);
				break;
			case 3:
				startGame(scanner, player, 7);
				break;
			case 0:
				return;
			}
		}
	}

	public static void startGame(Scanner scanner, Player player, int size) {
		if (player.getMode().equals("NORMAL")) {
			startNormal(scanner, player, size);
		} else if (player.getMode().equals("ENDLESS")) {
			startEndless(scanner, player, size);
		} else if (player.getMode().equals("CHALLENGE")) {
			startChallenge(scanner, player, size);
		}
	}

	public static void startNormal(Scanner scanner, Player player, int size) {
		int[][] card = BingoCard.createCard(size);
		NumberGenerator generator = new NumberGenerator();
		int turn = 0;
		while (true) {
			int number = generator.nextNumber();
			BingoCard.openNumber(card, number);
			turn++;
			System.out.println();
			BingoCard.showCard(card, turn, number);

			if (BingoService.isBingo(card)) {
				boolean isBest = ScoreService.updateBestTurn(player, size, turn);
				System.out.print("\n" + Color.ORANGE + "[ENTER]" + Color.RESET + " 結果を見る");
				scanner.nextLine();
				Menu.printTitle("GAME CLEAR");
				System.out.println("\n[ " + Color.ORANGE + "RESULT" + Color.RESET + " ]");
				Menu.printLine();
				System.out.println("\nPLAYER		: " + Color.ORANGE + player.getName() + Color.RESET);
				System.out.println("SCORE		: " + Color.ORANGE + 0 + Color.RESET);
				if (isBest) {
					System.out.println("BEST TURN	: " + Color.ORANGE + turn + Color.RESET + " (" + Color.ORANGE
							+ " NEW " + Color.RESET + ")");
				} else {
					switch (size) {
					case 3:
						System.out.println("BEST TURN	: " + Color.ORANGE + player.getBestTurn3x3() + Color.RESET);
						break;
					case 5:
						System.out.println("BEST TURN	: " + Color.ORANGE + player.getBestTurn5x5() + Color.RESET);
						break;
					case 7:
						System.out.println("BEST TURN	: " + Color.ORANGE + player.getBestTurn7x7() + Color.RESET);
						break;
					}
				}
				System.out.println("TURN		: " + Color.ORANGE + turn + Color.RESET + "\n");
				Menu.printLine();
				System.out.print(Color.ORANGE + "[ENTER]" + Color.RESET + " 終了");
				scanner.nextLine();
				System.out.println();
				break;
			}
			System.out.print("\n" + Color.ORANGE + "[ENTER]" + Color.RESET + " 次へ");
			scanner.nextLine();
		}
	}

	public static void startEndless(Scanner scanner, Player player, int size) {

	}

	public static void startChallenge(Scanner scanner, Player player, int size) {

	}
}
