package bingo;

import java.util.Scanner;

public class Game {
	public static void showGameMenu(Scanner scanner) {
		while (true) {
			Menu.showGameMenu();
			int select = Input.nextInt(scanner, 0, 1);
			switch (select) {
			case 1:
				start5x5(scanner);
				break;
			case 0:
				return;
			}
		}
	}

	public static void start5x5(Scanner scanner) {
		System.out.println("5×5ゲーム開始");
	}
}
