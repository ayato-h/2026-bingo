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
				// ゲーム開始
				break;
			case 2:
				Menu.showHowToPlay();
				scanner.nextLine();
				System.out.print("\nENTER. 戻る");
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