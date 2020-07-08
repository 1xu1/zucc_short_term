package model;

import java.sql.*;

import util.DBUtil;

public class Sql_c {
	public java.sql.PreparedStatement pt;
	public java.sql.ResultSet rs;
	private Connection conn;
	
	public Sql_c() {
		try {
			conn=DBUtil.getConnection();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
	
	public java.sql.PreparedStatement getPt(String sql)  {
		try {
			pt=conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return pt;
	}
	public java.sql.PreparedStatement getPt()  {	
		
		return pt;
	}
	public java.sql.ResultSet getRs()  {
		try {
			
			return rs;
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public java.sql.ResultSet getRs(String sql)  {
		try {
			pt=conn.prepareStatement(sql);
			rs=pt.executeQuery();
			return rs;
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public void close() throws SQLException {
		if(pt!=null) {
			pt.close();
		}
		if(rs!=null)
			rs.close();
	}
	public void close_all() throws SQLException {	
		if(pt!=null) {
			pt.close();
		}
		if(rs!=null)
			rs.close();
		conn.close();
	}
}
