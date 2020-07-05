package model;
import java.sql.*;
public class Bean_comment {
	private int user_id,pro_id,cm_star;
	private String cm_content,cm_picture;
	private Timestamp cm_data;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getPro_id() {
		return pro_id;
	}
	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}
	public int getCm_star() {
		return cm_star;
	}
	public void setCm_star(int cm_star) {
		this.cm_star = cm_star;
	}
	public String getCm_content() {
		return cm_content;
	}
	public void setCm_content(String cm_content) {
		this.cm_content = cm_content;
	}
	public String getCm_picture() {
		return cm_picture;
	}
	public void setCm_picture(String cm_picture) {
		this.cm_picture = cm_picture;
	}
	public Timestamp getCm_data() {
		return cm_data;
	}
	public void setCm_data(Timestamp cm_data) {
		this.cm_data = cm_data;
	}
	
}
