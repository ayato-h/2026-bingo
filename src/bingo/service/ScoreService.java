package bingo.service;

import bingo.model.Player;

public class ScoreService {
	public static boolean updateBestTurn(Player player, int size, int turn) {

		switch (size) {
		case 3:
			if (player.getBestTurn3x3() == 0 || turn < player.getBestTurn3x3()) {
				player.setBestTurn3x3(turn);
				return true;
			}
			break;
		case 5:
			if (player.getBestTurn5x5() == 0 || turn < player.getBestTurn5x5()) {
				player.setBestTurn5x5(turn);
				return true;
			}
			break;
		case 7:
			if (player.getBestTurn7x7() == 0 || turn < player.getBestTurn7x7()) {
				player.setBestTurn7x7(turn);
				return true;
			}
			break;
		}
		return false;
	}
}
