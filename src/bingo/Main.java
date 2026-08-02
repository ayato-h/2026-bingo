package bingo;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Menu.showTitle();
		while (true) {
			Menu.showMainMenu();
			int menu = Input.nextInt(scanner, 1, 3);
			switch (menu) {
			case 1:
				Game.showGameMenu(scanner);
				break;
			case 2:
				Menu.showHowToPlay();
				System.out.print("\n戻る(ENTER)");
				scanner.nextLine();
				break;
			case 3:
				Menu.exit();
				scanner.close();
				return;
			}

		}
	}
}