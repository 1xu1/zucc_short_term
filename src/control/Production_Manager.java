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


public class Production_Manager {
	public List<Bean_type> load_all_type(){
		List<Bean_type> b = new ArrayList<Bean_type>();
		
		Sql_c s=new Sql_c();
		String sql="select type_name,count,description,type_id from type";
		s.getRs(sql);
		try {
			while(s.rs.next()) {
				Bean_type bb=new Bean_type();
				bb.setType_name(s.rs.getString(1));
				bb.setCount(s.rs.getInt(2));
				bb.setType_more(s.rs.getString(3));
				bb.setType_id(s.rs.getInt(4));
				b.add(bb);
			}
			s.close_all();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return b;
	}
	
	public List<Bean_production> load_pro(Bean_type type){
		List<Bean_production> b = new ArrayList<Bean_production>();
		Sql_c s=new Sql_c();
		String sql="select pro_name,pro_price,pro_vip_price,pro_specification,pro_stock,pro_more,pro_id,promotion from production where type_id=? "
				+ "and valid!=0";
		try {
			s.getPt(sql);
			s.pt.setInt(1,type.getType_id());
			s.rs=s.pt.executeQuery();		
			while(s.rs.next()) {
				Bean_production bb=new Bean_production();
				bb.setPro_name(s.rs.getString(1));
				bb.setPro_price(s.rs.getFloat(2));
				bb.setVip_price(s.rs.getFloat(3));
				bb.setPro_specification(s.rs.getString(4));
				bb.setPro_stock(s.rs.getInt(5));
				bb.setPro_more(s.rs.getString(6));
				bb.setPro_id(s.rs.getInt(7));
				bb.setPromotion(s.rs.getInt(8));
				b.add(bb);
				
			}
			
			s.close_all();
			return b;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return b;
	}
	
	public Bean_production load_pro(int id){
		//List<Bean_production> b = new ArrayList<Bean_production>();
		Bean_production bb=null;
		Sql_c s=new Sql_c();
		String sql="select pro_name,pro_price,pro_vip_price,pro_specification,pro_stock,pro_more from production where pro_id=? ";
		try {
			s.getPt(sql);
			s.pt.setInt(1,id);
			s.rs=s.pt.executeQuery();
			
			while(s.rs.next()) {
				bb=new Bean_production();
				bb.setPro_name(s.rs.getString(1));
				bb.setPro_price(s.rs.getFloat(2));
				bb.setVip_price(s.rs.getFloat(3));
				bb.setPro_specification(s.rs.getString(4));
				bb.setPro_stock(s.rs.getInt(5));
				bb.setPro_more(s.rs.getString(6));
				bb.setPro_id(id);
				//b.add(bb);
				
			}
			
			s.close_all();
			return bb;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return bb;
	}
	
	public List<Bean_production> load_pro(String name){
		List<Bean_production> b = new ArrayList<Bean_production>();
		Sql_c s=new Sql_c();
		String sql="select pro_name,pro_price,pro_vip_price,pro_specification,pro_stock,pro_more,pro_id from production where pro_name like ? ";
		try {
			name="%"+name+"%";
			s.getPt(sql);
			s.pt.setString(1,name);
			s.rs=s.pt.executeQuery();		
			while(s.rs.next()) {
				Bean_production bb=new Bean_production();
				bb.setPro_name(s.rs.getString(1));
				bb.setPro_price(s.rs.getFloat(2));
				bb.setVip_price(s.rs.getFloat(3));
				bb.setPro_specification(s.rs.getString(4));
				bb.setPro_stock(s.rs.getInt(5));
				bb.setPro_more(s.rs.getString(6));
				bb.setPro_id(s.rs.getInt(7));
				b.add(bb);			
			}			
			s.close_all();
			return b;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return b;
	}
	
	public void add_type(Bean_type b) {
		Sql_c s=new Sql_c();
		String sql="insert into type(type_name,description)"
				+ " values(?,?)";
		try {
			s.getPt(sql);
			s.pt.setString(1, b.getType_name());
			s.pt.setString(2, b.getType_more());
			s.pt.execute();
			s.close_all();				
			}
			catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	public void edit_type(Bean_type b) {
		Sql_c s=new Sql_c();
		String sql="update type "
				+ "set type_name=?,description=?  "
				+ "where type_id=? ";
		try {
			s.getPt(sql);
			s.pt.setString(1, b.getType_name());
			s.pt.setString(2, b.getType_more());
			s.pt.setInt(3, b.getType_id());
			s.pt.execute();
			s.close_all();				
			}
			catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	public void delete_type(Bean_type b) {
		Sql_c s=new Sql_c();
		String sql="delete from type "
				+ "where type_id=? ";
		try {
			s.getPt(sql);
			s.pt.setInt(1, b.getType_id());
			s.pt.execute();
			s.close_all();				
			}
			catch (SQLException e) {
			// TODO 自动生成的 catch 块
			JOptionPane.showMessageDialog(null, "错误", "无法删除内有商品的种类", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	
	public void add_pro(Bean_production b) {
		
		Sql_c s=new Sql_c();
		String sql="insert into production(type_id,pro_name,pro_stock,pro_price,pro_vip_price,pro_specification,pro_more,promotion)"
				+ " values(?,?,?,?,?,?,?,?)";
		try {
			s.getPt(sql);
			s.pt.setInt(1, b.getType_id());
			s.pt.setString(2, b.getPro_name());
			s.pt.setInt(3, b.getPro_stock());
			s.pt.setFloat(4, b.getPro_price());
			s.pt.setFloat(5, b.getVip_price());
			s.pt.setString(6, b.getPro_specification());
			s.pt.setString(7, b.getPro_more());
			s.pt.setInt(8, b.getPromotion());
			s.pt.execute();
			s.close();
			sql="update type set count=count+1 where type_id=?";
			s.getPt(sql);
			s.pt.setInt(1, b.getType_id());
			s.pt.execute();
			s.close_all();				
			}
			catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
		public void edit_pro(Bean_production b) {
			
			Sql_c s=new Sql_c();
			String sql="update production set  "
					+ "pro_name=?,pro_stock=?,pro_price=?,pro_vip_price=?,pro_specification=?,pro_more=?,promotion=? "
					+ "where pro_id=?";
			try {
				s.getPt(sql);
				//s.pt.setInt(1, b.getType_id());
				s.pt.setString(1, b.getPro_name());
				s.pt.setInt(2, b.getPro_stock());
				s.pt.setFloat(3, b.getPro_price());
				s.pt.setFloat(4, b.getVip_price());
				s.pt.setString(5, b.getPro_specification());
				s.pt.setString(6, b.getPro_more());
				s.pt.setInt(7, b.getPromotion());
				s.pt.setInt(8, b.getPro_id());
				s.pt.execute();
				sql="update type set count=count-1 where type_id=?";
				s.getPt(sql);
				s.pt.setInt(1, b.getType_id());
				s.pt.execute();
				s.close_all();				
				}
				catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}		
		}
		public void delete_pro(Bean_production b) {
				Sql_c s=new Sql_c();
				String sql="update production set valid=0 where type_id=?";
				s.getPt(sql);
				try {
					s.pt.setInt(1, b.getType_id());
					s.pt.execute();
					
					s.close_all();
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				return;
			}
		 
			
}
