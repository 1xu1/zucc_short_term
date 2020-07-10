package model;
import java.sql.*;
public class Bean_meet_discount {
	private int md_id;
	private double md_amout;
	private String md_content,user_id;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getMd_id() {
		return md_id;
	}
	public void setMd_id(int md_id) {
		this.md_id = md_id;
	}
	public double getMd_amout() {
		return md_amout;
	}
	public void setMd_amout(double md_amout) {
		this.md_amout = md_amout;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public Timestamp getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Timestamp end_date) {
		this.end_date = end_date;
	}
	public Timestamp getStart_date() {
		return start_date;
	}
	public void setStart_date(Timestamp start_date) {
		this.start_date = start_date;
	}
	public String getMd_content() {
		return md_content;
	}
	public void setMd_content(String md_content) {
		this.md_content = md_content;
	}
	private double discount;
	private Timestamp end_date,start_date;
	public String getCell(int i) {
		if(i==0) return this.getMd_content();
		else if(i==1) return String.valueOf(this.getMd_amout());
		else if(i==2) return String.valueOf(this.getDiscount());
		else if(i==3) return this.getStart_date().toString();
		else if(i==4) return this.getEnd_date().toString();
		else if(i==5) return "ÂúÕÛÈ¯";
		else return "";
		
	}
}
