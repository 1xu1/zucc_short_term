package control;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.*;

public class Comment_Manager {
	public void add_comment(Bean_order_more b,Bean_user user,String comment,int star) throws SQLException {
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
			throw e;
		}
	}
	public List<Bean_comment> load_comment(Bean_production curPro) {
		Sql_c s=new Sql_c();
		List<Bean_comment> result = new ArrayList<Bean_comment>();
		String sql="select name,cm_content,cm_star,cm_date,phrase_count,order_id from pro_comment"
				+ " where pro_id=?";
		s.getPt(sql);
		try {
			//插入评论
			s.getPt(sql);
			s.pt.setInt(1, curPro.getPro_id());
			s.rs=s.pt.executeQuery();
			while(s.rs.next()) {
				Bean_comment b=new Bean_comment();
				b.setName(s.rs.getString(1));
				b.setCm_content(s.rs.getString(2));
				b.setCm_star(s.rs.getInt(3));
				b.setCm_data(s.rs.getTimestamp(4));
				b.setPhrase_count(s.rs.getInt(5));
				b.setCm_id(s.rs.getInt(6));
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
	
}
