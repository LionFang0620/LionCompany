package model;

import java.io.Serializable;

public class Product implements Serializable {
	private int id;
	private int categoryId;
	private String name;
	private int price;
	public Product() {
		super();
	}
	public Product(int categoryId, String name, int price) {
		super();
		this.categoryId = categoryId;
		this.name = name;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	

}
