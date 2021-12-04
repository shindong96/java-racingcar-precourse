package racingcar;

import java.util.Vector;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	private static final int RANDOM_MIN_NUM = 0;
	private static final int RANDOM_MAX_NUM = 9;
	private static final int STANDARD_TO_GO = 4;

	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public void move() {
		goOrStay();
		printResult();
	}

	private void goOrStay() {
		int randomNum = Randoms.pickNumberInRange(RANDOM_MIN_NUM, RANDOM_MAX_NUM);

		if (randomNum >= STANDARD_TO_GO) {
			position++;
		}

	}

	private void printResult() {
		System.out.print(name + " : ");

		for (int i = 0; i < position; i++) {
			System.out.print("-");
		}

		System.out.println();
	}

	public void insertNameIfIAmWinner(int winningPosition, Vector<String> winnerNames) {

		if (this.position == winningPosition) {
			winnerNames.add(this.name);
		}

	}

	public int judgeWhoIsGoingAhead(int winnerPosition) {

		if (this.position > winnerPosition) {
			return this.position;
		}

		return winnerPosition;
	}
	// 추가 기능 구현
}
