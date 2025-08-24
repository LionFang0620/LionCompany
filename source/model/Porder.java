package model;

import java.io.Serializable;

public class Porder implements Serializable{
	
	private int id;
	private String porderId;
	private String porderTime;
	private int memberId;
	private int total;
	public Porder() {
		super();
	}
	public Porder(String porderId,String porderTime, int memberId,int total) {
		super();
		this.porderId = porderId;
		this.porderTime = porderTime;
		this.memberId = memberId;
		this.total=total;
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
	public String getPorderTime() {
		return porderTime;
	}
	public void setPorderTime(String porderTime) {
		this.porderTime = porderTime;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	

}
