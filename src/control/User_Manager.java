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
			throw new BusinessException("���벻��Ϊ��");
		if(!pwd.equals(pwd2))
			throw new BusinessException("�����������벻һ��");
		try {	
			sql="select 1 from user where user_id = ?";			
			//ִ�д���
			s.getPt(sql);
			s.pt.setString(1,userid);
			if((s.rs=s.pt.executeQuery()).next()) {
				if(s.rs.getInt(1)==1);
					throw new BusinessException("���ظ����û���������������");
			}
			s.close();
			sql="insert into user (user_id,user_pwd,manager,register_time) values(?,?,?,now())";
			s.getPt(sql);
			s.getPt().setString(1, userid);
			s.getPt().setString(2, pwd);
			s.getPt().setInt(3, manager);
			s.getPt().execute();
			s.close_all();
			JOptionPane.showMessageDialog(null, "��ӭ�����������г��³�Ա:"+userid, "ע��ɹ�", JOptionPane.OK_OPTION);
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
			throw new BusinessException("���벻��Ϊ��");
		
		try {	
			sql="select user_id,user_pwd,manager from user";			
			//ִ�д���
			s.getRs(sql);
			while(s.getRs().next()) {
				if(userid.equals(s.getRs().getString(1))) {
					t++;
					if(pwd.equals(s.getRs().getString(2)))
						JOptionPane.showMessageDialog(null, "��ӭ���������������г�", "��¼�ɹ�", JOptionPane.INFORMATION_MESSAGE);
						b.setUser_id(userid);
						b.setManager(s.rs.getInt(3));
						return b;
				}
					
			}			
			s.close_all();
			if(t==0)
				JOptionPane.showMessageDialog(null, "��˶��û�����ȷ���", "��¼����", JOptionPane.ERROR_MESSAGE);
			else
				JOptionPane.showMessageDialog(null, "��˶�������ȷ���", "��¼����", JOptionPane.ERROR_MESSAGE);
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
			throw new BusinessException("���벻��Ϊ��");
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
					throw new BusinessException("�������");
			}
				
			s.close();
			
			sql="update user set user_pwd =? where user_id=?";
			s.getPt(sql);
			s.getPt().setString(1, newPwd);
			s.pt.setString(2, user.getUser_id());
			s.pt.execute();
			s.close_all();
			JOptionPane.showMessageDialog(null, "�����޸ĳɹ�", "�ɹ�", JOptionPane.INFORMATION_MESSAGE);
			
			
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "������Ϣ�ɹ��޸�", "�ɹ�", JOptionPane.INFORMATION_MESSAGE);
	}
}
