package day2Part1.methods;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import day2Part1.module.Student;

public class SortedAndPaginated {
	public static List<Student> getSortedStudentByOrder(List<Student> studList, Gender gender, int start, int end,
			String sortBy, boolean ReverseOrder) {
		Comparator<Student> comparator = getComparator(sortBy, ReverseOrder);
		return studList.stream().filter(s -> s.getGender().equals(gender)).sorted(comparator).skip(start - 1).limit(end)
				.collect(Collectors.toList());
	}

	public static Comparator<Student> getComparator(String sortBy, boolean reverseOrder) {
		Comparator<Student> comparator = null;

		switch (sortBy) {
		case "name":
			comparator = Comparator.comparing(Student::getName);
			if(reverseOrder==true)
				comparator = Comparator.comparing(Student::getName).reversed();
			break;
		case "marks":
			comparator = Comparator.comparing(Student::getMarks);
			if(reverseOrder==true)
				comparator = Comparator.comparing(Student::getMarks).reversed();
			break;
		case "class_id":
			comparator = Comparator.comparing(Student::getClassId);
			if(reverseOrder==true)
				comparator = Comparator.comparing(Student::getClassId).reversed();
			break;
		default:
			comparator = Comparator.comparing(Student::getId);
			if(reverseOrder==true)
				comparator = Comparator.comparing(Student::getId).reversed();
		}
		return comparator;
	}
}
