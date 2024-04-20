package threading.concurrentFile.uploadClass;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import threading.concurrentFile.modules.Address;

public class AddressUpload implements Runnable {
	public static List<Address> addList = new LinkedList<Address>();

	private final File file;

	public AddressUpload(File file) {
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
				String[] addArr = line.split(",");
				Address add = new Address();
				add.setId(Integer.parseInt(addArr[0]));
				add.setPin_code(Integer.parseInt(addArr[1]));
				add.setCity(addArr[2]);
				add.setStudent_id(Integer.parseInt(addArr[3]));
				addList.add(add);
			}

//		addList.stream().forEach(System.out::println);
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
