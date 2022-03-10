package ex14;

import io.reactivex.*;

import java.util.concurrent.atomic.AtomicInteger;

public class Ex14_1 {

	public static void main(String[] args) {

		Observable<Integer> bankAccount1 = Observable.fromArray(12, -52, 452, -23, -5, 450, -120);
		Observable<Integer> bankAccount2 = Observable.fromArray(34, -43, -23, 780, -76, 122, -92);
		AtomicInteger totalSum = new AtomicInteger(0);

		bankAccount1.zipWith(bankAccount2, Integer::sum)
			.subscribe((accSum) -> {
				totalSum.updateAndGet(x -> x + accSum);
				System.out.println("Sum as of this Iteration: " + totalSum);
		});

	}

}