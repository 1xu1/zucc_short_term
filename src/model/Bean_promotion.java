package model;
import java.sql.*;
public class Bean_promotion {
	private int pr_id,pro_id,pr_quatity;
	private float pr_price,pro_price;
	private Timestamp start_date,end_date;
	private String pro_name,pro_sp,pro_more;
	public String getPro_more() {
		return pro_more;
	}
	public void setPro_more(String pro_more) {
		this.pro_more = pro_more;
	}
	public static final String[] tableTitles = {"名称","商品原价","促销价","规格","剩余数量","详情","开始日期 ","结束日期" };
	public int getPr_id() {
		return pr_id;
	}
	public float getPro_price() {
		return pro_price;
	}
	public void setPro_price(float pro_price) {
		this.pro_price = pro_price;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public String getPro_sp() {
		return pro_sp;
	}
	public void setPro_sp(String pro_sp) {
		this.pro_sp = pro_sp;
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
