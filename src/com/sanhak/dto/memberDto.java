package com.sanhak.dto;

public class memberDto {
	private String mid;
	private String password;
	private String mtel;
	private String email;
	private int mgrant;
	private int result;
	private String name;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMtel() {
		return mtel;
	}
	public void setMtel(String mtel) {
		this.mtel = mtel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getMgrant() {
		return mgrant;
	}
	public void setMgrant(int mgrant) {
		this.mgrant = mgrant;
	}
	@Override
	public String toString() {
		return "memberDto [mid=" + mid + ", password=" + password + ", mtel=" + mtel + ", email=" + email + ", mgrant="
				+ mgrant + "]";
	}
	
	
}
