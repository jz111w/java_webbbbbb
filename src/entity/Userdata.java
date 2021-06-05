package entity;

public class Userdata {
	private String id;
	private String email;
	private String brand;
	private int grade;

	public Userdata() {
		super();
	}

	public Userdata(String id, String email, String brand, int grade) {
		super();
		this.id = id;
		this.email = email;
		this.brand = brand;
		this.grade = grade;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Userdata [id=" + id + ", email=" + email + ", brand=" + brand + ", grade=" + grade + "]";
	}

}
