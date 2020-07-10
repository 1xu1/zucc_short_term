package ui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;

import model.Bean_user;
import start.*;
public class Frm_UserData_Display extends JDialog {

	
	public Frm_UserData_Display() {
		setTitle("\u7528\u6237\u8D44\u6599");
		Bean_user b = start.Online_Market_Util.user_Manager.load_user_data();
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new MigLayout("", "[][][][]", "[][][][][][][][]"));
		
		JLabel lblid = new JLabel("\u7528\u6237ID\uFF1A");
		getContentPane().add(lblid, "cell 1 1");
		
		JLabel user_id = new JLabel("\u6682\u65E0\u8BE5\u4FE1\u606F");
		getContentPane().add(user_id, "cell 3 1");
		
		JLabel label = new JLabel("\u7528\u6237\u59D3\u540D\uFF1A");
		getContentPane().add(label, "cell 1 2");
		
		JLabel user_name = new JLabel("\u6682\u65E0\u8BE5\u4FE1\u606F");
		getContentPane().add(user_name, "cell 3 2");
		
		JLabel label_4 = new JLabel("\u7528\u6237\u6CE8\u518C\u65F6\u95F4");
		getContentPane().add(label_4, "cell 1 3");
		
		JLabel user_time = new JLabel("\u6682\u65E0\u8BE5\u4FE1\u606F");
		getContentPane().add(user_time, "cell 3 3");
		
		JLabel label_1 = new JLabel("\u7528\u6237\u6240\u5728\u57CE\u5E02\uFF1A");
		getContentPane().add(label_1, "cell 1 4");
		
		JLabel user_city = new JLabel("\u6682\u65E0\u8BE5\u4FE1\u606F");
		getContentPane().add(user_city, "cell 3 4");
		
		JLabel label_2 = new JLabel("\u7528\u6237\u7535\u8BDD\u53F7\u7801");
		getContentPane().add(label_2, "cell 1 5");
		
		JLabel user_phone = new JLabel("\u6682\u65E0\u8BE5\u4FE1\u606F");
		getContentPane().add(user_phone, "cell 3 5");
		
		JLabel label_3 = new JLabel("\u7528\u6237\u90AE\u7BB1\uFF1A");
		getContentPane().add(label_3, "cell 1 6");
		
		JLabel user_mail = new JLabel("\u6682\u65E0\u8BE5\u4FE1\u606F");
		getContentPane().add(user_mail, "cell 3 6");
		
		JLabel lblVip = new JLabel("VIP½ØÖ¹ÈÕÆÚ");
		getContentPane().add(lblVip, "cell 1 7");
		
		JLabel user_vip = new JLabel("\u6682\u65E0\u8BE5\u4FE1\u606F");
		getContentPane().add(user_vip, "cell 3 7");
		
		user_id.setText(b.getUser_id());
		user_time.setText(b.getRegister_time().toString());
		if(b.getName()!=null) {
			user_name.setText(b.getName());
		}
	
		if(b.getCity()!=null) {
			user_city.setText(b.getCity());
		}
		
		if(b.getPhone_number()!=null) {
			user_phone.setText(b.getPhone_number());
		}
		
		if(b.getMail()!=null) {
			user_mail.setText(b.getMail());
		}
		
		if(b.getVip_end_date()!=null) {
			user_vip.setText(b.getVip_end_date().toString());
		}
		
		
	}

}
