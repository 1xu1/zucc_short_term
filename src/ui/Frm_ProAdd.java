package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Bean_production;
import model.Bean_type;
import model.Bean_user;
import util.BusinessException;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

public class Frm_ProAdd extends JDialog  implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField pro_name;
	private JTextField pro_stock;
	private JTextField pro_price;
	private JTextField pro_vip_price;
	private JTextField pro_spe;
	private JTextField pro_more;
	private JCheckBox promotion;
	private Frm_Index f=null;
	
	public Frm_ProAdd(Frm_Index f) {
		this.f=f;
		setTitle("\u589E\u6DFB\u4EA7\u54C1");
		setBounds(100, 100, 292, 309);
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
			JLabel lblNewLabel = new JLabel("\u4EA7\u54C1\u540D");
			lblNewLabel.setBounds(27, 20, 54, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			pro_name = new JTextField();
			pro_name.setBounds(91, 17, 66, 21);
			contentPanel.add(pro_name);
			pro_name.setColumns(10);
		}
		{
			pro_stock = new JTextField();
			pro_stock.setBounds(91, 48, 66, 21);
			contentPanel.add(pro_stock);
			pro_stock.setColumns(10);
		}
		{
			pro_price = new JTextField();
			pro_price.setBounds(91, 79, 66, 21);
			contentPanel.add(pro_price);
			pro_price.setColumns(10);
		}
		{
			pro_vip_price = new JTextField();
			pro_vip_price.setBounds(91, 110, 66, 21);
			contentPanel.add(pro_vip_price);
			pro_vip_price.setColumns(10);
		}
		{
			pro_spe = new JTextField();
			pro_spe.setBounds(91, 141, 66, 21);
			contentPanel.add(pro_spe);
			pro_spe.setColumns(10);
		}
		{
			pro_more = new JTextField();
			pro_more.setBounds(91, 172, 156, 21);
			contentPanel.add(pro_more);
			pro_more.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("\u4EA7\u54C1\u6570\u91CF");
			lblNewLabel_1.setBounds(27, 51, 54, 15);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("\u4EA7\u54C1\u4EF7\u683C");
			lblNewLabel_2.setBounds(27, 82, 54, 15);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("\u4EA7\u54C1VIP\u4EF7\u683C");
			lblNewLabel_3.setBounds(10, 113, 71, 15);
			contentPanel.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("\u4EA7\u54C1\u89C4\u683C");
			lblNewLabel_4.setBounds(27, 144, 54, 15);
			contentPanel.add(lblNewLabel_4);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("\u4EA7\u54C1\u8BE6\u60C5");
			lblNewLabel_5.setBounds(27, 175, 54, 15);
			contentPanel.add(lblNewLabel_5);
		}
		{
			promotion = new JCheckBox("");
			promotion.setBounds(91, 199, 103, 23);
			contentPanel.add(promotion);
		}
		{
			JLabel lblNewLabel_6 = new JLabel("\u4FC3\u9500");
			lblNewLabel_6.setBounds(27, 200, 54, 15);
			contentPanel.add(lblNewLabel_6);
		}
		JPanel buttonPane = new JPanel();
		buttonPane.setBounds(0, 263, 274, -44);
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(null);
			
				okButton = new JButton("\u786E\u8BA4");
				okButton.setBounds(123, 238, 76, 23);
				getContentPane().add(okButton);
				okButton.addActionListener(this) ;
				
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
			
			
				cancelButton = new JButton("\u53D6\u6D88");
				cancelButton.setBounds(201, 238, 65, 23);
				getContentPane().add(cancelButton);
				cancelButton.addActionListener(this) ;
				double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
				double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
				this.setLocation((int) (width - this.getWidth()) / 2,
						(int) (height - this.getHeight()) / 2);
	}
	private JButton okButton;
	private JButton cancelButton;
	public Bean_type type;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource()==this.okButton) {
			Bean_production b=new Bean_production();
			
			try {
			b.setType_id(type.getType_id());
			b.setPro_name(pro_name.getText());
			b.setPro_more(pro_more.getText());
			b.setPro_price(Float.valueOf(pro_price.getText()));
			b.setPro_specification(pro_spe.getText());
			b.setPro_stock(Integer.valueOf(pro_stock.getText()));
			if(promotion.isSelected())
				b.setPromotion(1);
			else
				b.setPromotion(0);
			b.setVip_price(Float.valueOf(pro_vip_price.getText()));
			}
			catch (Exception p){
				JOptionPane.showMessageDialog(null, "错误", "请检查输入格式", JOptionPane.ERROR_MESSAGE); 
				p.printStackTrace();
				return;
			}
			
			start.Online_Market_Util.production_Manager.add_pro(b);
			JOptionPane.showMessageDialog(null, "成功", "成功增添商品", JOptionPane.INFORMATION_MESSAGE); 
			f.reloadTypeTable();
			
			this.setVisible(false);
		}
		else if(e.getSource()==this.cancelButton) {
			this.setVisible(false);
		}
	}
}
