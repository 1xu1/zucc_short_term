package control;
import start.Online_Market_Util;
import java.sql.*;
import java.util.Calendar;

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
			sql="insert into user (user_id,user_pwd,manager,register_time,VIP,name) values(?,?,?,now(),0,?)";
			s.getPt(sql);
			s.getPt().setString(1, userid);
			s.getPt().setString(2, pwd);
			s.getPt().setInt(3, manager);
			s.pt.setString(4,userid );
			s.getPt().execute();
			s.close_all();
			JOptionPane.showMessageDialog(null, "��ӭ�����������г��³�Ա:"+userid, "ע��ɹ�", JOptionPane.INFORMATION_MESSAGE);
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
		Bean_user b=null;
		int t=0;
		int valid=1;
		if(userid.equals("")||pwd.equals(""))		
			throw new BusinessException("���벻��Ϊ��");
		
		try {	
			sql="select user_id,user_pwd,valid from user";			
			//ִ�д���
			s.getRs(sql);
			while(s.getRs().next()) {
				if(userid.equals(s.getRs().getString(1))) {
					t++;
					 
					if(pwd.equals(s.getRs().getString(2))) {
						if(s.rs.getInt(3)==1) {
							b=new Bean_user();
							b.setUser_id(s.rs.getString(1));
							return b;
						}	
						else
							valid=0;
					}
					
				}						
			}	
			if(valid==0)
				JOptionPane.showMessageDialog(null, "���û��Ѿ���ע��", "��¼����", JOptionPane.ERROR_MESSAGE);
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
		return b;
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
			s.pt.execute();
			
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "������Ϣ�ɹ��޸�", "�ɹ�", JOptionPane.INFORMATION_MESSAGE);
	}
	public void edit_user(Bean_user b) {
		Sql_c s=new Sql_c();
		String sql="update user set name=?, user_pwd=?, vip_end_date=? where user_id = ?";
		s.getPt(sql);
		try {
			s.pt.setString(1, b.getName());
			s.pt.setString(2, b.getUser_pwd());
			s.pt.setTimestamp(3, b.getVip_end_date());
			s.pt.setString(4, b.getUser_id());
			s.pt.execute();
			
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "������Ϣ�ɹ��޸�", "�ɹ�", JOptionPane.INFORMATION_MESSAGE);
	}
	public Bean_user load_user_data() {
		Bean_user b=new Bean_user();
		Sql_c s=new Sql_c();
		String sql="select user_id,register_time,manager,name,phone_number,mail,city,VIP,vip_end_date "
				+ "from user "
				+ "where user_id=?";
		s.getPt(sql);
		try {
			s.pt.setString(1, Bean_user.currentLoginUser.getUser_id());
			s.rs=s.pt.executeQuery();
			s.rs.next();
			b.setUser_id(s.rs.getString(1));
			b.setRegister_time(s.rs.getTimestamp(2));
			b.setManager(s.rs.getInt(3));
			b.setName(s.rs.getString(4));
			b.setPhone_number(s.rs.getString(5));
			b.setMail(s.rs.getString(6));
			b.setCity(s.rs.getString(7));
			b.setVip(s.rs.getInt(8));
			b.setVip_end_date(s.rs.getTimestamp(9));
			Bean_user.currentLoginUser=b;
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return b;
	}
	public void add_vip(Bean_user b) {
		if(b.getVip_end_date()!=null) {
			long vip_date=b.getVip_end_date().getTime();
			if(vip_date<System.currentTimeMillis()) {
				JOptionPane.showMessageDialog(null, "���Ѿ���VIP��Ա�ˣ�", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
		}
		if(b.getVip()==1) {
			JOptionPane.showMessageDialog(null, "���Ѿ����ù�VIP��Ա�ˣ��޷��ظ���ȡ", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		Sql_c s=new Sql_c();
		String sql="update user set vip=1,set vip_end_date=? where user_id = ?";
		s.getPt(sql);
		try {
			Timestamp vip_end_date= new Timestamp(System.currentTimeMillis()+3600*24*7);
			s.pt.setTimestamp(1, vip_end_date);
			s.pt.setString(2, b.getUser_id());
			s.pt.execute();
			
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		b.setVip(1);
		JOptionPane.showMessageDialog(null, "��ӭ�µ�VIP��Ա��"+b.getName()+"��������7�죩", "�ɹ�", JOptionPane.INFORMATION_MESSAGE);
	}
}
