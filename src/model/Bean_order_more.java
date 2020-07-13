package model;

import java.sql.Timestamp;

public class Bean_order_more {
	private String pro_name,order_state,coupon_type,coupon_content,user_id,pro_specification;
	public String getPro_specification() {
		return pro_specification;
	}
	public void setPro_specification(String pro_specification) {
		this.pro_specification = pro_specification;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	private int purchase_amout,order_id,pro_id;
	public int getPro_id() {
		return pro_id;
	}
	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int Order_id) {
		this.order_id = Order_id;
	}
	private float now_price,pre_price;
	private Timestamp arrived_time;
	public Timestamp getArrived_time() {
		return arrived_time;
	}
	public void setArrived_time(Timestamp arrived_time) {
		this.arrived_time = arrived_time;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public String getOrder_state() {
		return order_state;
	}
	public void setOrder_state(String order_state) {
		this.order_state = order_state;
	}
	public String getCoupon_type() {
		return coupon_type;
	}
	public void setCoupon_type(String coupon_type) {
		this.coupon_type = coupon_type;
	}
	public String getCoupon_content() {
		return coupon_content;
	}
	public void setCoupon_content(String coupon_content) {
		this.coupon_content = coupon_content;
	}
	public int getPurchase_amout() {
		return purchase_amout;
	}
	public void setPurchase_amout(int purchase_amout) {
		this.purchase_amout = purchase_amout;
	}
	public float getNow_price() {
		return now_price;
	}
	public void setNow_price(float now_price) {
		this.now_price = now_price;
	}
	public float getPre_price() {
		return pre_price;
	}
	public void setPre_price(float pre_price) {
		this.pre_price = pre_price;
	}
	public String getCell(int i) {
		if(i==0) return this.pro_name;
		else if(i==1) return String.valueOf(this.purchase_amout);
		else if(i==2) return String.valueOf(this.pre_price);
		else if(i==3) return String.valueOf(this.now_price);
		else  if(i==4) return this.arrived_time.toString();
		else if(i==5) return this.order_state;
		else return ""	;
	}
	public String getCell1(int i ) {
		if(i==0) return this.user_id;
		else if(i==1) return String.valueOf(this.pro_name);
		else if(i==2) return String.valueOf(this.pro_specification);
		else if(i==3) return String.valueOf(this.purchase_amout);
		else  if(i==4) return this.order_state;
		else return ""	;
	}
	public String getCell2(int i ) {
		if(i==0) return this.user_id;
		else if(i==1) return this.pro_name;
		else if(i==2) return String.valueOf(this.purchase_amout);
		else if(i==3) return String.valueOf(this.pre_price);
		else if(i==4) return String.valueOf(this.now_price);
		else  if(i==5) return this.arrived_time.toString();
		else if(i==6) return this.order_state;
		else return ""	;
	}
}
