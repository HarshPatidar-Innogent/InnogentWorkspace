package day2Part1.module;

public class Address {
	private Integer id;
	private Long pinCode;
	private String city;
	private Integer studentId;

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", pin_code=" + pinCode + ", city=" + city + ", student_id=" + studentId + "]";
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getPin_code() {
		return pinCode;
	}

	public void setPin_code(long pin_code) {
		this.pinCode = pin_code;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getStudent_id() {
		return studentId;
	}

	public void setStudent_id(int student_id) {
		this.studentId = student_id;
	}

}
