package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
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

public class Frm_TypeAdd extends JDialog  implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField type_name;
	private JTextField type_more;
	private Frm_Index index;
	
	public Frm_TypeAdd(Frm_Index index) {
		this.index=index;
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
			JLabel lblNewLabel = new JLabel("种类名称");
			lblNewLabel.setBounds(27, 20, 54, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			type_name = new JTextField();
			type_name.setBounds(91, 17, 66, 21);
			contentPanel.add(type_name);
			type_name.setColumns(10);
		}
		{
			type_more = new JTextField();
			type_more.setBounds(91, 48, 66, 21);
			contentPanel.add(type_more);
			type_more.setColumns(10);
		}
		
		{
			JLabel lblNewLabel_1 = new JLabel("种类描述");
			lblNewLabel_1.setBounds(27, 51, 54, 15);
			contentPanel.add(lblNewLabel_1);
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
	}
	private JButton okButton;
	private JButton cancelButton;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource()==this.okButton) {
			Bean_type b =new Bean_type();
			
			try {
			b.setType_name(type_name.getText());
			b.setType_more(type_more.getText());
			}
			catch (Exception p){
				JOptionPane.showMessageDialog(null, "错误", "请检查输入格式", JOptionPane.ERROR_MESSAGE); 
				p.printStackTrace();
			}
			
			start.Online_Market_Util.production_Manager.add_type(b);
			JOptionPane.showMessageDialog(null, "成功", "成功增添种类", JOptionPane.INFORMATION_MESSAGE); 
			index.reloadTypeTable();
			this.setVisible(false);
		}
		else if(e.getSource()==this.cancelButton) {
			this.setVisible(false);
		}
	}
}
