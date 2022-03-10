package ex14;

import io.reactivex.Observable;

import java.util.concurrent.atomic.AtomicInteger;

public class Ex14_2 {

	public static void main(String[] args) {

		Observable<Integer> bankAccount1 = Observable.fromArray(800, 1200, 1600, 1800, 2400, 3600, 4200);
		Observable<Integer> bankAccount2 = Observable.fromArray(200, 600, 1000, 1400, 1500, 2000, 2500);
		AtomicInteger totalSum = new AtomicInteger(0);

		bankAccount1.zipWith(bankAccount2, Integer::sum)
			.subscribe((accSum) -> {
				totalSum.updateAndGet(x -> x + accSum);
				System.out.println("Sum as of this Iteration: " + totalSum);
		});

	}

}
