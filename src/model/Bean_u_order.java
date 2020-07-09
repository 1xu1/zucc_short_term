package model;
import java.sql.*;
public class Bean_u_order {
	private int order_id,address_id;
	private float pre_price,price;
	private String order_state,user_id;//下单，配送，送达，退货
	private Timestamp arrived_time;
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String string) {
		this.user_id = string;
	}
	public float getPre_price() {
		return pre_price;
	}
	public void setPre_price(float pre_price) {
		this.pre_price = pre_price;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getOrder_state() {
		return order_state;
	}
	public void setOrder_state(String order_state) {
		this.order_state = order_state;
	}
	public Timestamp getArrived_time() {
		return arrived_time;
	}
	public void setArrived_time(Timestamp arrived_time) {
		this.arrived_time = arrived_time;
	}
	
}
