package entity;

public class Statistics {
	private String obj;
	private int num;

	public Statistics() {
		super();
	}

	public Statistics(String obj, int num) {
		super();
		this.obj = obj;
		this.num = num;
	}

	public String getObj() {
		return obj;
	}

	public void setObj(String obj) {
		this.obj = obj;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "Statistics [obj=" + obj + ", num=" + num + "]";
	}

}
