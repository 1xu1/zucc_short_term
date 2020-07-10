package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Bean_discount_coupon;
import model.Bean_meet_discount;
import model.Bean_production;
import model.Bean_type;
import model.Bean_user;
import util.BusinessException;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

public class Frm_CouponDelete extends JDialog  implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField id;
	private Frm_Index f=null;
	
	public Frm_CouponDelete() {
		setTitle("\u64A4\u9500\u4F18\u60E0\u5238");
		setBounds(100, 100, 292, 147);
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
			JLabel lblNewLabel = new JLabel("\u4F18\u60E0\u5238id");
			lblNewLabel.setBounds(21, 20, 60, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			id = new JTextField();
			id.setBounds(91, 17, 173, 21);
			contentPanel.add(id);
			id.setColumns(10);
		}
		
			okButton = new JButton("\u786E\u8BA4");
			okButton.setBounds(111, 79, 76, 23);
			contentPanel.add(okButton);
			okButton.addActionListener(this) ;
			
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
			
			
				cancelButton = new JButton("\u53D6\u6D88");
				cancelButton.setBounds(197, 79, 65, 23);
				contentPanel.add(cancelButton);
				
				meet_discount = new JCheckBox("\u6EE1\u6298\u5238");
				meet_discount.setBounds(21, 50, 103, 23);
				contentPanel.add(meet_discount);
				cancelButton.addActionListener(this) ;
		JPanel buttonPane = new JPanel();
		buttonPane.setBounds(0, 263, 274, -44);
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(null);
	}
	private JButton okButton;
	private JButton cancelButton;
	public Bean_type type;
	private JCheckBox meet_discount;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource()==this.okButton) {
			try {
			if(this.meet_discount.isSelected()) {
				Bean_meet_discount b=new Bean_meet_discount();
				b.setMd_id(Integer.valueOf(this.id.getText()));
				start.Online_Market_Util.discount_Manager.delete_coupon(b);
				Integer.valueOf(this.id.getText());
			}
			else {
				Bean_discount_coupon b=new Bean_discount_coupon();
				b.setDis_id(Integer.valueOf(this.id.getText()));
				start.Online_Market_Util.discount_Manager.delete_coupon(b);
				Integer.valueOf(this.id.getText());
			}
			}
			catch(Exception p) {
				JOptionPane.showMessageDialog(null, "请重新检查输入格式", "错误", JOptionPane.ERROR_MESSAGE);
				return;
			}
			JOptionPane.showMessageDialog(null, "成功撤销优惠券", "成功", JOptionPane.INFORMATION_MESSAGE);
			this.setVisible(false);
		}
										
		else if(e.getSource()==this.cancelButton) {
			this.setVisible(false);
		}
	}
}
