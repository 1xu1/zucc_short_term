package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Image;
import javax.swing.ImageIcon;
import model.Bean_menu;

import javax.swing.JTextArea;
import javax.swing.JLabel;

public class Frm_MenuMore extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private List<String> pro=null;
	private JTextArea menu_name;
	private JTextArea menu_step;
	private JTextArea menu_usage;
	private JTextArea menu_pro;
	private JLabel lblNewLabel_1;
	public Frm_MenuMore(Bean_menu curMenu) {
		setTitle("\u83DC\u8C31\u8BE6\u7EC6\u4FE1\u606F");
		
		
		
		setBounds(100, 100, 450, 357);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
			
			menu_name = new JTextArea();
			menu_name.setText("\u83DC\u8C31\u540D\u79F0\uFF1A"+curMenu.getMe_name());
			menu_name.setBounds(10, 10, 300, 24);
			contentPanel.add(menu_name);
		
		
			
			menu_step = new JTextArea();
			menu_step.setText("\u5236\u4F5C\u6B65\u9AA4\uFF1A"+curMenu.getMe_step());
			menu_step.setBounds(10, 38, 300, 24);
			contentPanel.add(menu_step);
		
		
			
			menu_usage = new JTextArea();
			menu_usage.setText("\u7528\u6750\uFF1A"+curMenu.getMe_usage());
			menu_usage.setBounds(10, 72, 331, 24);
			contentPanel.add(menu_usage);
		
			pro=start.Online_Market_Util.menu_manager.load_menu_pro(curMenu);
			String pro_list="";
			for(int i=0;i<pro.size();i++) {
				if(i!=pro.size()-1)
					pro_list+=(pro.get(i)+", ");
				else pro_list+=pro.get(i);
			}
			
			menu_pro = new JTextArea();
			menu_pro.setText("\u5173\u8054\u4EA7\u54C1\uFF1A"+pro_list);
			menu_pro.setBounds(10, 100, 347, 24);
			contentPanel.add(menu_pro);
			
			
			
			//JLabel lblNewLabel = new JLabel("New label");
			
		
		if(curMenu.getMe_picture()!=null) {
			ImageIcon  picture = new ImageIcon(curMenu.getMe_picture());// ͼƬ
			
			JLabel lblNewLabel = new JLabel(picture);
			lblNewLabel.setBounds(10, 134, 414, 174);
			contentPanel.add(lblNewLabel);
		}
		
	}

}
