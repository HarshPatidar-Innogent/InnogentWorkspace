package day2Part1.methods;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import day2Part1.module.Address;
import day2Part1.module.Classes;
import day2Part1.module.Student;

public class Assignment2_1 {
	public static List<Student> studentList = new LinkedList<Student>();
	public static List<Classes> classList = new LinkedList<Classes>();
	public static List<Address> addList = new LinkedList<Address>();

	public static void uploadStudent(File file) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = "";

		// skipping the first line
		line = br.readLine();

		while ((line = br.readLine()) != null) {
			String[] studentArr = line.split(",");
			Student student1 = new Student();
			student1.setId(Integer.parseInt(studentArr[0]));
			student1.setName(studentArr[1]);
			student1.setClassId(Integer.parseInt(studentArr[2]));
			student1.setMarks(Integer.parseInt(studentArr[3]));
			student1.setGender(studentArr[4].toCharArray()[0]);
			student1.setAge(Integer.parseInt(studentArr[5]));
			studentList.add(student1);
		}

//		studentList.stream().forEach(System.out::println);

		br.close();
	}

	public static void uploadClass(File file) throws IOException {
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
	}

	public static void uploadAddress(File file) throws IOException {
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
	}

	/*
	 * public static String deleteStudent(Integer student_id) { int originalSize =
	 * studentList.size();
	 * 
	 * studentList = studentList.stream().filter(s -> s.getId() !=
	 * student_id).collect(Collectors.toList()); addList = addList.stream().filter(s
	 * -> s.getStudent_id() != student_id).collect(Collectors.toList());
	 * 
	 * int newSize = studentList.size();
	 * 
	 * if (newSize != originalSize) { return "Student Deleted"; } else return
	 * "Student Does Not Exist"; }
	 */

	public static void main(String[] args) throws IOException {
//		upload the csv data files
		uploadStudent(new File("C:\\Users\\Harsh Patidar\\Desktop\\Student.csv"));
		uploadClass(new File("C:\\Users\\Harsh Patidar\\Desktop\\Class.csv"));
		uploadAddress(new File("C:\\Users\\Harsh Patidar\\Desktop\\Address.csv"));

//		GetStudent.getByGender('F', 4, 9).forEach(System.out::println);

//		1.Find all students of pincode X(ex X = 482002). I can pass different filters like gender, age, class
		GetStudent.getByPinCode(482002, Gender.F, null, 3).forEach(System.out::println);
//		Filters.filterByPincode(studentList, 482002).forEach(System.out::println);

//		2.Find all students of city ex X = Indore. I can pass different filters like gender, age, class
//		GetStudent.getByCity("indore", Gender.F, 45, 1).forEach(System.out::println);
//		Filters.filterByCity(studentList, "indore").forEach(System.out::println);

//		3.marks < 50 failed else passed
//		Give ranks to highest mark achievers.
//		Highest marks - First
//		Third Highest marks - third
//		Rest of all pass / fail
//		List<Student> studRank = Ranking.ranking(studentList);
//		studRank.forEach(System.out::println);

//		4.Get the passed students. I can pass different filters like gender, age, class, city, pincode
//		List<Student> passedStudent = PassedStudent.getPassStudent(studentList, 'F', 35, 1, "indore", 452002);
//		List<Student> passedStudent = PassedStudent.getPassStudent(studentList);
//		passedStudent.forEach(System.out::println);

//		5.Get the failed students. I can pass different filters like gender, age, class, city, pincode
//		List<Student> failedStudent = FailedStudent.getFailStudent(studentList, 'F', 35, 3, "mumbai", 482002);
//		List<Student> failedStudent = FailedStudent.getFailStudent(studentList);
//		failedStudent.forEach(System.out::println);

//		6.Find all student of class X (ex X = A).  I can pass different filters like gender, age, class, city, pincode
//		List<Student> classStudent = ClassStudent.getStudentByClass(studentList, 'A', 'F', 35, "indore", 452002);
//		classStudent.forEach(System.out::println);

//		7.It should fail if student record is having age > 20.
//		List<Student> failedStudentByAge = Ranking.failStudentByAge(20);
//		studentList.forEach(System.out::println);

//		8.I should be able to delete student. After that it should delete the respective obj from Address & Student.
//		System.out.println(deleteStudent(1));
//		studentList.forEach(System.out::println);
//		addList.forEach(System.out::println);

//		9.I should be able to delete student. After that it should delete the respective obj from Address & Student.
//		DeleteStudent.deleteStudent(1);

//		10	If there is no student remaining in that class. Class should also be deleted.
//		System.out.println(deleteClass());
//		classList.forEach(System.out::println);

//		11	I should be able to read paginated students.
//		like : read female students first 1-9
//		like : read female students first 7-8 order by name	
//		like : read female students first 1-5 order by marks
//		like : read female students first 9-50 order by marks
//		SortedAndPaginated.getSortedStudentByOrder(studentList, 'F', 1, 4, "name", true).forEach(System.out::println);;

//		List<Student> studList, Character gender, int start, int end, String sortBy, boolean ReverseOrder

	}

}
