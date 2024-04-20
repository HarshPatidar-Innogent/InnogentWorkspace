package day2Part1.methods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import day2Part1.module.Classes;
import day2Part1.module.Student;

public class DeleteClass {
	public static List<Classes> classList = Assignment2_1.classList;
	public static List<Student> studentList = Assignment2_1.studentList;
	static int zeroId = 0;

	public static String deleteClass() {
		Map<Integer, Integer> studentsByClassId = new HashMap<Integer, Integer>();

		classList.stream().forEach(c -> {
			studentsByClassId.put(c.getId(), 0);
		});

		studentList.stream().forEach(c -> {
			studentsByClassId.put(c.getClassId(), studentsByClassId.getOrDefault(c.getClassId(), 0) + 1);
		});

		zeroId = studentsByClassId.entrySet().stream().filter(e -> e.getValue().equals(0)).map(Map.Entry::getKey)
				.findFirst().get();
		Character className = classList.stream().filter(c -> c.getId() == zeroId).findFirst().map(Classes::getName)
				.get();
		classList = classList.stream().filter(c -> c.getId() != zeroId).collect(Collectors.toList());
		if (zeroId != 0)
			return className + " Class Deleted";
		return "CLass Not Deleted";

	}
}
