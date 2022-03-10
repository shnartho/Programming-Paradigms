package ex11;

import java.util.Arrays;

public class Ex11_4 {

	// Table of Philosophers
	public static boolean[] table = new boolean[5];
	// True = Eating
	// False = Waiting

	public static void main(String[] args) throws InterruptedException {

		// Fill table with non-eating Philosophers
		Arrays.fill(table, false);

		// Start Philosophers waiting cycle logic
		for (int i = 0; i < table.length; i++) {
			Thread thread = new Thread(cycle(i));
			thread.start();
		}

		// Feedback
		while (true) {
			System.out.print("Table: " + Arrays.toString(getTable()) + "\r");
			Thread.sleep(100);
		}

	}

	public static synchronized boolean[] getTable() {
		return table;
	}

	public static void setTable(int seatIndex) throws InterruptedException {
		// Edge case index 0 (first)
		if (seatIndex == 0) {
			// Make sure both sides are free
			if (!getTable()[4] && !getTable()[1]) {
				// Eat for 1200 milliseconds
				table[seatIndex] = true;
				Thread.sleep(1200);
				table[seatIndex] = false;
			}
		// Edge case index 4 (last)
		} else if (seatIndex == 4) {
			if (!getTable()[3] && !getTable()[0]) {
				table[seatIndex] = true;
				Thread.sleep(1200);
				table[seatIndex] = false;
			}
		// All other indexes
		} else if (!getTable()[seatIndex - 1] && !getTable()[seatIndex + 1]) {
			table[seatIndex] = true;
			Thread.sleep(1200);
			table[seatIndex] = false;
		}
	}

	public static Runnable cycle(int seatIndex) {
		return () -> {
			while (true) {
				//
				try {
					setTable(seatIndex);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// Check cycle put to sleep every 10 milliseconds, as not to choke the pc
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
	}

}
