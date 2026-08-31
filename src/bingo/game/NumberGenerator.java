package bingo.game;

import java.util.ArrayList;
import java.util.Collections;

public class NumberGenerator {

	private ArrayList<Integer> numbers;

	public NumberGenerator() {
		numbers = new ArrayList<>();

		for (int i = 1; i <= 99; i++) {
			numbers.add(i);
		}

		Collections.shuffle(numbers);
	}

	public int nextNumber() {
		return numbers.remove(0);
	}
}