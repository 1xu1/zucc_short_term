package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
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

public class Frm_CouponAdd extends JDialog  implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField dis_content;
	private JTextField amout;
	private JTextField cut_amout;
	private JTextField discount;
	private JTextField start_date;
	private JTextField end_date;
	private JCheckBox meet_discount;
	private Frm_Index f=null;
	
	public Frm_CouponAdd() {
		setTitle("\u589E\u6DFB\u4F18\u60E0\u5238");
		setBounds(100, 100, 292, 379);
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
			JLabel lblNewLabel = new JLabel("\u4F18\u60E0\u5238\u5185\u5BB9");
			lblNewLabel.setBounds(21, 20, 60, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			dis_content = new JTextField();
			dis_content.setBounds(91, 17, 173, 21);
			contentPanel.add(dis_content);
			dis_content.setColumns(10);
		}
		{
			amout = new JTextField();
			amout.setBounds(91, 48, 66, 21);
			contentPanel.add(amout);
			amout.setColumns(10);
		}
		{
			cut_amout = new JTextField();
			cut_amout.setBounds(91, 79, 66, 21);
			contentPanel.add(cut_amout);
			cut_amout.setColumns(10);
		}
		{
			discount = new JTextField();
			discount.setBounds(91, 110, 66, 21);
			contentPanel.add(discount);
			discount.setColumns(10);
		}
		{
			start_date = new JTextField();
			start_date.setBounds(91, 141, 156, 21);
			contentPanel.add(start_date);
			start_date.setColumns(10);
		}
		{
			end_date = new JTextField();
			end_date.setBounds(91, 172, 156, 21);
			contentPanel.add(end_date);
			end_date.setColumns(10);
		}
		{
			JLabel dis_amout_label = new JLabel("\u8981\u6C42\u91D1\u989D");
			dis_amout_label.setBounds(27, 51, 54, 15);
			contentPanel.add(dis_amout_label);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("\u51CF\u514D\u91D1\u989D");
			lblNewLabel_2.setBounds(27, 82, 120, 15);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("\u6253\u6298\u529B\u5EA6");
			lblNewLabel_3.setBounds(27, 113, 54, 15);
			contentPanel.add(lblNewLabel_3);
		}
		{
			JLabel start_date_label = new JLabel("\u8D77\u59CB\u65E5\u671F");
			start_date_label.setBounds(27, 144, 54, 15);
			contentPanel.add(start_date_label);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("\u622A\u6B62\u65E5\u671F");
			lblNewLabel_5.setBounds(27, 175, 54, 15);
			contentPanel.add(lblNewLabel_5);
		}
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237id");
		lblNewLabel_1.setBounds(27, 200, 54, 15);
		contentPanel.add(lblNewLabel_1);
		
		user_id = new JTextField();
		user_id.setBounds(91, 197, 66, 21);
		contentPanel.add(user_id);
		user_id.setColumns(10);
		JPanel buttonPane = new JPanel();
		buttonPane.setBounds(0, 263, 274, -44);
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(null);
			
				okButton = new JButton("\u786E\u8BA4");
				okButton.setBounds(123, 307, 76, 23);
				getContentPane().add(okButton);
				okButton.addActionListener(this) ;
				
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
			
			
				cancelButton = new JButton("\u53D6\u6D88");
				cancelButton.setBounds(209, 307, 65, 23);
				getContentPane().add(cancelButton);
				{
					JLabel lblNewLabel_6 = new JLabel("\u6EE1\u6298");
					lblNewLabel_6.setBounds(31, 238, 31, 15);
					getContentPane().add(lblNewLabel_6);
				}
				{
					meet_discount = new JCheckBox("");
					meet_discount.setBounds(68, 234, 49, 23);
					getContentPane().add(meet_discount);
				}
				{
					lblNewLabel_4 = new JLabel("\u65E5\u671F\u683C\u5F0F\uFF08YYYY-MM-DD HH:MM:SS\uFF09");
					lblNewLabel_4.setBounds(31, 263, 223, 34);
					getContentPane().add(lblNewLabel_4);
				}
				cancelButton.addActionListener(this) ;
				double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
				double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
				this.setLocation((int) (width - this.getWidth()) / 2,
						(int) (height - this.getHeight()) / 2);
	}
	private JButton okButton;
	private JButton cancelButton;
	public Bean_type type;
	private JTextField user_id;
	private JLabel lblNewLabel_4;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource()==this.okButton) {
			try {
				if(this.meet_discount.isSelected()) {
					Bean_meet_discount b=new Bean_meet_discount();
					b.setMd_amout(Double.valueOf(this.amout.getText()));
					b.setMd_content(this.dis_content.getText());
					if(Double.valueOf(this.discount.getText())>1){
						JOptionPane.showMessageDialog(null, "折扣数值不得大于1", "错误", JOptionPane.ERROR_MESSAGE);
						return;
					}
					b.setDiscount(Double.valueOf(this.discount.getText()));
					b.setStart_date(Timestamp.valueOf(this.start_date.getText()));
					b.setEnd_date(Timestamp.valueOf(this.end_date.getText()));
					start.Online_Market_Util.discount_Manager.add_coupon(this.user_id.getText(), b);
					
				}
				else {
					Bean_discount_coupon b=new Bean_discount_coupon();
					b.setDis_amout(Double.valueOf(this.amout.getText()));
					b.setDis_content(this.dis_content.getText());
					b.setCut_amout(Double.valueOf(this.cut_amout.getText()));
					b.setStart_date(Timestamp.valueOf(this.start_date.getText()));
					b.setEnd_date(Timestamp.valueOf(this.end_date.getText()));
					start.Online_Market_Util.discount_Manager.add_coupon(this.user_id.getText(), b);
					
				}
			}
			catch(Exception p) {
				JOptionPane.showMessageDialog(null, "请重新检查输入格式", "错误", JOptionPane.ERROR_MESSAGE);
				return;
			}
			JOptionPane.showMessageDialog(null, "成功添加优惠券", "成功", JOptionPane.INFORMATION_MESSAGE);
			this.setVisible(false);
		}
		else if(e.getSource()==this.cancelButton) {
			this.setVisible(false);
		}
			
			
			
		else if(e.getSource()==this.cancelButton) {
			this.setVisible(false);
		}
	}
}
