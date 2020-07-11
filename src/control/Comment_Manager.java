package control;

import java.sql.SQLException;
import java.sql.Timestamp;

import model.*;

public class Comment_Manager {
	public void add_comment(Bean_order_more b,Bean_user user,String comment,int star) {
		Sql_c s=new Sql_c();
		String sql="insert into comment (user_id,user_name,pro_id,order_id,cm_star,cm_content,cm_date) "
				+ "values (?,?,?,?,?,?,now())";
		s.getPt(sql);
		try {
			//插入评论
			s.pt.setString(1,user.getUser_id() );
			s.pt.setString(2, user.getName());
			s.pt.setInt(3, b.getPro_id());
			s.pt.setInt(4, b.getOrder_id());
			s.pt.setInt(5, star);
			s.pt.setString(6, comment);		
			s.pt.execute();
			s.close_all();
			}
		 catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
