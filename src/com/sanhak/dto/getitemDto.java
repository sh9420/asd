package com.sanhak.dto;

public class getitemDto {

	private int getid;
	private int lostid;
	private String mid;
	private String getdate;
	private String prdtname;
	private int Rresult;
	
	
	
	public String getPrdtname() {
		return prdtname;
	}
	public void setPrdtname(String prdtname) {
		this.prdtname = prdtname;
	}
	public int getRresult() {
		return Rresult;
	}
	public void setRresult(int rresult) {
		Rresult = rresult;
	}
	public int getGetid() {
		return getid;
	}
	public void setGetid(int getid) {
		this.getid = getid;
	}
	public int getLostid() {
		return lostid;
	}
	public void setLostid(int lostid) {
		this.lostid = lostid;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getGetdate() {
		return getdate;
	}
	public void setGetdate(String getdate) {
		this.getdate = getdate;
	}
	
	
	
}
