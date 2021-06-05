package entity;

public class User {
	private String email;
	private String pw;
	private String type;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public User(String email, String pw, String type) {
		super();
		this.email = email;
		this.pw = pw;
		this.type = type;
	}

	public User() {
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", pw=" + pw + ", type=" + type + "]";
	}

}
