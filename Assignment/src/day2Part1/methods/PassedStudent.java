package day2Part1.methods;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import day2Part1.module.Student;

public class PassedStudent {
	public static List<Student> getPassStudent(List<Student> studList, 
			Gender gender, Integer age, Integer class_id, String city, Integer pincode) {
		List<Student> rankedStudent = Ranking.ranking(studList);
		List<Student> passedStudent = Filters.studFilterByStatusAgeClassGender(rankedStudent, age, class_id, gender);
		List<Integer> stud_id = Filters.getStudentIdByAddress(passedStudent, city, pincode);
		
		List<Student> student = passedStudent.stream().filter(s->stud_id.contains(s.getId())).collect(Collectors.toList());
		
		if (student.isEmpty()) {
			return Collections.emptyList();
		} else {
			return student;
		}
	}
	
	public static List<Student> getPassStudent(List<Student> studList){
		return studList.stream().filter(s->s.getMarks()>50).collect(Collectors.toList());
				}
}
