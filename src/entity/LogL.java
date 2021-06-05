package entity;

public class LogL {
	private String id;
	private String email;
	private String time;
	private String ip;
	private String action;

	public LogL() {
		super();
	}

	public LogL(String id, String email, String time, String ip, String action) {
		super();
		this.id = id;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		return "LogL [id=" + id + ", email=" + email + ", time=" + time + ", ip=" + ip + ", action=" + action + "]";
	}

}
