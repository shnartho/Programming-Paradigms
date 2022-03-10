package ex14;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

import java.math.BigInteger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Ex14_3 {

	// Put to 20 to go according to task specification
	public static final int outputDelay = 1;
	// Max factorial to generate
	public static final int maximumNumber = 30;

	public static void main(String[] args) throws InterruptedException {

		AtomicInteger number = new AtomicInteger(1);
		// Super fast and efficient factorial calculator
		// Or just uncomment the other print method down below to use different method
		FactorialCache factorialCache = new FactorialCache();

		Disposable ticker = Observable.interval(outputDelay, TimeUnit.SECONDS).timeInterval().subscribe((accSum) -> {
			System.out.println("Number: " + number);
			//System.out.println("Factorial: " + atomicFactorial(number));
			System.out.println("Factorial: " + factorialCache.getFactorial(number));
			number.addAndGet(1);
		});

		while (!ticker.isDisposed()) {
			// Exit condition
			Thread.sleep(100);
			if (number.get() == maximumNumber + 1) {
				ticker.dispose();
			}
		}

	}

	// Simple factorial algorithm
	public static BigInteger simpleFactorial(AtomicInteger n) {
		BigInteger x = BigInteger.ONE;
		for (int i = n.get(); i > 0; i--) {
			x = x.multiply(BigInteger.valueOf(i));
		}
		return x;
	}

}
