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
	public List<Bean_u_order> load_order() {
		List<Bean_u_order> b = new ArrayList<Bean_u_order>();
		Sql_c s=new Sql_c();
		String sql="select order_id,address_id,user_id,pre_price,price,order_state,arrived_time from u_orser";
		s.getRs(sql);
		try {
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return b;
	}
	//û��ʹ���κ��Ż�ȯ
	public void add_order(Bean_user user,Bean_address add,List<Bean_production> pro_list,double pre_price,double now_price){
		Sql_c s=new Sql_c();
		String sql="insert into u_order (address_id,user_id,pre_price,price,arrived_time,order_state,coupon_id,type,pro_id,pro_quatity) "
				+ "values (?,?,?,?,?,?,?,?,?,?)";
		s.getPt(sql);
		try {
			//���붩��
			for(int i=0;i<pro_list.size();i++) {
				
				s.pt.setInt(1, add.getAddress_id());
				s.pt.setString(2, user.getUser_id());
				s.pt.setFloat(3,(float) pre_price);
				s.pt.setFloat(4,(float) now_price);
				Timestamp arrived_time=new Timestamp((System.currentTimeMillis()+60*60*1000*48));
				s.pt.setTimestamp(5, arrived_time);
				s.pt.setString(6, "���µ�");
				s.pt.setInt(7, -1);
				s.pt.setString(8, null);
				s.pt.setInt(9,pro_list.get(i).getPro_id() );
				s.pt.setInt(10, pro_list.get(i).getPro_purchase());
				s.pt.execute();
			}
			s.close();
			//���ٸò�Ʒ�������
			sql="update production set pro_stock=pro_stock-? where pro_id=?";
			s.getPt(sql);
			for(int i=0;i<pro_list.size();i++) {
				s.pt.setInt(1, pro_list.get(i).getPro_purchase());
				s.pt.setInt(2, pro_list.get(i).getPro_id());
				s.pt.execute();
			}
			s.close_all();
			}
		 catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	//ʹ������ȯ��
	public void add_order(Bean_user user,Bean_address add,List<Bean_production> pro_list,double pre_price,double now_price,Bean_discount_coupon coupon){
		Sql_c s=new Sql_c();
		String sql="insert into u_order (address_id,user_id,pre_price,price,arrived_time,order_state,coupon_id,type,pro_id,pro_quatity) "
				+ "values (?,?,?,?,?,?,?,?,?,?)";
		s.getPt(sql);
		try {
			//���붩��
			for(int i=0;i<pro_list.size();i++) {
				
				s.pt.setInt(1, add.getAddress_id());
				s.pt.setString(2, user.getUser_id());
				s.pt.setFloat(3,(float) pre_price);
				s.pt.setFloat(4,(float) now_price);
				Timestamp arrived_time=new Timestamp((System.currentTimeMillis()+60*60*1000*48));
				s.pt.setTimestamp(5, arrived_time);
				s.pt.setString(6, "���µ�");
				s.pt.setInt(7, coupon.getDis_id());
				s.pt.setString(8, coupon.getCell(5));
				s.pt.setInt(9,pro_list.get(i).getPro_id() );
				s.pt.setInt(10, pro_list.get(i).getPro_purchase());
				s.pt.execute();
			}
			s.close();
			//���ٸò�Ʒ�������
			sql="update production set pro_stock=pro_stock-? where pro_id=?";
			s.getPt(sql);
			for(int i=0;i<pro_list.size();i++) {
				s.pt.setInt(1, pro_list.get(i).getPro_purchase());
				s.pt.setInt(2, pro_list.get(i).getPro_id());
				s.pt.execute();
			}
			s.close();
			//ʹ�ù����Ż�ȯʧЧ
			sql="update discount_coupon set valid=0 where dis_id=?";
			s.getPt(sql);
			s.pt.setInt(1, coupon.getDis_id());
			s.pt.execute();
			s.close_all();
			}
		 catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	//ʹ������ȯ
	public void add_order(Bean_user user,Bean_address add,List<Bean_production> pro_list,double pre_price,double now_price,Bean_meet_discount coupon){
		Sql_c s=new Sql_c();
		String sql="insert into u_order (address_id,user_id,pre_price,price,arrived_time,order_state,coupon_id,type,pro_id,pro_quatity) "
				+ "values (?,?,?,?,?,?,?,?,?,?)";
		s.getPt(sql);
		try {
			//���붩��
			for(int i=0;i<pro_list.size();i++) {
				
				s.pt.setInt(1, add.getAddress_id());
				s.pt.setString(2, user.getUser_id());
				s.pt.setFloat(3,(float) pre_price);
				s.pt.setFloat(4,(float) now_price);
				Timestamp arrived_time=new Timestamp((System.currentTimeMillis()+60*60*1000*48));
				s.pt.setTimestamp(5, arrived_time);
				s.pt.setString(6, "���µ�");
				s.pt.setInt(7, coupon.getMd_id());
				s.pt.setString(8, coupon.getCell(5));
				s.pt.setInt(9,pro_list.get(i).getPro_id() );
				s.pt.setInt(10, pro_list.get(i).getPro_purchase());
				s.pt.execute();
			}
			s.close();
			//���ٸò�Ʒ�������
			sql="update production set pro_stock=pro_stock-? where pro_id=?";
			s.getPt(sql);
			for(int i=0;i<pro_list.size();i++) {
				s.pt.setInt(1, pro_list.get(i).getPro_purchase());
				s.pt.setInt(2, pro_list.get(i).getPro_id());
				s.pt.execute();
			}
			s.close();
			//ʹ�ù����Ż�ȯʧЧ
			sql="update meet_discount set valid=0 where dis_id=?";
			s.getPt(sql);
			s.pt.setInt(1, coupon.getMd_id());
			s.pt.execute();
			s.close_all();
			}
		 catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
}