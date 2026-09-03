package bingo.util;

import java.util.Scanner;

import bingo.model.Player;

public class Menu {
	public static void showTitle() {
		System.out.print(Color.YELLOW);
		printCenter("\n██████╗ ██╗███╗   ██╗ ██████╗  ██████╗");
		printCenter("██╔══██╗██║████╗  ██║██╔════╝ ██╔═══██╗");
		printCenter("██████╔╝██║██╔██╗ ██║██║  ███╗██║   ██║");
		printCenter("██╔══██╗██║██║╚██╗██║██║   ██║██║   ██║");
		printCenter("██████╔╝██║██║ ╚████║╚██████╔╝╚██████╔╝");
		System.out.println("╚═════╝ ╚═╝╚═╝  ╚═══╝ ╚═════╝  ╚═════╝");
		//		System.out.println("\n██████╗ ██╗███╗   ██╗ ██████╗  ██████╗");
		//		System.out.println("██╔══██╗██║████╗  ██║██╔════╝ ██╔═══██╗");
		//		System.out.println("██████╔╝██║██╔██╗ ██║██║  ███╗██║   ██║");
		//		System.out.println("██╔══██╗██║██║╚██╗██║██║   ██║██║   ██║");
		//		System.out.println("██████╔╝██║██║ ╚████║╚██████╔╝╚██████╔╝");
		//		System.out.println("╚═════╝ ╚═╝╚═╝  ╚═══╝ ╚═════╝  ╚═════╝");
		System.out.print(Color.RESET);
		printSubTitle("- Console Bingo Game 2026 -\n");
	}

	public static void showMainMenu(Player player) {
		printTitle("MAIN MENU");
		System.out.println(Color.ORANGE + "1." + Color.RESET + " ゲーム開始");
		System.out.println(Color.ORANGE + "2." + Color.RESET + " 設定");
		System.out.println(Color.ORANGE + "3." + Color.RESET + " 遊び方");
		printLine();
		System.out.println(Color.ORANGE + "0." + Color.RESET + " 終了");
		System.out.print("\n▶ ");
	}

	public static void showSettings(Player player) {
		printTitle("SETTINGS");
		System.out.println(
				Color.ORANGE + "1." + Color.RESET + " 名前		: " + Color.ORANGE + player.getName() + Color.RESET);
		System.out.println(
				Color.ORANGE + "2." + Color.RESET + " モード		: " + Color.ORANGE + player.getMode() + Color.RESET);
		System.out.println(Color.ORANGE + "3." + Color.RESET + " 色		: ");
		printLine();
		System.out.println(Color.ORANGE + "0." + Color.RESET + " 戻る");
		System.out.print("\n▶ ");
	}

	public static void showMode(Player player, Scanner scanner) {
		printTitle("MODE");
		System.out.println(Color.ORANGE + "1." + Color.RESET + " NORMAL");
		System.out.println(Color.ORANGE + "2." + Color.RESET + " ENDLESS");
		System.out.println(Color.ORANGE + "3." + Color.RESET + " CHALLENGE");
		printLine();
		System.out.println(Color.ORANGE + "0." + Color.RESET + " 戻る");
		System.out.print("\n▶ ");
		int mode = Input.nextInt(scanner, 0, 3);
		switch (mode) {
		case 1: {
			player.setMode("NORMAL");
			break;
		}
		case 2: {
			player.setMode("ENDLESS");
			break;
		}
		case 3: {
			player.setMode("CHALLENGE");
			break;
		}
		case 0: {
			break;
		}
		}
	}

	public static void showHowToPlay() {
		printTitle("HOW TO PLAY");
		System.out.println(Color.ORANGE + "①" + Color.RESET + " ビンゴカードが配られます。");
		System.out.println(Color.ORANGE + "②" + Color.RESET + " 中央のマスはFREEです。");
		System.out.println(Color.ORANGE + "③" + Color.RESET + " 抽選された数字があればマスが開きます。");
		System.out.println(Color.ORANGE + "④" + Color.RESET + " 縦・横・斜めの1列が揃うとBINGOです。");
		printLine();
	}

	public static void showGameMenu() {
		printTitle("GAME START");
		System.out.println(Color.ORANGE + "1." + Color.RESET + " 5 × 5");
		System.out.println(Color.ORANGE + "2." + Color.RESET + " 3 × 3");
		System.out.println(Color.ORANGE + "3." + Color.RESET + " 7 × 7");
		printLine();
		System.out.println(Color.ORANGE + "0." + Color.RESET + " 戻る");
		System.out.print("\n▶ ");
	}

	public static void exit() {
		showTitle();
		printTitle("GAME CLOSED");
		printCenter("- Thank you for playing -");
	}

	public static void printLine() {
		System.out.println("----------------------------------------");
	}

	public static void printTitle(String title) {
		final int width = 40;
		System.out.println("=".repeat(width));
		int padding = (width - title.length()) / 2;
		if (padding < 0)
			padding = 0;
		System.out.println(" ".repeat(padding) + Color.CYAN + title + Color.RESET);
		System.out.println("=".repeat(width));

	}

	public static void printSubTitle(String text) {
		final int width = 40;
		int padding = (width - text.length()) / 2;
		if (padding < 0) {
			padding = 0;
		}
		System.out.println(" ".repeat(padding) + Color.CYAN + text + Color.RESET);
	}

	public static void printCenter(String text) {
		final int width = 40;
		int padding = (width - text.length()) / 2;
		if (padding < 0) {
			padding = 0;
		}
		System.out.println(" ".repeat(padding) + text);
	}
}
