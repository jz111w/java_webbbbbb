package entity;

public class LogP {
	private String id;
	private String time;
	private String email;
	private String comid;
	private String combrand;
	private String comname;

	public LogP() {
		// TODO Auto-generated constructor stub
	}

	public LogP(String id, String time, String email, String comid, String combrand, String comname) {
		super();
		this.id = id;
		this.time = time;
		this.email = email;
		this.comid = comid;
		this.combrand = combrand;
		this.comname = comname;
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

	@Override
	public String toString() {
		return "LogP [id=" + id + ", time=" + time + ", email=" + email + ", comid=" + comid + ", combrand=" + combrand
				+ ", comname=" + comname + "]";
	}

}
