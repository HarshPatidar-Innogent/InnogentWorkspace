package day2Part1.validation;

import day2Part1.methods.Gender;

public class ValidateInput {
	public static Boolean validateAge(Integer age) {
		if (age != null) {
			return true;
		}
		return false;
	}

	public static Boolean validateGender(Gender gender) {
		if (gender == Gender.M || gender == Gender.F)
			return true;
		return false;
	}

	public static Boolean validateClass(Integer classs) {
		if (classs != null)
			return true;
		return false;
	}
}
