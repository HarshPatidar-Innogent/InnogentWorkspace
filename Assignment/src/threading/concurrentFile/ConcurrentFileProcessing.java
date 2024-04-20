package threading.concurrentFile;

import java.io.File;

import threading.concurrentFile.uploadClass.AddressUpload;
import threading.concurrentFile.uploadClass.ClassUpload;
import threading.concurrentFile.uploadClass.StudentUpload;

public class ConcurrentFileProcessing {
	public static void main(String[] args) {
		Object[] files = {
				new StudentUpload(new File("C:\\Users\\Harsh Patidar\\Desktop\\Student.csv")),
				new ClassUpload(new File("C:\\Users\\Harsh Patidar\\Desktop\\Class.csv")),
				new AddressUpload(new File("C:\\Users\\Harsh Patidar\\Desktop\\Address.csv"))
		};
		
		long startTime = System.currentTimeMillis();
		for(Object file:files) {
			Thread workerThread = new Thread(new FileProcessing(file));
			workerThread.start();
//			System.out.println(workerThread.getName());
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);
	}
}
