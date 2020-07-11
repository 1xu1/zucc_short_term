package ui;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Bean_address;
import model.Bean_production;
import model.Bean_promotion;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Frm_PrAdd extends JDialog  implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField pr_price;
	private JTextField pr_quatity;
	private JTextField start_date;
	private JTextField end_date;
	private Bean_production curPro=null;

	public Frm_PrAdd(Bean_production curPro) {
		this.curPro=curPro;
		this.validate();
		
		setTitle("\u589E\u6DFB\u4FC3\u9500\u5546\u54C1");
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
			JLabel lblNewLabel = new JLabel("\u4FC3\u9500\u4EF7\u683C");
			lblNewLabel.setBounds(27, 20, 54, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			pr_price = new JTextField();
			pr_price.setBounds(91, 17, 66, 21);
			contentPanel.add(pr_price);
			pr_price.setColumns(10);
		}
		{
			pr_quatity = new JTextField();
			pr_quatity.setBounds(91, 48, 66, 21);
			contentPanel.add(pr_quatity);
			pr_quatity.setColumns(10);
		}
		{
			start_date = new JTextField();
			start_date.setBounds(91, 79, 176, 21);
			contentPanel.add(start_date);
			start_date.setColumns(10);
		}
		{
			end_date = new JTextField();
			end_date.setBounds(91, 110, 176, 21);
			contentPanel.add(end_date);
			end_date.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("\u4FC3\u9500\u6570\u91CF");
			lblNewLabel_1.setBounds(27, 51, 54, 15);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("\u4FC3\u9500\u8D77\u59CB\u65E5\u671F");
			lblNewLabel_2.setBounds(10, 82, 76, 15);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("\u4FC3\u9500\u7ED3\u675F\u65E5\u671F");
			lblNewLabel_3.setBounds(10, 113, 76, 15);
			contentPanel.add(lblNewLabel_3);
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
		
			double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
			double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
			this.setLocation((int) (width - this.getWidth()) / 2,
					(int) (height - this.getHeight()) / 2);
	}
	
	private JButton okButton;
	private JButton cancelButton;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource()==this.okButton) {
			Bean_promotion b=new Bean_promotion();
			
			try {
			b.setPro_name(curPro.getPro_name());
			b.setPro_price(curPro.getPro_price());
			b.setPr_price(Float.valueOf(this.pr_price.getText()));
			b.setPro_sp(curPro.getPro_specification());
			b.setPr_quatity(Integer.valueOf(this.pr_quatity.getText()));
			b.setStart_date(Timestamp.valueOf(this.start_date.getText()));
			b.setStart_date(Timestamp.valueOf(this.end_date.getText()));
			}
			catch (Exception p){
				JOptionPane.showMessageDialog(null, "错误", "请检查输入格式", JOptionPane.ERROR_MESSAGE); 
				p.printStackTrace();
				return;
			}
			
			start.Online_Market_Util.production_Manager.add_pr(curPro,b);
			JOptionPane.showMessageDialog(null, "成功", "成功增添促销商品", JOptionPane.INFORMATION_MESSAGE); 
			this.setVisible(false);
		}
		else if(e.getSource()==this.cancelButton) {
			this.setVisible(false);
		}
	}
}
