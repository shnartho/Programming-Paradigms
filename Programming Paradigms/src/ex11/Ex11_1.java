package ex11;

public class Ex11_1 {

	public static void main(String[] args) {

		// Create a new runnable Object, which we will make use of
		Runnable task = () -> {
			String threadName = Thread.currentThread().getName();
			System.out.println("Hello " + threadName);
		};
		// Run the task once, In this context it will run on the main thread.
		task.run();

		// Creates a new thread, with the task put in as a parameter. Which makes the thread-
		// execute that task instantly upon starting.
		Thread thread = new Thread(task);
		thread.start();

		System.out.println("Done!");

		// Result upon running program should be like this:
		//
		// Hello main
		// Done!
		// Hello Thread-0
		//
		// Why? Because the first task is ran in the context of the main thread which is the only thread
		// created automatically upon starting any java program, After that we create a new thread and give
		// it a task as parameter, but why does it show after Done!? Because upon creating a new thread,
		// the given task is handled by the to-be-created new thread, and not the main thread which was already
		// running! So the main thread just calls to create another thread, without actually waiting for it
		// to start, and continues execution on it's own task which is to print out the word "Done!", and
		// only nanoseconds later a new thread is created and ran as we see by "Hello Thread-0".
		// Even though it's merely nano-seconds in time difference between these two threads, It shows how-
		// Critically important it is to properly manage workload between threads in a multithreaded environment.
		//

	}

}
