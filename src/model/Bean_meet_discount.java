package model;
import java.sql.*;
public class Bean_meet_discount {
	private int md_id,md_quatity;
	private String md_content;
	public int getMd_id() {
		return md_id;
	}
	public void setMd_id(int md_id) {
		this.md_id = md_id;
	}
	public int getMd_quatity() {
		return md_quatity;
	}
	public void setMd_quatity(int md_quatity) {
		this.md_quatity = md_quatity;
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
	private double discount;
	private Timestamp end_date,start_date;
	
}
