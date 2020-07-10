package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.*;

public class Discount_Manager {
	//满减券的加载
	public List<Bean_discount_coupon> load_all_discount_coupon(Bean_user user){
		List<Bean_discount_coupon> b = new ArrayList<Bean_discount_coupon>(); 
		Sql_c s=new Sql_c();
		String sql="select dis_id,dis_content,dis_amout,cut_amout,start_date,end_date from discount_coupon "
				+ "where user_id=? and valid=1";
		s.getPt(sql);
		try {
			s.pt.setString(1, user.getUser_id());
			s.rs=s.pt.executeQuery();
			while(s.rs.next()) {
				Bean_discount_coupon bb=new Bean_discount_coupon();
				bb.setDis_id(s.rs.getInt(1));
				bb.setDis_content(s.rs.getString(2));
				bb.setDis_amout(s.rs.getFloat(3));
				bb.setCut_amout(s.rs.getDouble(4));
				bb.setStart_date(s.rs.getTimestamp(5));
				bb.setEnd_date(s.rs.getTimestamp(6));
				b.add(bb);
			}
			s.close_all();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return b;
	}
	//满折券的加载
	public List<Bean_meet_discount> load_all_meet_discount(Bean_user user){
		List<Bean_meet_discount> b = new ArrayList<Bean_meet_discount>(); 
		Sql_c s=new Sql_c();
		String sql="select md_id,md_content,md_amout,discount,start_date,end_date from meet_discount "
				+ "where user_id=? and valid=1";
		s.getPt(sql);
		try {
			s.pt.setString(1, user.getUser_id());
			s.rs=s.pt.executeQuery();
			while(s.rs.next()) {
				Bean_meet_discount bb=new Bean_meet_discount();
				bb.setMd_id(s.rs.getInt(1));
				bb.setMd_content(s.rs.getString(2));
				bb.setMd_amout(s.rs.getDouble(3));
				bb.setDiscount(s.rs.getDouble(4));
				bb.setStart_date(s.rs.getTimestamp(5));
				bb.setEnd_date(s.rs.getTimestamp(6));
				b.add(bb);
			}
			s.close_all();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return b;
	}
	
	
	public void add_coupon(String user_id,Bean_meet_discount b) {
		Sql_c s=new Sql_c();
		String sql="insert into meet_discount(user_id,md_content,md_amout,discount,start_date,end_date)"
				+ " values(?,?,?,?,?,?)";
		try {
			s.getPt(sql);
			s.pt.setString(1, user_id);
			s.pt.setString(2, b.getMd_content());
			s.pt.setDouble(3, b.getMd_amout());
			s.pt.setDouble(4, b.getDiscount());
			s.pt.setTimestamp(5, b.getStart_date());
			s.pt.setTimestamp(6, b.getEnd_date());
			s.pt.execute();
			s.close_all();				
			}
			catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	public void add_coupon(String user_id,Bean_discount_coupon b) {
		Sql_c s=new Sql_c();
		String sql="insert into discount_coupon(user_id,dis_content,dis_amout,cut_amout,start_date,end_date)"
				+ " values(?,?,?,?,?,?)";
		try {
			s.getPt(sql);
			s.pt.setString(1, user_id);
			s.pt.setString(2, b.getDis_content());
			s.pt.setDouble(3, b.getDis_amout());
			s.pt.setDouble(4, b.getCut_amout());
			s.pt.setTimestamp(5, b.getStart_date());
			s.pt.setTimestamp(6, b.getEnd_date());
			s.pt.execute();
			s.close_all();				
			}
			catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	public void delete_coupon(Bean_meet_discount b) {
		Sql_c s=new Sql_c();
		String sql="update meet_discount set valid=0 where dis_id=?";
		s.getPt(sql);
		try {
			s.pt.setInt(1, b.getMd_id());
			s.pt.execute();
			s.close_all();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return;
	}
	public void delete_coupon(Bean_discount_coupon b) {
		Sql_c s=new Sql_c();
		String sql="update discount_coupon set valid=0 where dis_id=?";
		s.getPt(sql);
		try {
			s.pt.setInt(1, b.getDis_id());
			s.pt.execute();
			s.close_all();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return;
	}
}
