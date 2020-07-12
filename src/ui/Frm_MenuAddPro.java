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

import model.Bean_menu;
import model.Bean_production;
import model.Bean_type;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.Color;

public class Frm_MenuAddPro extends JDialog  implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	
	private Bean_menu curPro=null;
	public Frm_MenuAddPro(Bean_menu curPro ) {
		this.curPro=curPro;
		setTitle("\u8BF7\u8F93\u5165\u5173\u8054\u4EA7\u54C1id");
		setBounds(100, 100, 224, 183);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblid = new JLabel("\u5173\u8054\u4EA7\u54C1id");
			lblid.setBounds(10, 13, 60, 15);
			contentPanel.add(lblid);
		}
		
			textField = new JTextField();
			textField.setBounds(80, 10, 66, 21);
			contentPanel.add(textField);
			textField.setColumns(10);
			
			JLabel label = new JLabel("\u63CF\u8FF0");
			label.setBounds(20, 38, 54, 15);
			contentPanel.add(label);
			
			textArea = new JTextArea();
			textArea.setBackground(Color.LIGHT_GRAY);
			textArea.setLineWrap(true);
			textArea.setBounds(66, 34, 132, 67);
			
			contentPanel.add(textArea);
		
		
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
	private int id=0;
	private String des;
	private JTextArea textArea=null;
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource()==this.okButton) {
			
			try {
				id=Integer.valueOf(textField.getText());
				des=this.textArea.getText();
			}
			catch(Exception p) {
				JOptionPane.showMessageDialog(null, "请检查输入格式", "错误", JOptionPane.ERROR_MESSAGE); 
				p.printStackTrace();
				return;
			}
			
			this.setVisible(false);
			start.Online_Market_Util.menu_manager.add_menu_pro(this.curPro,id,des);
			JOptionPane.showMessageDialog(null, "产品成功关联菜谱", "成功", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(e.getSource()==this.cancelButton){
			this.setVisible(false);
		}
	}
}
