package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.*;

public class Address_Manager {
	public List<Bean_address> load_all_address(Bean_user user){
		List<Bean_address> b = new ArrayList<Bean_address>();
		
		Sql_c s=new Sql_c();
		String sql="select address_id,user_id,province,a_city,area,a_address,con_name,con_phone from address"
				+ " where user_id=? and valid=1";
		s.getPt(sql);
		try {
			s.pt.setString(1, user.getUser_id());
			s.rs=s.pt.executeQuery();
			while(s.rs.next()) {
				Bean_address bb=new Bean_address();
				bb.setAddress_id(s.rs.getInt(1));
				bb.setUser_id(s.rs.getString(2));
				bb.setProvince(s.rs.getString(3));
				bb.setA_city(s.rs.getString(4));
				bb.setArea(s.rs.getString(5));
				bb.setA_address(s.rs.getString(6));
				bb.setCon_name(s.rs.getString(7));
				bb.setCon_phone(s.rs.getString(8));
				
				b.add(bb);
			}
			s.close_all();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return b;
	}
	
	public void add_address(Bean_address b) {
		Sql_c s=new Sql_c();
		String sql="insert into address(user_id,province,a_city,area,a_address,con_name,con_phone)"
				+ " values(?,?,?,?,?,?,?)";
		try {
			s.getPt(sql);
			s.pt.setString(1, Bean_user.currentLoginUser.getUser_id());
			s.pt.setString(2, b.getProvince());
			s.pt.setString(3, b.getA_city());
			s.pt.setString(4, b.getArea());
			s.pt.setString(5, b.getA_address());
			s.pt.setString(6, b.getCon_name());
			s.pt.setString(7, b.getCon_phone());
			s.pt.execute();
			s.close_all();				
			}
			catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	
	public void edit_address(Bean_address bb) {
		Sql_c s=new Sql_c();
		Bean_address b=bb;
		
		
		String sql="update address set "
				+ "user_id=?,province=?,a_city=?,area=?,a_address=?,con_name=?,con_phone=? "
				+ "where address_id =? "
				;
		try {
			//System.out.print(s.conn.getAutoCommit());
			
			s.getPt(sql);
			s.pt.setString(1, Bean_user.currentLoginUser.getUser_id());
			s.pt.setString(2, b.getProvince());
			s.pt.setString(3, b.getA_city());
			s.pt.setString(4, b.getArea());
			s.pt.setString(5, b.getA_address());
			s.pt.setString(6, b.getCon_name());
			s.pt.setString(7, b.getCon_phone());
			s.pt.setInt(8, b.getAddress_id());
			
			
			s.pt.executeUpdate();
			//s.conn.commit();
			
			s.close_all();				
			}
			catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public void delete_address(Bean_address b) {
		Sql_c s=new Sql_c();
		String sql="update address set valid=0 where address_id=?";
		s.getPt(sql);
		try {
			s.pt.setInt(1, b.getAddress_id());
			s.pt.execute();
			
			s.close_all();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return;
	}
}
