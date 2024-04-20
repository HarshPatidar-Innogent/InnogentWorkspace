package threading.Executor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceTest {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(10);

		Runnable runnableTask = () -> {
			try {
				TimeUnit.MICROSECONDS.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};

		List<Callable<String>> callableTasks = new ArrayList<Callable<String>>();
		callableTasks.add(new Callable<String>() {

			@Override
			public String call() throws Exception {
				// TODO Auto-generated method stub
				return "Task 1";
			}
		});
		callableTasks.add(new Callable<String>() {

			@Override
			public String call() throws Exception {
				// TODO Auto-generated method stub
				return "Task 2";
			}
		});
		callableTasks.add(new Callable<String>() {

			@Override
			public String call() throws Exception {
				// TODO Auto-generated method stub
				return "Task 3";
			}
		});
		callableTasks.add(new Callable<String>() {

			@Override
			public String call() throws Exception {
				// TODO Auto-generated method stub
				return "Task 4";
			}
		});

		executor.execute(runnableTask);

		String result = executor.invokeAny(callableTasks);
//		System.out.println(result);
		
		List<Future<String>> futures = executor.invokeAll(callableTasks);
		futures.stream().forEach(f->{
			try {
				System.out.println(f.get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

//		String result = executor.invokeAny(callableTasks);
//		System.out.println(result);

	}
}
