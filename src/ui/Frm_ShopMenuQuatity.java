package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Bean_production;
import model.Bean_type;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Frm_ShopMenuQuatity extends JDialog  implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private List<Bean_production> pro_list=null;
	
	private Bean_production curPro=null;
	public Frm_ShopMenuQuatity(Bean_production curPro ) {
		this.curPro=curPro;
		this.pro_list=pro_list;
		setTitle("\u8BF7\u8F93\u5165\u8FDB\u8D27\u6570\u91CF");
		setBounds(100, 100, 224, 115);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JLabel label = new JLabel("\u8FDB\u8D27\u6570\u91CF");
			contentPanel.add(label);
		}
		
			textField = new JTextField();
			contentPanel.add(textField);
			textField.setColumns(10);
		
		
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
				okButton = new JButton("\u786E\u8BA4");
				okButton.addActionListener(this);
				buttonPane.add(okButton);
				
				getRootPane().setDefaultButton(okButton);
			
			
				cancelButton = new JButton("\u53D6\u6D88");
				cancelButton.addActionListener(this);
				buttonPane.add(cancelButton);
			
				double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
				double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
				this.setLocation((int) (width - this.getWidth()) / 2,
						(int) (height - this.getHeight()) / 2);
	}
	
	private JButton okButton;
	private JButton cancelButton;
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource()==this.okButton) {
			
			try {
				
				this.curPro.setPro_purchase(Integer.valueOf(textField.getText()));
			}
			catch(Exception p) {
				JOptionPane.showMessageDialog(null, "请检查输入格式", "错误", JOptionPane.ERROR_MESSAGE); 
				p.printStackTrace();
				return;
			}
			start.Online_Market_Util.shopMenu_manager.add_stock(curPro);
			this.setVisible(false);
			JOptionPane.showMessageDialog(null, "商品成功加入订单", "成功", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(e.getSource()==this.cancelButton){
			this.setVisible(false);
		}
	}

}
