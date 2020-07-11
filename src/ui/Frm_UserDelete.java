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

public class Frm_UserDelete extends JDialog  implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField user_id;

	
	public Frm_UserDelete() {
		setTitle("\u6CE8\u9500\u6307\u5B9A\u7528\u6237");
		//super(f,s,c);
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,
				(int) (height - this.getHeight()) / 2);
		
		setBounds(100, 100, 293, 125);
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
			user_id.setBounds(83, 10, 139, 21);
			contentPanel.add(user_id);
			user_id.setColumns(10);
			
		}
		
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(10, 38, 235, 33);
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource()==this.okButton) {
			try {
				start.Online_Market_Util.user_Manager.delete_user(this.user_id.getText());
			}
			catch(Exception p) {
				JOptionPane.showMessageDialog(null, "未找到对应用户", "错误", JOptionPane.INFORMATION_MESSAGE);
				p.printStackTrace();
				return;
			}
			JOptionPane.showMessageDialog(null, "指定用户信息成功注销", "成功", JOptionPane.INFORMATION_MESSAGE);
			this.setVisible(false);
		}
		else if(e.getSource()==this.cancelButton) {
			this.setVisible(false);
		}
	}
}
