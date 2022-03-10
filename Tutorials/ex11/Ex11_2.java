package ex11;

public class Ex11_2 {

	public static int balance = 0;

	public static void main(String[] args) throws InterruptedException {

		// We create two threads to work with, And assign them with the changeLoop() method
		// Which will return a runnable that keeps calling change() thousands of times
		Thread thread0 = new Thread(changeLoop(1));
		Thread thread1 = new Thread(changeLoop(-1));

		// Start them both
		thread0.start();
		thread1.start();

		// Keep the main thread alive, waiting for the two threads to finish their work
		// Checking only every 10 milliseconds, to keep things smooth
		while (thread0.isAlive() || thread1.isAlive()) {
			Thread.sleep(10);
		}

		// When done see the result
		System.out.println("Finished, final balance: " + balance);

		// The result should normally be 0 if we were not using threads.
		// But since there are 2 threads accessing and changing the same primitive variable-
		// It will eventually cause trouble. Because for example if Thread-0 reads the balance
		// at 50, takes that value and adds +1 then returns 51, Thread-1 could have done it at
		// right after, also reading 50, before Thread-0 has wrote it's result, and returning 49.
		// And thus we get an offset that shouldn't have happened.

	}

	public static void change(int amount) {
		balance += amount;
	}

	public static Runnable changeLoop(int amount) {
		return () -> {
			int i;
			for (i = 0; i < 10000; i++) {
				change(amount);
			}
			System.out.println("[" + Thread.currentThread().getName() + "] Finished " + i + " iterations");
		};
	}

}
