package model;

public class Bean_type {
	private int type_id,count;
	private String type_name,type_more;
	public static final String[] tableTitles = {"Ãû³Æ","×ÜÊý","ÃèÊö" };
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public String getType_more() {
		return type_more;
	}
	public void setType_more(String type_more) {
		this.type_more = type_more;
	}
	public String getCell(int col){
		if(col==0) return this.type_name;
		else if(col==1) return String.valueOf(this.count);
		else if(col==2) return this.type_more;
		else return "";
	}
}
