package entity;

public class Image {
	private String obj1;
	private String obj2;

	public Image() {
		super();
	}

	public Image(String obj1, String obj2) {
		super();
		this.obj1 = obj1;
		this.obj2 = obj2;
	}

	public String getObj1() {
		return obj1;
	}

	public void setObj1(String obj1) {
		this.obj1 = obj1;
	}

	public String getObj2() {
		return obj2;
	}

	public void setObj2(String obj2) {
		this.obj2 = obj2;
	}

	@Override
	public String toString() {
		return "Image [obj1=" + obj1 + ", obj2=" + obj2 + "]";
	}

}
