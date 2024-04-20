package threading;

public class Task implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Executing task in thread: " + Thread.currentThread().getName());
	}

}
