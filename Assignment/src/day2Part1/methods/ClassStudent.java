package day2Part1.methods;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import day2Part1.module.Classes;
import day2Part1.module.Student;

public class ClassStudent {

	public static Integer getStudentClass(Character class_name) {
		List<Classes> classList = Assignment2_1.classList;

		Optional<Classes> classId = classList.stream().filter(c -> c.getName().equals(class_name)).findFirst();

		return classId.map(Classes::getId).get();
	}

	public static List<Student> getStudentByClass(List<Student> studList, Character class_name, Gender gender,
			Integer age, String city, Integer pincode) {
		int classId = getStudentClass(class_name);

		List<Student> student = new LinkedList<Student>();

		student = studList.stream().filter(s -> s.getClassId().equals(classId)).collect(Collectors.toList());

		List<Student> students = Filters.getStudentByGenderAgeCityPincode(student, gender, age, city, pincode);

		return students;
	}
}
