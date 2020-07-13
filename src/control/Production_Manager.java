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
				//System.out.print(bb.getType_id());
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
		String sql="select pro_name,pro_price,pro_vip_price,pro_specification,pro_stock,pro_more,pro_id from production where type_id=? "
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
	
	//根据用户推荐商品
	public List<Bean_production> load_pro(Bean_user user){
		List<Bean_production> b = new ArrayList<Bean_production>();
		Bean_production bb=null;
		List<Integer> id=new ArrayList<Integer>();
		Sql_c s=new Sql_c();
		String sql="select pro_id from pro_sold order by pro_sold desc";
		try {
			s.getRs(sql);
			while(s.rs.next()) {
				int t=s.rs.getInt(1);
				id.add(t);
			}
			s.close();
			for(int i=0;i<id.size();i++) {
				b.add(load_pro(id.get(i)));
			}
			s.close_all();
			return b;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return b;
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
		String sql="insert into production(type_id,pro_name,pro_stock,pro_price,pro_vip_price,pro_specification,pro_more)"
				+ " values(?,?,?,?,?,?,?)";
		try {
			s.getPt(sql);
			s.pt.setInt(1, b.getType_id());
			s.pt.setString(2, b.getPro_name());
			s.pt.setInt(3, b.getPro_stock());
			s.pt.setFloat(4, b.getPro_price());
			s.pt.setFloat(5, b.getVip_price());
			s.pt.setString(6, b.getPro_specification());
			s.pt.setString(7, b.getPro_more());
			
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
					+ "pro_name=?,pro_stock=?,pro_price=?,pro_vip_price=?,pro_specification=?,pro_more=? "
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
				s.pt.setInt(7, b.getPro_id());
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
				String sql="update production set valid=0 where pro_id=?";
				s.getPt(sql);
				try {
					s.pt.setInt(1, b.getPro_id());
					s.pt.execute();
					sql="update type set count=count-1 where type_id=?";
					s.getPt(sql);
					s.pt.setInt(1, b.getType_id());
					s.pt.execute();
					sql="update type set count=count-1 where type_id=?";
					s.getPt(sql);
					s.pt.setInt(1, b.getType_id());
					s.pt.execute();
					s.close_all();
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				return;
			}
		public List<Bean_production> load_pr() {
			List<Bean_production> result = new ArrayList<Bean_production>();
			Sql_c s=new Sql_c();
			String sql="select pro_name,pro_price,pro_specification,pr_quatity,start_date,end_date,pr_id,pro_more,pr_price from pro_promotion ";
			try {
				s.getRs(sql);
				while(s.rs.next()) {
					Bean_production b=new Bean_production();
					b.setPro_name(s.rs.getString(1));
					b.setPro_price(s.rs.getFloat(2));
					b.setPro_specification(s.rs.getString(3));
					b.setPro_stock(s.rs.getInt(4));
					b.setStart_date(s.rs.getTimestamp(5));
					b.setEnd_date(s.rs.getTimestamp(6));
					b.setPr_id(s.rs.getInt(7));
					b.setPro_more(s.rs.getString(8));
					b.setVip_price(s.rs.getFloat(9));
					b.setPromotion(1);
					result.add(b);
				}
				s.close_all();				
				}
				catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			return result;
		}
		public void add_pr(Bean_production b,Bean_promotion pr) {
			
			Sql_c s=new Sql_c();
			String sql="insert into promotion(pro_id,pr_price,pr_quatity,start_date,end_date)"
					+ " values(?,?,?,?,?)";
			try {
				s.getPt(sql);
				s.pt.setInt(1, b.getPro_id());
				s.pt.setFloat(2, pr.getPr_price());
				s.pt.setInt(3, pr.getPr_quatity());
				s.pt.setTimestamp(4, pr.getStart_date());
				s.pt.setTimestamp(5, pr.getEnd_date());
				s.pt.execute();
				s.close_all();				
				}
				catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		public void delete_pr (Bean_production pr) {
			
			Sql_c s=new Sql_c();
			String sql="update promotion "
					+ " set valid=0 "
					+ " where pr_id=?";
			try {
				s.getPt(sql);
				s.pt.setInt(1, pr.getPr_id());
				
				s.pt.execute();
				s.close_all();				
				}
				catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
				
			}
		}
		 
			
}
