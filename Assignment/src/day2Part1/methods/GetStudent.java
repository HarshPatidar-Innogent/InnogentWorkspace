package day2Part1.methods;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import day2Part1.module.Address;
import day2Part1.module.Classes;
import day2Part1.module.Student;
import day2Part1.validation.ValidateInput;

public class GetStudent {

	public static List<Student> studentList = Assignment2_1.studentList;
	public static List<Classes> classList = Assignment2_1.classList;
	public static List<Address> addList = Assignment2_1.addList;

	public static List<Student> getByGender(Gender gender, int s, int e) {
		return studentList.parallelStream().filter(stud -> stud.getGender() == gender).skip(s - 1).limit(e).toList();
	}

	static List<Integer> studPin = new LinkedList<Integer>();

	public static List<Student> getByPinCode(Integer pincode, Gender gender, Integer age, Integer classes) {
		if (pincode == null) {
			throw new IllegalArgumentException("Please Enter valid pincode");
		} else {
//			age = ValidateInput.validateAge(age);
//			gender = ValidateInput.validateGender(gender);
//			classes = ValidateInput.validateClass(classes);
			return studentList.parallelStream()
					.filter(student -> hasMatchingAddress(student, addList, pincode).contains(student.getId()))
					.filter(student -> ValidateInput.validateAge(age) ? student.getAge().equals(age) : false
					 ||  ValidateInput.validateGender(gender) ? student.getGender().equals(gender): false 
					 ||  ValidateInput.validateClass(classes) ? student.getClassId().equals(classes):false)
					.collect(Collectors.toList());

//			studPin = addList.stream().filter(a -> a.getPin_code() == pincode).map(Address::getStudent_id).toList();
//			studPin.forEach(System.out::println);
//			return studentList.parallelStream().filter(s -> studPin.contains(s.getId()) && s.getGender().equals(gender)
//					&& s.getAge() < age && s.getClassId().equals(classes)).toList();
		}
	}

	private static List<Integer> hasMatchingAddress(Student student, List<Address> addList, int pincode) {
		return addList.stream().filter(a -> a.getPin_code() == pincode).map(Address::getStudent_id).toList();
	}

	public static List<Student> getByCity(String city, Gender gender, Integer age, Integer classes) {
		return studentList.parallelStream()
				.filter(s -> addList.stream().filter(a -> a.getCity().equals(city)).map(Address::getStudent_id).toList()
						.contains(s.getId()) && s.getGender() == gender && s.getAge() < age
						&& s.getClassId() == classes)
				.toList();

	}
}
