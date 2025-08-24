package model;

import java.io.Serializable;

public class PorderDetail implements Serializable{
private int id;
private String porderId;
private int categoryId;
private int productId;
private String productName;
private int quantity;
public PorderDetail() {
	super();
}
public PorderDetail(String porderId,int categoryId, int productId, String productName, int quantity) {
	super();
	this.porderId = porderId;
	this.categoryId = categoryId;
	this.productId = productId;
	this.productName = productName;
	this.quantity = quantity;
}
public String getPorderId() {
	return porderId;
}
public void setPorderId(String porderId) {
	this.porderId = porderId;
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
public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}


}
