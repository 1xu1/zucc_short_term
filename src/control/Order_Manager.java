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
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return b;
	}
	public void add_order(Bean_user user,Bean_address add,List<Bean_production> pro_list,double pre_price,double now_price){
		Sql_c s=new Sql_c();
		String sql="insert into u_order (address_id,user_id,pre_price,price,arrived_time,order_state) "
				+ "values (?,?,?,?,?,?)";
		s.getPt(sql);
		try {
			//插入订单
			s.pt.setInt(1, add.getAddress_id());
			s.pt.setString(2, user.getUser_id());
			s.pt.setFloat(3,(float) pre_price);
			s.pt.setFloat(4,(float) now_price);
			Timestamp arrived_time=new Timestamp((System.currentTimeMillis()+60*60*1000*48));
			s.pt.setTimestamp(5, arrived_time);
			s.pt.setString(6, "已下单");
			s.close();
			//插入订单详情
			sql="insert into order_more(order_id,pro_id,md_id,quatity,discount)";
			
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
