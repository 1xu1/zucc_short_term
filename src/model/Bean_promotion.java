package model;
import java.sql.*;
public class Bean_promotion {
	private int pr_id,pro_id,pr_quatity;
	private float pr_price;
	private Timestamp start_date,end_date;
	public int getPr_id() {
		return pr_id;
	}
	public void setPr_id(int pr_id) {
		this.pr_id = pr_id;
	}
	public int getPro_id() {
		return pro_id;
	}
	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}
	public int getPr_quatity() {
		return pr_quatity;
	}
	public void setPr_quatity(int pr_quatity) {
		this.pr_quatity = pr_quatity;
	}
	public float getPr_price() {
		return pr_price;
	}
	public void setPr_price(float pr_price) {
		this.pr_price = pr_price;
	}
	public Timestamp getStart_date() {
		return start_date;
	}
	public void setStart_date(Timestamp start_date) {
		this.start_date = start_date;
	}
	public Timestamp getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Timestamp end_date) {
		this.end_date = end_date;
	}
	
}
