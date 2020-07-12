package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Bean_menu;
import model.Bean_menu_more;
import model.Bean_order_more;
import model.Sql_c;

public class Menu_Manager {
	public List<Bean_menu> load_menu(){
		List<Bean_menu> b = new ArrayList<Bean_menu>();
		Sql_c s=new Sql_c();
		String sql="select me_id,me_name,me_step,me_picture,me_usage from menu where valid=1";
		try {
			s.getPt(sql);
			s.rs=s.pt.executeQuery();		
			while(s.rs.next()) {
				Bean_menu bb=new Bean_menu();
				bb.setMe_id(s.rs.getInt(1));
				bb.setMe_name(s.rs.getString(2));
				bb.setMe_step(s.rs.getString(3));
				bb.setMe_picture(s.rs.getString(4));	
				bb.setMe_usage(s.rs.getString(5));
				b.add(bb);
			}
			s.close_all();
			return b;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	public void add_menu(Bean_menu b) {
		Sql_c s=new Sql_c();
		String sql="insert into menu(me_name,me_usage,me_step,me_picture)"
				+ " values(?,?,?,?)";
		try {
			s.getPt(sql);
			s.pt.setString(1, b.getMe_name());
			s.pt.setString(2, b.getMe_usage());
			s.pt.setString(3, b.getMe_step());
			s.pt.setString(4, b.getMe_picture());
			s.pt.execute();
			s.close_all();				
			}
			catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public void edit_menu(Bean_menu b) {
		Sql_c s=new Sql_c();
		
		String sql="update menu "
				+ "set me_name=?,me_usage=?,me_step=?,me_picture=? "
				+ " where me_id=?";
		try {
			s.getPt(sql);
			System.out.println(b.getMe_name());
			System.out.println(b.getMe_usage());
			System.out.println(b.getMe_step());
			System.out.println(b.getMe_picture());
			System.out.println(b.getMe_id());
			s.pt.execute();
			s.close_all();				
			}
			catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public void delete_menu(Bean_menu b) {
		Sql_c s=new Sql_c();
		
		String sql="update menu "
				+ "set valid=0 "
				+ " where me_id=?";
		try {
			s.getPt(sql);
			
			s.pt.setInt(1, b.getMe_id());
			s.pt.execute();
			s.close_all();				
			}
			catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public void add_menu_pro(Bean_menu b,int id,String des) {
		Sql_c s=new Sql_c();
		String sql="insert into me_recommend(me_id,pro_id,description)"
				+ " values(?,?,?)";
		try {
			s.getPt(sql);
			s.pt.setInt(1, b.getMe_id());
			s.pt.setInt(2, id);
			s.pt.setString(3, des);
			s.pt.execute();
			s.close_all();				
			}
			catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public List<String> load_menu_pro(Bean_menu b){
		List<String> result=new ArrayList<String>();
		Sql_c s=new Sql_c();
		String sql="select pro_name from menu_more where me_id=? ";
		try {
			s.getPt(sql);
			s.pt.setInt(1, b.getMe_id());
			s.rs=s.pt.executeQuery();		
			while(s.rs.next()) {
				result.add(s.rs.getString(1));
				
			}
			s.close_all();
			return result;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
