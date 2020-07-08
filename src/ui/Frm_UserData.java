package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Bean_user;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import start.Online_Market_Util;

public class Frm_UserData extends JDialog  implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField name;
	private JTextField phone;
	private JTextField mail;
	private JTextField city;

	
	public Frm_UserData(JFrame f,String s, Boolean c) {
		//super(f,s,c);
		Bean_user b = start.Online_Market_Util.user_Manager.load_user_data();
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("\u59D3\u540D");
			lblNewLabel.setBounds(38, 13, 54, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			name = new JTextField();
			name.setBounds(107, 10, 139, 21);
			contentPanel.add(name);
			if(b.getName()!=null)
				name.setText(b.getName());
			name.setColumns(10);
			
		}
		{
			JLabel lblNewLabel = new JLabel("\u7535\u8BDD\u53F7\u7801");
			lblNewLabel.setBounds(38, 46, 54, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			phone = new JTextField();
			phone.setColumns(10);
			phone.setBounds(107, 41, 139, 21);
			if(b.getPhone_number()!=null)
				phone.setText(b.getPhone_number());
			contentPanel.add(phone);
			
		}
		{
			JLabel lblNewLabel = new JLabel("\u7535\u5B50\u90AE\u7BB1");
			lblNewLabel.setBounds(38, 77, 54, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			mail = new JTextField();
			mail.setColumns(10);
			mail.setBounds(107, 74, 139, 21);
			if(b.getMail()!=null)
				mail.setText(b.getMail());
			contentPanel.add(mail);
			
		}
		{
			JLabel lblNewLabel = new JLabel("\u57CE\u5E02");
			lblNewLabel.setBounds(38, 108, 54, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			city = new JTextField();
			city.setColumns(10);
			city.setBounds(107, 105, 139, 21);
			if(b.getCity()!=null)
				city.setText(b.getCity());
			contentPanel.add(city);
			
		}
		
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource()==this.okButton) {
			Bean_user b=new Bean_user();
			
			b.setName(name.getText());
			b.setPhone_number(phone.getText());
			b.setMail(mail.getText());
			b.setCity(city.getText());
			b.setUser_id(Bean_user.currentLoginUser.getUser_id());
			
			start.Online_Market_Util.user_Manager.edit_user_data(b);
		}
		else if(e.getSource()==this.cancelButton) {
			this.setVisible(false);
		}
	}

}
