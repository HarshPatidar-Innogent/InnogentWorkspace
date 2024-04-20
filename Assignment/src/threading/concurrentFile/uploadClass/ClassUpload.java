package threading.concurrentFile.uploadClass;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import threading.concurrentFile.modules.Classes;

public class ClassUpload implements Runnable {

	public static List<Classes> classList = new LinkedList<Classes>();

	private final File file;

	public ClassUpload(File file) {
		super();
		this.file = file;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));

			// skipping the first line
			String line = br.readLine();

			while ((line = br.readLine()) != null) {
				String[] classArr = line.split(",");
				Classes classes = new Classes();
				classes.setId(Integer.parseInt(classArr[0]));
				classes.setName(classArr[1].toCharArray()[0]);
				classList.add(classes);
			}
//		classList.stream().forEach(System.out::println);
			br.close();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
