package bingo;

public class Menu {
	public static void showTitle() {
		System.out.println("\n██████╗ ██╗███╗   ██╗ ██████╗  ██████╗");
		System.out.println("██╔══██╗██║████╗  ██║██╔════╝ ██╔═══██╗");
		System.out.println("██████╔╝██║██╔██╗ ██║██║  ███╗██║   ██║");
		System.out.println("██╔══██╗██║██║╚██╗██║██║   ██║██║   ██║");
		System.out.println("██████╔╝██║██║ ╚████║╚██████╔╝╚██████╔╝");
		System.out.println("╚═════╝ ╚═╝╚═╝  ╚═══╝ ╚═════╝  ╚═════╝");
		printCenter("-Console Bingo Game 2026-\n");
		printTitle("MAIN MENU");
		System.out.println("1. ゲーム開始");
		System.out.println("2. 遊び方");
		System.out.println("3. 終了");
		System.out.print("\n選択してください ▶ ");
	}

	public static void showHowToPlay() {
		printTitle("HOW TO PLAY");
		System.out.println("\n・5×5のビンゴカードが配られます。");
		System.out.println("・中央はFREEマスです。");
		System.out.println("・抽選された数字と同じ数字があれば開きます。");
		System.out.println("・縦・横・斜めのいずれか1列が揃うとBINGOです。");
		System.out.println("\n-----------------------------------------");
	}

	public static void exit() {
		printTitle("GAME CLOSED");
	}

	public static void printTitle(String title) {
		final int width = 40;
		System.out.println("=".repeat(width));
		int padding = (width - title.length()) / 2;
		if (padding < 0)
			padding = 0;
		System.out.println(" ".repeat(padding) + title);
		System.out.println("=".repeat(width));
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
