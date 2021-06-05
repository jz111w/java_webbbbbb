package entity;

public class ManagerLogO {
	private String id;
	private String time;
	private String ip;
	private String action;

	public ManagerLogO() {
		super();
	}

	public ManagerLogO(String id, String time, String ip, String action) {
		super();
		this.id = id;
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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "ManagerLogO [id=" + id + ", time=" + time + ", ip=" + ip + ", action=" + action + "]";
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

}
