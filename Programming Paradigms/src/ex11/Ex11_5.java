package ex11;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Ex11_5 {

	public static int timer = 0;
	public static int timerLimit = 30;

	public static void main(String[] args) {

		// We will be using 'ScheduledExecutorService', Because as the Java docs explain this service was designed
		// To schedule tasks to run PERIODICALLY, which is the perfect solution for running a task per x amount
		// of elapsed time, which is just one second in our case.
		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

		// The task we will be running periodically
		Runnable timerTask = () -> {
			// Check if time limit has reached
			if (timer == timerLimit) {
				System.out.print("Time limit of (" + timerLimit + ") reached, Stopping task.");
				executorService.shutdown();
			// Otherwise just print elapsed time
			} else {
				System.out.print("Elapsed: " + timer + "\r");
				timer++;
			}
		};

		// 		* Starting the task
		//
		executorService.scheduleAtFixedRate(timerTask, 0, 1, TimeUnit.SECONDS);
		//
		//		* timerTask:	The task to run
		//		* 0:			Initial delayed for starting the task, if required
		//		* 1:			Delay between each task execution
		//		* TimeUnit:		The TimeUnit to use for the delay

	}
}
