package entity;

public class SalerLogO {
	private String id;
	private String salerid;
	private String time;
	private String ip;
	private String action;

	public SalerLogO() {
		super();
	}

	public SalerLogO(String id, String salerid, String time, String ip, String action) {
		super();
		this.id = id;
		this.salerid = salerid;
		this.time = time;
		this.ip = ip;
		this.action = action;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSalerid() {
		return salerid;
	}

	public void setSalerid(String salerid) {
		this.salerid = salerid;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	@Override
	public String toString() {
		return "SalerLogO [id=" + id + ", salerid=" + salerid + ", time=" + time + ", ip=" + ip + ", action=" + action
				+ "]";
	}

}
