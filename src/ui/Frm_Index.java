package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Bean_user;

import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frm_Index extends JFrame implements ActionListener{

	
	
	public Frm_Index() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 506);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u4E2A\u4EBA\u4E2D\u5FC3");
		menuBar.add(menu);
		
		change_pwd = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		menu.add(change_pwd);
		change_pwd.addActionListener(this);
		
		edit_user_date = new JMenuItem("\u4FEE\u6539\u4E2A\u4EBA\u8D44\u6599");
		menu.add(edit_user_date);
		edit_user_date.addActionListener(this);
		load_user_data = new JMenuItem("\u67E5\u770B\u4E2A\u4EBA\u8D44\u6599");
		menu.add(load_user_data);
		load_user_data.addActionListener(this);
		load_comsumer = new JMenuItem("\u67E5\u770B\u4E2A\u4EBA\u4F18\u60E0");
		menu.add(load_comsumer);
		load_comsumer.addActionListener(this);
		shop_menu = new JMenuItem("\u67E5\u770B\u8D2D\u7269\u8F66");
		menu.add(shop_menu);
		shop_menu.addActionListener(this);
		load_order = new JMenuItem("\u67E5\u770B\u8BA2\u5355");
		menu.add(load_order);
		load_order.addActionListener(this);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(176, 94, 390, 43);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u641C\u7D22");
		button.setBounds(570, 94, 57, 43);
		contentPane.add(button);
		
		JLabel label = new JLabel("\u8F93\u5165\u67E5\u8BE2\u751F\u9C9C\u540D");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setBounds(176, 46, 390, 38);
		contentPane.add(label);
		
		//if(Bean_user.currentLoginUser.getName()==null||Bean_user.currentLoginUser.getName())
		//JLabel lblNewLabel = new JLabel(Bean_user.currentLoginUser.getName());
		//lblNewLabel.setBounds(10, 421, 54, 15);
		//contentPane.add(lblNewLabel);
	}
	private JPanel contentPane;
	private JTextField textField;
	private JMenuItem change_pwd;
	private JMenuItem edit_user_date;
	private JMenuItem load_user_data;
	private JMenuItem load_comsumer;
	private JMenuItem shop_menu;
	private JMenuItem load_order;
	
	private Frm_ChangePwd dlgChangePwd =null;
	private Frm_UserData dlgUserData=null;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource()==this.change_pwd) {
			dlgChangePwd=new Frm_ChangePwd(this,"修改密码",true);
			dlgChangePwd.setVisible(true);
		}
		if(e.getSource()==this.edit_user_date) {
			dlgUserData=new Frm_UserData(this,"个人信息修改",true);
			dlgUserData.setVisible(true);
		}
	}
}
