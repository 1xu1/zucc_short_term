package control;

import java.sql.SQLException;

import model.Bean_production;
import model.Bean_type;
import model.Bean_user;
import model.Sql_c;

public class ShopMenu_Manager {
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
}
