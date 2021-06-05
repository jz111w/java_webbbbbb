package entity;

public class Cart {
	private String id;
	private String comid;
	private String combrand;
	private String comname;
	private String comprice;
	private String email;

	public Cart() {
		super();
	}

	public Cart(String id, String comid, String combrand, String comname, String comprice, String email) {
		super();
		this.id = id;
		this.comid = comid;
		this.combrand = combrand;
		this.comname = comname;
		this.comprice = comprice;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getComprice() {
		return comprice;
	}

	public void setComprice(String comprice) {
		this.comprice = comprice;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
