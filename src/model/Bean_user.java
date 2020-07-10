package model;
import java.sql.*;

public class Bean_user {
	public static Bean_user currentLoginUser=null;
	private int manager,vip_valid=0;
	public int getVip_valid() {
		return vip_valid;
	}
	public void setVip_valid(int vip_valid) {
		this.vip_valid = vip_valid;
	}
	private String name,user_pwd,phone_number,mail,city,user_id;
	private Timestamp register_time,vip_end_date;
	public Timestamp getVip_end_date() {
		return vip_end_date;
	}
	public void setVip_end_date(Timestamp vip_end_date) {
		this.vip_end_date = vip_end_date;
	}
	private int vip;
	public int getVip() {
		return vip;
	}
	public void setVip(int vip) {
		this.vip = vip;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getManager() {
		return manager;
	}
	public void setManager(int manager) {
		this.manager = manager;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Timestamp getRegister_time() {
		return register_time;
	}
	public void setRegister_time(Timestamp register_time) {
		this.register_time = register_time;
	}
	
}
