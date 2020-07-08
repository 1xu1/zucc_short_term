package model;
//pro_specification规格
public class Bean_production {
	private int pro_id,type_id,promotion,pro_stock;
	
	private  String pro_name,pro_specification,pro_more;
	private float pro_price,vip_price;
	private int pro_purchase=0;
	public int getPro_purchase() {
		return pro_purchase;
	}
	public void setPro_purchase(int pro_purchase) {
		this.pro_purchase = pro_purchase;
	}
	public static final String[] tableTitles = {"名称","商品原价","会员价","规格","剩余数量","详情 " };
	public int getPro_stock() {
		return pro_stock;
	}
	public void setPro_stock(int pro_stock) {
		this.pro_stock = pro_stock;
	}
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
	public String getCell(int col){
		if(col==0) return this.pro_name;
		else if(col==1) return String.valueOf(this.pro_price);
		else if(col==2) return String.valueOf(this.vip_price);
		else if(col==3) return this.pro_specification;
		else if(col==4)	return String.valueOf(this.pro_stock);
		else if(col==5) return this.pro_more;
		else if(col==6) return String.valueOf(this.pro_purchase);
		else return "";
	}
}
