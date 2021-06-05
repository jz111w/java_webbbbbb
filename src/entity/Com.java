package entity;

public class Com {
	private String id;
	private String brand;
	private String name;
	private String price;
	private String stock;

	public Com() {
	}

	public Com(String id, String brand, String name, String price, String stock) {
		super();
		this.id = id;
		this.brand = brand;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Com [id=" + id + ", brand=" + brand + ", name=" + name + ", price=" + price + ", stock=" + stock + "]";
	}

}
