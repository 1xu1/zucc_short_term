package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Bean_order_more;
import model.Bean_production;
import model.Bean_type;
import model.Bean_u_order;
import model.Bean_user;
import model.Sql_c;

public class ShopMenu_Manager {
	public List<Bean_order_more> load_shop_menu(){
		List<Bean_order_more> b = new ArrayList<Bean_order_more>();
		Sql_c s=new Sql_c();
		String sql="select user_id,pro_name,pro_specification,quatity,state,shop_id,pro_id from pro_shop_more";
		try {
			s.getPt(sql);
			s.rs=s.pt.executeQuery();		
			while(s.rs.next()) {
				Bean_order_more bb=new Bean_order_more();
				bb.setUser_id(s.rs.getString(1));
				bb.setPro_name(s.rs.getString(2));
				bb.setPro_specification(s.rs.getString(3));
				bb.setPurchase_amout(s.rs.getInt(4));
				bb.setOrder_state(s.rs.getString(5));
				bb.setOrder_id(s.rs.getInt(6));
				bb.setPro_id(s.rs.getInt(7));
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
	public void add_stock(Bean_production b) {
		Sql_c s=new Sql_c();
		String sql="insert into pro_shop(user_id,pro_id,quatity,state)"
				+ " values(?,?,?,'已下单')";
		try {
			s.getPt(sql);
			s.pt.setString(1, Bean_user.currentLoginUser.getUser_id());
			s.pt.setInt(2, b.getPro_id());
			s.pt.setInt(3, b.getPro_purchase());
			s.pt.execute();
			s.close_all();				
			}
			catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public void edit_order(Bean_order_more order,String state) {
		
		Sql_c s=new Sql_c();
		String sql;
		try {			
			sql="select state "
					+ "from pro_shop"
					+ " where shop_id=? ";
			s.getPt(sql);
			s.pt.setInt(1, order.getOrder_id());
			s.rs=s.pt.executeQuery();
			s.rs.next();
			if(s.rs.getString(1).equals("已接收")) {
				JOptionPane.showMessageDialog(null, "已接收，不能再次接收", "错误", JOptionPane.ERROR_MESSAGE);
				return;
			}
			s.close();
			sql="update pro_shop set state=? "
					+ "where shop_id=? ";
			
			s.getPt(sql);
			s.pt.setString(1, state);
			s.pt.setInt(2,order.getOrder_id());
			s.pt.execute();
			s.close();
			sql="update production set pro_stock=pro_stock+? "
					+ "where pro_id=?";
			s.getPt(sql);
			s.pt.setInt(1, order.getPurchase_amout());
			s.pt.setInt(2, order.getPro_id());
			s.pt.execute();
			s.close_all();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return ;
	}
}
