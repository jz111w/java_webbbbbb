package entity;

public class Ord {
	private String id;
	private String time;
	private String email;
	private String comid;
	private String combrand;
	private String comname;
	private String price;

	public Ord() {
		super();
	}

	public Ord(String id, String time, String email, String comid, String combrand, String comname, String price) {
		super();
		this.id = id;
		this.time = time;
		this.email = email;
		this.comid = comid;
		this.combrand = combrand;
		this.comname = comname;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getComid() {
		return comid;
	}

	public void setComid(String comid) {
		this.comid = comid;
	}

	public String getCombrand() {
		return combrand;
	}

	public void setCombrand(String combrand) {
		this.combrand = combrand;
	}

	public String getComname() {
		return comname;
	}

	public void setComname(String comname) {
		this.comname = comname;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Ord [id=" + id + ", time=" + time + ", email=" + email + ", comid=" + comid + ", combrand=" + combrand
				+ ", comname=" + comname + ", price=" + price + "]";
	}

}