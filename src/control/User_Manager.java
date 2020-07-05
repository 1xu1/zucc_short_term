package control;
import start.Online_Market_Util;
import java.sql.*;

import javax.swing.JOptionPane;

import control.*;
import model.*;
import ui.*;
import util.*;
public class User_Manager {
	public Bean_user reg(String userid, String pwd,String pwd2,int manager) throws BaseException {
		Sql_c s = new Sql_c();
		String sql;
		Bean_user b=new Bean_user();
		
		if(userid.equals("")||pwd.equals("")||pwd2.equals(""))
			throw new BusinessException("输入不能为空");
		if(!pwd.equals(pwd2))
			throw new BusinessException("两次密码输入不一致");
		try {	
			sql="select 1 from user where user_id = ?";			
			//执行代码
			s.getPt(sql);
			s.pt.setString(1,userid);
			if((s.rs=s.pt.executeQuery()).next()) {
				if(s.rs.getInt(1)==1);
					throw new BusinessException("有重复的用户名，请重新输入");
			}
			s.close();
			sql="insert into user (user_id,user_pwd,manager,register_time) values(?,?,?,now())";
			s.getPt(sql);
			s.getPt().setString(1, userid);
			s.getPt().setString(2, pwd);
			s.getPt().setInt(3, manager);
			s.getPt().execute();
			s.close_all();
			JOptionPane.showMessageDialog(null, "欢迎徐宇翔生鲜市场新成员:"+userid, "注册成功", JOptionPane.OK_OPTION);
			return b;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally{
			
		}
		return null;
	}

	
	//@Override
	public Bean_user login(String userid, String pwd) throws BaseException {
		// TODO Auto-generated method stub
		Sql_c s = new Sql_c();
		String sql;
		Bean_user b=new Bean_user();
		int t=0;
		if(userid.equals("")||pwd.equals(""))		
			throw new BusinessException("输入不能为空");
		
		try {	
			sql="select user_id,user_pwd,manager from user";			
			//执行代码
			s.getRs(sql);
			while(s.getRs().next()) {
				if(userid.equals(s.getRs().getString(1))) {
					t++;
					if(pwd.equals(s.getRs().getString(2)))
						JOptionPane.showMessageDialog(null, "欢迎进入徐宇翔生鲜市场", "登录成功", JOptionPane.INFORMATION_MESSAGE);
						b.setUser_id(userid);
						b.setManager(s.rs.getInt(3));
						return b;
				}
					
			}			
			s.close_all();
			if(t==0)
				JOptionPane.showMessageDialog(null, "请核对用户名正确与否", "登录错误", JOptionPane.ERROR_MESSAGE);
			else
				JOptionPane.showMessageDialog(null, "请核对密码正确与否", "登录错误", JOptionPane.ERROR_MESSAGE);
			return b;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally{
			
		}
		return null;
	}


	//@Override
	public void changePwd(Bean_user user, String oldPwd, String newPwd,
			String newPwd2) throws BaseException {
		// TODO Auto-generated method stub
		if(user.equals("")||oldPwd.equals("")||newPwd.equals("")||newPwd2.equals(""))
			throw new BusinessException("输入不能为空");
		Sql_c s = new Sql_c();
		String sql;
		Bean_user b=new Bean_user();
		
		try {
			sql="select user_pwd from user where user_id=?";
			s.getPt(sql);
			s.pt.setString(1, user.getUser_id());
			s.rs=s.pt.executeQuery();
			if(s.rs.next()) {
				if(!s.rs.getString(1).equals(newPwd))
					throw new BusinessException("密码错误");
			}
				
			s.close();
			
			sql="update user set user_pwd =? where user_id=?";
			s.getPt(sql);
			s.getPt().setString(1, newPwd);
			s.pt.setString(2, user.getUser_id());
			s.pt.execute();
			s.close_all();
			JOptionPane.showMessageDialog(null, "密码修改成功", "成功", JOptionPane.INFORMATION_MESSAGE);
			
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		
	}
	public void edit_user_data(Bean_user b) {
		Sql_c s=new Sql_c();
		String sql="update user set name=?, phone_number=?, mail=?, city=? where user_id = ?";
		s.getPt(sql);
		try {
			s.pt.setString(1, b.getName());
			s.pt.setString(2, b.getPhone_number());
			s.pt.setString(3, b.getMail());
			s.pt.setString(4, b.getCity());
			s.pt.setString(5, b.getUser_id());
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "个人信息成功修改", "成功", JOptionPane.INFORMATION_MESSAGE);
	}
}
