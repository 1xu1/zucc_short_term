package ui;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Bean_user;
import util.BaseException;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class Frm_ChangePwd  extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JPasswordField new_pwd;
	private JPasswordField old_pwd;
	private JPasswordField new_pwd2;
	private JButton okButton = new JButton("\u786E\u8BA4");
	private JButton cancelButton = new JButton("\u53D6\u6D88");

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public Frm_ChangePwd(JFrame f, String s, boolean b) {
		super(f, s, b);
		setTitle("\u4FEE\u6539\u5BC6\u7801");
		setBounds(100, 100, 362, 205);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u539F\u5BC6\u7801");
		lblNewLabel.setBounds(10, 34, 54, 15);
		contentPanel.add(lblNewLabel);
		
		JLabel new_p = new JLabel("\u65B0\u5BC6\u7801");
		new_p.setBounds(10, 65, 54, 15);
		contentPanel.add(new_p);
		
		JLabel label = new JLabel("\u786E\u8BA4\u5BC6\u7801");
		label.setBounds(10, 96, 54, 15);
		contentPanel.add(label);
		
		new_pwd = new JPasswordField();
		new_pwd.setBounds(88, 62, 121, 21);
		contentPanel.add(new_pwd);
		
		old_pwd = new JPasswordField();
		old_pwd.setBounds(88, 31, 121, 21);
		contentPanel.add(old_pwd);
		
		new_pwd2 = new JPasswordField();
		new_pwd2.setBounds(88, 93, 121, 21);
		contentPanel.add(new_pwd2);
		
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
				
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			
			
				
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			
			this.cancelButton.addActionListener(this);
			this.okButton.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.cancelButton)
			this.setVisible(false);
		else if(e.getSource()==this.okButton){
			String pwd=new String (this.old_pwd.getPassword());
			String pwd1=new String(this.new_pwd.getPassword());
			String pwd2=new String(this.new_pwd2.getPassword());
			try {
				start.Online_Market_Util.user_Manager.changePwd(Bean_user.currentLoginUser,pwd,pwd1,pwd2);
			} catch (BaseException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
				
			}
				this.setVisible(false);
			} 
			
		}
}
