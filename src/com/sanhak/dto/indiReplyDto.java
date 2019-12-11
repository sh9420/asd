package com.sanhak.dto;

public class indiReplyDto {
	
	String reid;
	String mid;
	String redate;
	String reply;
	String inum;
	public String getReid() {
		return reid;
	}
	public void setReid(String reid) {
		this.reid = reid;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getRedate() {
		return redate;
	}
	public void setRedate(String redate) {
		this.redate = redate;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getInum() {
		return inum;
	}
	public void setInum(String inum) {
		this.inum = inum;
	}
	@Override
	public String toString() {
		return "indiReplyDto [reid=" + reid + ", mid=" + mid + ", redate=" + redate + ", reply=" + reply + ", inum="
				+ inum + "]";
	}
}
