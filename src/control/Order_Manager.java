package control;

import start.Online_Market_Util;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import control.*;
import model.*;
import ui.*;
import util.*;

public class Order_Manager {
	//加载特定用户的订单信息
	public List<Bean_u_order> load_order(Bean_user user) {
		List<Bean_u_order> b = new ArrayList<Bean_u_order>();
		Sql_c s=new Sql_c();
		String sql="select order_id,address_id,user_id,pre_price,price,order_state,arrived_time from u_order "
				+ " where user_id=?";
		s.getPt(sql);
	 
		try {
			s.pt.setString(1, user.getUser_id());
			s.rs=s.pt.executeQuery();
			while(s.rs.next()) {
				Bean_u_order bb=new Bean_u_order();
				bb.setOrder_id(s.rs.getInt(1));
				bb.setAddress_id(s.rs.getInt(2));
				bb.setUser_id(s.rs.getString(3));
				bb.setPre_price(s.rs.getFloat(4));
				bb.setPrice(s.rs.getFloat(5));
				bb.setOrder_state(s.rs.getString(6));
				bb.setArrived_time(s.rs.getTimestamp(7));
				
				b.add(bb);
			}
			s.close_all();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return b;
	}
	//通过订单信息加载出订单详情
	public List<Bean_order_more> load_order_more(Bean_user user) {
		List<Bean_order_more> result = new ArrayList<Bean_order_more>();
		Sql_c s=new Sql_c();
		String sql;
		try {			
			sql="select pro_name,pro_quatity,pre_price,price,arrived_time,order_state,order_id,pro_id,user_id "
						+ "from order_more "
						+ "where user_id=?";
			s.getPt(sql);
			s.pt.setString(1, user.getUser_id());
			s.rs=s.pt.executeQuery();
			while(s.rs.next()) {
				Bean_order_more a=new Bean_order_more();
				a.setPro_name(s.rs.getString(1));
				a.setPurchase_amout(s.rs.getInt(2));
				a.setPre_price(s.rs.getFloat(3));
				a.setNow_price(s.rs.getFloat(4));
				a.setArrived_time(s.rs.getTimestamp(5));
				a.setOrder_state(s.rs.getString(6));
				a.setOrder_id(s.rs.getInt(7));
				a.setPro_id(s.rs.getInt(8));
				a.setUser_id(s.rs.getString(9));
				result.add(a);
			}
			
			s.close_all();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return result;
	}
	public List<Bean_order_more> load_order_more() {
		List<Bean_order_more> result = new ArrayList<Bean_order_more>();
		Sql_c s=new Sql_c();
		String sql;
		try {			
			sql="select pro_name,pro_quatity,pre_price,price,arrived_time,order_state,order_id,pro_id,user_id "
						+ "from order_more "
						;
			s.getPt(sql);
			
			s.rs=s.pt.executeQuery();
			while(s.rs.next()) {
				Bean_order_more a=new Bean_order_more();
				a.setPro_name(s.rs.getString(1));
				a.setPurchase_amout(s.rs.getInt(2));
				a.setPre_price(s.rs.getFloat(3));
				a.setNow_price(s.rs.getFloat(4));
				a.setArrived_time(s.rs.getTimestamp(5));
				a.setOrder_state(s.rs.getString(6));
				a.setOrder_id(s.rs.getInt(7));
				a.setPro_id(s.rs.getInt(8));
				a.setUser_id(s.rs.getString(9));
				result.add(a);
			}
			
			s.close_all();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return result;
	}
	//没有使用任何优惠券
	public void add_order(Bean_user user,Bean_address add,List<Bean_production> pro_list,double pre_price,double now_price){
		Sql_c s=new Sql_c();
		String sql="insert into u_order (address_id,user_id,pre_price,price,arrived_time,order_state,coupon_id,type,pro_id,pro_quatity) "
				+ "values (?,?,?,?,?,?,?,?,?,?)";
		s.getPt(sql);
		try {
			//插入订单
			for(int i=0;i<pro_list.size();i++) {
				
				s.pt.setInt(1, add.getAddress_id());
				s.pt.setString(2, user.getUser_id());
				s.pt.setFloat(3,(float) pre_price);
				s.pt.setFloat(4,(float) now_price);
				Timestamp arrived_time=new Timestamp((System.currentTimeMillis()+60*60*1000*48));
				s.pt.setTimestamp(5, arrived_time);
				s.pt.setString(6, "已下单");
				s.pt.setInt(7, -1);
				s.pt.setString(8, null);
				s.pt.setInt(9,pro_list.get(i).getPro_id() );
				s.pt.setInt(10, pro_list.get(i).getPro_purchase());
				s.pt.execute();
				
			}
			s.close();
			//减少该产品存货数量						
			for(int i=0;i<pro_list.size();i++) {
				if(pro_list.get(i).getPromotion()==0) {
					sql="update production set pro_stock=pro_stock-? where pro_id=?";
					s.getPt(sql);
					s.pt.setInt(1, pro_list.get(i).getPro_purchase());
					s.pt.setInt(2, pro_list.get(i).getPro_id());
					s.pt.execute();
					s.close();
				}
				else {
					sql="update promotion set pr_quatity=pr_quatity-? where pr_id=?";
					s.getPt(sql);
					s.pt.setInt(1, pro_list.get(i).getPro_purchase());
					s.pt.setInt(2, pro_list.get(i).getPr_id());
					s.pt.execute();
					s.close();
				}
			}
			s.close_all();
			}
		 catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	//使用满减券的
	public void add_order(Bean_user user,Bean_address add,List<Bean_production> pro_list,double pre_price,double now_price,Bean_discount_coupon coupon){
		Sql_c s=new Sql_c();
		String sql="insert into u_order (address_id,user_id,pre_price,price,arrived_time,order_state,coupon_id,type,pro_id,pro_quatity) "
				+ "values (?,?,?,?,?,?,?,?,?,?)";
		s.getPt(sql);
		try {
			//插入订单
			for(int i=0;i<pro_list.size();i++) {
				
				s.pt.setInt(1, add.getAddress_id());
				s.pt.setString(2, user.getUser_id());
				s.pt.setFloat(3,(float) pre_price);
				s.pt.setFloat(4,(float) now_price);
				Timestamp arrived_time=new Timestamp((System.currentTimeMillis()+60*60*1000*48));
				s.pt.setTimestamp(5, arrived_time);
				s.pt.setString(6, "已下单");
				s.pt.setInt(7, coupon.getDis_id());
				s.pt.setString(8, coupon.getCell(5));
				s.pt.setInt(9,pro_list.get(i).getPro_id() );
				s.pt.setInt(10, pro_list.get(i).getPro_purchase());
				s.pt.execute();
			}
			s.close();
			//减少该产品存货数量
			for(int i=0;i<pro_list.size();i++) {
				if(pro_list.get(i).getPromotion()==0) {
					sql="update production set pro_stock=pro_stock-? where pro_id=?";
					s.getPt(sql);
					s.pt.setInt(1, pro_list.get(i).getPro_purchase());
					s.pt.setInt(2, pro_list.get(i).getPro_id());
					s.pt.execute();
					s.close();
				}
				else {
					sql="update promotion set pr_quatity=pr_quatity-? where pr_id=?";
					s.getPt(sql);
					s.pt.setInt(1, pro_list.get(i).getPro_purchase());
					s.pt.setInt(2, pro_list.get(i).getPr_id());
					s.pt.execute();
					s.close();
				}
			}
			s.close();
			//使用过的优惠券失效
			sql="update discount_coupon set valid=0 where dis_id=?";
			s.getPt(sql);
			s.pt.setInt(1, coupon.getDis_id());
			s.pt.execute();
			s.close_all();
			}
		 catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	//使用满折券
	public void add_order(Bean_user user,Bean_address add,List<Bean_production> pro_list,double pre_price,double now_price,Bean_meet_discount coupon){
		Sql_c s=new Sql_c();
		String sql="insert into u_order (address_id,user_id,pre_price,price,arrived_time,order_state,coupon_id,type,pro_id,pro_quatity) "
				+ "values (?,?,?,?,?,?,?,?,?,?)";
		s.getPt(sql);
		try {
			//插入订单
			for(int i=0;i<pro_list.size();i++) {
				
				s.pt.setInt(1, add.getAddress_id());
				s.pt.setString(2, user.getUser_id());
				s.pt.setFloat(3,(float) pre_price);
				s.pt.setFloat(4,(float) now_price);
				Timestamp arrived_time=new Timestamp((System.currentTimeMillis()+60*60*1000*48));
				s.pt.setTimestamp(5, arrived_time);
				s.pt.setString(6, "已下单");
				s.pt.setInt(7, coupon.getMd_id());
				s.pt.setString(8, coupon.getCell(5));
				s.pt.setInt(9,pro_list.get(i).getPro_id() );
				s.pt.setInt(10, pro_list.get(i).getPro_purchase());
				s.pt.execute();
			}
			s.close();
			//减少该产品存货数量
			for(int i=0;i<pro_list.size();i++) {
				if(pro_list.get(i).getPromotion()==0) {
					sql="update production set pro_stock=pro_stock-? where pro_id=?";
					s.getPt(sql);
					s.pt.setInt(1, pro_list.get(i).getPro_purchase());
					s.pt.setInt(2, pro_list.get(i).getPro_id());
					s.pt.execute();
					s.close();
				}
				else {
					sql="update promotion set pr_quatity=pr_quatity-? where pr_id=?";
					s.getPt(sql);
					s.pt.setInt(1, pro_list.get(i).getPro_purchase());
					s.pt.setInt(2, pro_list.get(i).getPr_id());
					s.pt.execute();
					s.close();
				}
			}
			s.close();
			//使用过的优惠券失效
			sql="update meet_discount set valid=0 where dis_id=?";
			s.getPt(sql);
			s.pt.setInt(1, coupon.getMd_id());
			s.pt.execute();
			s.close_all();
			}
		 catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public void edit_order(int order_id,String state) {
		
		Sql_c s=new Sql_c();
		String sql;
		try {		
			
			sql="update u_order set order_state=? "
					+ "where order_id=?";
			s.getPt(sql);
			s.pt.setString(1, state);
			s.pt.setInt(2, order_id);
			s.pt.execute();
			s.close_all();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return ;
	}
}
