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

import model.Bean_order_more;
import model.Bean_user;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class Frm_coment extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextArea comment_content;
	private Bean_order_more curOrder=null;
	
	public Frm_coment(Bean_order_more curOrder) {
		this.curOrder=curOrder;
		setTitle("\u8BC4\u8BBA");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 228);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u60A8\u7684\u8BC4\u4EF7\u5185\u5BB9\uFF1A");
		label.setBounds(10, 10, 417, 15);
		contentPanel.add(label);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u9009\u62E9\u60A8\u5BF9\u8BE5 \u4EA7\u54C1\u7684\u6EE1\u610F\u5EA6");
		lblNewLabel.setBounds(10, 203, 169, 15);
		contentPanel.add(lblNewLabel);
		
		star_1 = new JRadioButton("New radio button");
		star_1.setBounds(190, 199, 22, 23);
		contentPanel.add(star_1);
		
		star_2 = new JRadioButton("New radio button");
		star_2.setBounds(214, 199, 22, 23);
		contentPanel.add(star_2);
		
		star_3 = new JRadioButton("New radio button");
		star_3.setBounds(238, 199, 22, 23);
		contentPanel.add(star_3);
		
		star_4 = new JRadioButton("New radio button");
		star_4.setBounds(262, 199, 22, 23);
		contentPanel.add(star_4);
		
		star_5 = new JRadioButton("New radio button");
		star_5.setBounds(286, 199, 22, 23);
		contentPanel.add(star_5);
		
		comment_content = new JTextArea();
		comment_content.setBounds(20, 35, 377, 158);
		contentPanel.add(comment_content);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 228, 434, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				okButton = new JButton("\u786E\u8BA4");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("\u53D6\u6D88");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		star_1.addActionListener(this);
		star_2.addActionListener(this);
		star_3.addActionListener(this);
		star_4.addActionListener(this);
		star_5.addActionListener(this);
		okButton.addActionListener(this);
		cancelButton.addActionListener(this);
		this.comment_content.setLineWrap(true);
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,
				(int) (height - this.getHeight()) / 2);
	}
	private JButton okButton,cancelButton;
	private  JRadioButton star_1,star_2,star_3,star_4,star_5;
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==okButton) {
			int star=1;
			if(star_1.isSelected()==false) {
				JOptionPane.showMessageDialog(null, "请先选择星级", "错误", JOptionPane.ERROR_MESSAGE); return;
			}
			else if(star_5.isSelected())	
				star=5;
			else if(star_4.isSelected())
				star=4;
			else if(star_3.isSelected())
				star=3;
			else if(star_2.isSelected())
				star=2;
			try {
				start.Online_Market_Util.comment_Manager.add_comment(curOrder,Bean_user.currentLoginUser,this.comment_content.getText(),star);
			}
			catch(Exception p){
				JOptionPane.showMessageDialog(null, "无法重复评价", "错误", JOptionPane.ERROR_MESSAGE); return;
			}
			JOptionPane.showMessageDialog(null, "成功评价", "成功", JOptionPane.INFORMATION_MESSAGE);
			this.setVisible(false);
		}
		else if(e.getSource()==cancelButton) {
			this.setVisible(false);
		}
		else if(e.getSource()==star_5) {
			this.star_1.setSelected(true);
			this.star_2.setSelected(true);
			this.star_3.setSelected(true);
			this.star_4.setSelected(true);
			this.star_5.setSelected(true);
		}
		else if(e.getSource()==star_4) {
			this.star_1.setSelected(true);
			this.star_2.setSelected(true);
			this.star_3.setSelected(true);
			this.star_4.setSelected(true);
			this.star_5.setSelected(false);
		}
		else if(e.getSource()==star_3) {
			this.star_1.setSelected(true);
			this.star_2.setSelected(true);
			this.star_3.setSelected(true);
			this.star_4.setSelected(false);
			this.star_5.setSelected(false);
		}
		else if(e.getSource()==star_2) {
			this.star_1.setSelected(true);
			this.star_2.setSelected(true);
			this.star_3.setSelected(false);
			this.star_4.setSelected(false);
			this.star_5.setSelected(false);
		}
		else if(e.getSource()==star_2) {
			this.star_1.setSelected(true);
			this.star_2.setSelected(false);
			this.star_3.setSelected(false);
			this.star_4.setSelected(false);
			this.star_5.setSelected(false);
		}
	}
}
