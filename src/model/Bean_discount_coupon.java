package model;
//�Ż�ȯ
import java.sql.*;
public class Bean_discount_coupon {
	private String user_id;
	private int dis_id;
	private double dis_amout,cut_amout;
	//dis_amout������
	private String dis_content;
	
	public int getDis_id() {
		return dis_id;
	}
	public void setDis_id(int dis_id) {
		this.dis_id = dis_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public double getDis_amout() {
		return dis_amout;
	}
	public void setDis_amout(double dis_amout) {
		this.dis_amout = dis_amout;
	}
	public double getCut_amout() {
		return cut_amout;
	}
	public void setCut_amout(double cut_amout) {
		this.cut_amout = cut_amout;
	}
	public String getDis_content() {
		return dis_content;
	}
	public void setDis_content(String dis_content) {
		this.dis_content = dis_content;
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
	private Timestamp start_date,end_date;
	public String getCell(int i) {
		if(i==0) return this.getDis_content();
		else if(i==1) return String.valueOf(this.getDis_amout());
		else if(i==2) return String.valueOf(this.getCut_amout());
		else if(i==3) return this.getStart_date().toString();
		else if(i==4) return this.getEnd_date().toString();
		else if(i==5) return "����ȯ";
		else return "";
		
	}
}
