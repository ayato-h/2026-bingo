package bingo;

public class Menu {
	public static void showTitle() {
		System.out.print(Color.YELLOW);
		System.out.println("\n██████╗ ██╗███╗   ██╗ ██████╗  ██████╗");
		System.out.println("██╔══██╗██║████╗  ██║██╔════╝ ██╔═══██╗");
		System.out.println("██████╔╝██║██╔██╗ ██║██║  ███╗██║   ██║");
		System.out.println("██╔══██╗██║██║╚██╗██║██║   ██║██║   ██║");
		System.out.println("██████╔╝██║██║ ╚████║╚██████╔╝╚██████╔╝");
		System.out.println("╚═════╝ ╚═╝╚═╝  ╚═══╝ ╚═════╝  ╚═════╝");
		System.out.print(Color.RESET);
		printSubTitle("- Console Bingo Game 2026 -\n");
	}

	public static void showMainMenu() {
		printTitle("MAIN MENU");
		System.out.println("1. ゲーム開始");
		System.out.println("2. 遊び方");
		System.out.println("3. 終了");
		System.out.print("\n▶ ");
	}

	public static void showHowToPlay() {
		printTitle("HOW TO PLAY");
		System.out.println("\n① ビンゴカードが配られます。");
		System.out.println("② 中央のマスはFREEです。");
		System.out.println("③ 抽選された数字があればマスが開きます。");
		System.out.println("④ 縦・横・斜めの1列が揃うとBINGOです。\n");
		printLine();
	}

	public static void showGameMenu() {
		printTitle("GAME START");
		System.out.println("1. 5 × 5");
		System.out.println("2. 3 × 3");
		System.out.println("3. 7 × 7");
		printLine();
		System.out.println("0. 戻る");
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
		printCenter(text, 60);
	}

	public static void printCenter(String text, int width) {
		int padding = Math.max(0, (width - text.length()) / 2);
		System.out.println(" ".repeat(padding) + text);
	}
}
