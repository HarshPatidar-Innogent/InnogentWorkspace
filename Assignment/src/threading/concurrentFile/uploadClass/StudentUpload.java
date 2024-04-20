package threading.concurrentFile.uploadClass;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import threading.concurrentFile.modules.Student;


public class StudentUpload implements Runnable {

	public static List<Student> studentList = new LinkedList<Student>();

	private final File file;

	public StudentUpload(File file) {
		super();
		this.file = file;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = "";

			// skipping the first line
			line = br.readLine();

			while ((line = br.readLine()) != null) {
				String[] studentArr = line.split(",");
				Student student1 = new Student();
				student1.setId(Integer.parseInt(studentArr[0]));
				student1.setName(studentArr[1]);
				student1.setClass_id(Integer.parseInt(studentArr[2]));
				student1.setMarks(Integer.parseInt(studentArr[3]));
				student1.setGender(studentArr[4].toCharArray()[0]);
				student1.setAge(Integer.parseInt(studentArr[5]));
				studentList.add(student1);
				br.close();

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		studentList.stream().forEach(System.out::println);

	}

}
