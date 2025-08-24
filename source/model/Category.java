package model;

import java.io.Serializable;

public class Category implements Serializable {
	
	private int id;
	private String name;
	public Category() {
		super();
	}
	public Category(String name) {
		super();
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
	    return name; // 讓下拉選單顯示分類名稱
	}

}
