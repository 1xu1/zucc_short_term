package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Bean_user;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.awt.event.ActionEvent;
import start.Online_Market_Util;
import util.BusinessException;

public class Frm_UserEdit extends JDialog  implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField user_id;

	
	public Frm_UserEdit() {
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,
				(int) (height - this.getHeight()) / 2);
		setTitle("\u7F16\u8F91\u6307\u5B9A\u7528\u6237\u4FE1\u606F");
		//super(f,s,c);
		Bean_user b = start.Online_Market_Util.user_Manager.load_user_data();
		setBounds(100, 100, 450, 212);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("\u7528\u6237ID");
			lblNewLabel.setBounds(38, 13, 54, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			user_id = new JTextField();
			user_id.setBounds(180, 10, 139, 21);
			contentPanel.add(user_id);
			if(b.getName()!=null)
				user_id.setText(b.getName());
			user_id.setColumns(10);
			
		}
		
		name = new JTextField();
		name.setBounds(180, 44, 139, 21);
		contentPanel.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u59D3\u540D");
		lblNewLabel_1.setBounds(38, 45, 54, 18);
		contentPanel.add(lblNewLabel_1);
		
		vip_end_date = new JTextField();
		vip_end_date.setBounds(180, 75, 214, 21);
		contentPanel.add(vip_end_date);
		vip_end_date.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u7528\u6237VIP\u622A\u6B62\u65E5\u671F");
		lblNewLabel_2.setBounds(38, 78, 99, 15);
		contentPanel.add(lblNewLabel_2);
		
		JLabel label = new JLabel("\u7528\u6237\u5BC6\u7801");
		label.setBounds(38, 103, 54, 15);
		contentPanel.add(label);
		
		user_pwd = new JTextField();
		user_pwd.setBounds(180, 106, 214, 21);
		contentPanel.add(user_pwd);
		user_pwd.setColumns(10);
		
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(10, 137, 414, 33);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			
				okButton = new JButton("\u786E\u8BA4");
				okButton.addActionListener(this) ;
				
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				
				
					cancelButton = new JButton("\u53D6\u6D88");
					cancelButton.addActionListener(this) ;
					buttonPane.add(cancelButton);
					
	}
	private JButton okButton;
	private JButton cancelButton;
	private JTextField name;
	private JTextField vip_end_date;
	private JTextField user_pwd;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource()==this.okButton) {
			try {
				Bean_user b=new Bean_user();
				b.setUser_id(user_id.getText());
				b.setName(name.getText());
				b.setUser_pwd(user_pwd.getText());
				b.setVip_end_date(Timestamp.valueOf(vip_end_date.getText()));
				start.Online_Market_Util.user_Manager.edit_user(b);
			}
			catch(Exception p) {
				
				JOptionPane.showMessageDialog(null, "请检查输入信息是否有误", "错误", JOptionPane.ERROR_MESSAGE);
				return;
			}
			this.setVisible(false);
		}
		else if(e.getSource()==this.cancelButton) {
			this.setVisible(false);
		}
	}
}
