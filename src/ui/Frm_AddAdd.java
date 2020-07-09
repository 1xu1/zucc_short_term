package ui;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Bean_address;


import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Frm_AddAdd extends JDialog  implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField con_name;
	private JTextField con_phone;
	private JTextField province;
	private JTextField a_city;
	private JTextField area;
	private JTextField a_address;
	private Frm_Address f=null;
	
	public Frm_AddAdd(Frm_Address f) {
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,
				(int) (height - this.getHeight()) / 2);
		this.validate();
		this.f=f;
		setTitle("\u589E\u6DFB\u5730\u5740");
		setBounds(100, 100, 292, 270);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 274, 228);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("");
			label.setBounds(217, 10, 0, 0);
			contentPanel.add(label);
		}
		{
			JLabel lblNewLabel = new JLabel("\u8054\u7CFB\u4EBA\u540D");
			lblNewLabel.setBounds(27, 20, 54, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			con_name = new JTextField();
			con_name.setBounds(91, 17, 66, 21);
			contentPanel.add(con_name);
			con_name.setColumns(10);
		}
		{
			con_phone = new JTextField();
			con_phone.setBounds(91, 48, 66, 21);
			contentPanel.add(con_phone);
			con_phone.setColumns(10);
		}
		{
			province = new JTextField();
			province.setBounds(91, 79, 66, 21);
			contentPanel.add(province);
			province.setColumns(10);
		}
		{
			a_city = new JTextField();
			a_city.setBounds(91, 110, 66, 21);
			contentPanel.add(a_city);
			a_city.setColumns(10);
		}
		{
			area = new JTextField();
			area.setBounds(91, 141, 176, 21);
			contentPanel.add(area);
			area.setColumns(10);
		}
		{
			a_address = new JTextField();
			a_address.setBounds(91, 172, 176, 21);
			contentPanel.add(a_address);
			a_address.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("\u7535\u8BDD\u53F7\u7801");
			lblNewLabel_1.setBounds(27, 51, 54, 15);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("\u7701\u4EFD");
			lblNewLabel_2.setBounds(27, 82, 54, 15);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("\u57CE\u5E02");
			lblNewLabel_3.setBounds(27, 113, 54, 15);
			contentPanel.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("\u8857\u533A");
			lblNewLabel_4.setBounds(27, 144, 54, 15);
			contentPanel.add(lblNewLabel_4);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("\u8BE6\u7EC6\u5730\u5740");
			lblNewLabel_5.setBounds(27, 175, 54, 15);
			contentPanel.add(lblNewLabel_5);
		}
		
			okButton = new JButton("\u786E\u8BA4");
			okButton.setBounds(116, 203, 76, 23);
			contentPanel.add(okButton);
			okButton.addActionListener(this) ;
			
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
			
			
				cancelButton = new JButton("\u53D6\u6D88");
				cancelButton.setBounds(202, 203, 65, 23);
				contentPanel.add(cancelButton);
				cancelButton.addActionListener(this) ;
		JPanel buttonPane = new JPanel();
		buttonPane.setBounds(0, 263, 274, -44);
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(null);
	}
	private JButton okButton;
	private JButton cancelButton;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource()==this.okButton) {
			Bean_address b=new Bean_address();
			
			try {
			b.setCon_name(con_name.getText());
			b.setA_address(a_address.getText());
			b.setProvince(province.getText());
			b.setArea(area.getText());
			b.setCon_phone(con_phone.getText());
			b.setA_city(a_city.getText());
			}
			catch (Exception p){
				JOptionPane.showMessageDialog(null, "错误", "请检查输入格式", JOptionPane.ERROR_MESSAGE); 
				p.printStackTrace();
			}
			
			start.Online_Market_Util.address_Manager.add_address(b);
			JOptionPane.showMessageDialog(null, "成功", "成功增添地址", JOptionPane.INFORMATION_MESSAGE); 
			this.setVisible(false);
			//f.reload_add_table();
		}
		else if(e.getSource()==this.cancelButton) {
			this.setVisible(false);
		}
	}
}
