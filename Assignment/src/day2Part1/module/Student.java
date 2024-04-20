package day2Part1.module;

import day2Part1.methods.Gender;

public class Student {
	private Integer id;
	private String name;
	private Integer classId;
	private Integer marks;
	private Gender gender;
	private Integer age;
	private String status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public Integer getMarks() {
		return marks;
	}

	public void setMarks(Integer marks) {
		this.marks = marks;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender=='M'?Gender.M:Gender.F;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", classId=" + classId + ", marks=" + marks + ", gender="
				+ gender + ", age=" + age + ", status=" + status + "]";
	}

}
