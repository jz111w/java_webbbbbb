package entity;

public class Saler {
	private String id;
	private String pw;
	private String charge;

	public Saler() {
		super();
	}

	public Saler(String id, String pw, String charge) {
		super();
		this.id = id;
		this.pw = pw;
		this.charge = charge;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getCharge() {
		return charge;
	}

	public void setCharge(String charge) {
		this.charge = charge;
	}

	@Override
	public String toString() {
		return "Saler [id=" + id + ", pw=" + pw + ", charge=" + charge + "]";
	}

}
