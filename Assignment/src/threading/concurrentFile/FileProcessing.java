package threading.concurrentFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileProcessing implements Runnable {
	private final File file;
	
	public FileProcessing(Object file) {
		this.file = (File)file;
	}

	List<String[]> listString = new ArrayList<String[]>();

	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = "";
			br.readLine();
			while ((line = br.readLine()) != null) {
				String[] arr = line.split(",");
				listString.add(arr);
			}
			listString.parallelStream().forEach(l->System.out.println(Arrays.toString(l)));
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
