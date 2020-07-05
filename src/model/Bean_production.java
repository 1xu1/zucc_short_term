package model;
//pro_specification¹æ¸ñ
public class Bean_production {
	private int pro_id,type_id,promotion;
	private  String pro_name,pro_specification,pro_more;
	private float pro_price,vip_price;
	public int getPro_id() {
		return pro_id;
	}
	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public int getPromotion() {
		return promotion;
	}
	public void setPromotion(int promotion) {
		this.promotion = promotion;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public String getPro_specification() {
		return pro_specification;
	}
	public void setPro_specification(String pro_specification) {
		this.pro_specification = pro_specification;
	}
	public String getPro_more() {
		return pro_more;
	}
	public void setPro_more(String pro_more) {
		this.pro_more = pro_more;
	}
	public float getPro_price() {
		return pro_price;
	}
	public void setPro_price(float pro_price) {
		this.pro_price = pro_price;
	}
	public float getVip_price() {
		return vip_price;
	}
	public void setVip_price(float vip_price) {
		this.vip_price = vip_price;
	}
}
