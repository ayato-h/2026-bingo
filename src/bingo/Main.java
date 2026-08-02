package bingo;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			Menu.showTitle();
			int menu = scanner.nextInt();
			switch (menu) {
			case 1:
				while (true) {
					Menu.showGameMenu();
					int select = scanner.nextInt();
					switch (select) {
					case 1:
						break;
					case 0:
						break;
					default:
						System.out.println("入力が正しくありません。");
						continue;
					}
					break;
				}
				break;
			case 2:
				Menu.showHowToPlay();
				scanner.nextLine();
				System.out.print("\n戻る");
				scanner.nextLine();
				break;
			case 3:
				Menu.exit();
				scanner.close();
				return;
			default:
				System.out.println("入力が正しくありません。");
				System.out.println();
			}
		}
	}
}