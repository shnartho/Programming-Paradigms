package ex11;

public class Ex11_3 {

	public static int balance = 0;

	public static void main(String[] args) throws InterruptedException {

		Thread thread0 = new Thread(changeLoop(1));
		Thread thread1 = new Thread(changeLoop(-1));

		thread0.start();
		thread1.start();

		while (thread0.isAlive() || thread1.isAlive()) {
			Thread.sleep(10);
		}

		System.out.println("Finished, final balance: " + balance);

	}

	// Here we added the 'synchronized' keyword
	public static synchronized void change(int amount) {
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
