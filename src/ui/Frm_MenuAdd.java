package ui;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Bean_address;
import model.Bean_menu;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Frm_MenuAdd extends JDialog  implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField me_name;
	private JTextField me_step;
	private JTextField me_usage;
	private Frm_Menu f=null;
	
	public Frm_MenuAdd(Frm_Menu f) {
		this.f=f;
		
		this.validate();
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
			JLabel lblNewLabel = new JLabel("\u83DC\u8C31\u540D\u79F0");
			lblNewLabel.setBounds(27, 20, 54, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			me_name = new JTextField();
			me_name.setBounds(91, 17, 66, 21);
			contentPanel.add(me_name);
			me_name.setColumns(10);
		}
		{
			me_step = new JTextField();
			me_step.setBounds(91, 48, 66, 21);
			contentPanel.add(me_step);
			me_step.setColumns(10);
		}
		{
			me_usage = new JTextField();
			me_usage.setBounds(91, 79, 66, 21);
			contentPanel.add(me_usage);
			me_usage.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("\u83DC\u8C31\u505A\u6CD5");
			lblNewLabel_1.setBounds(27, 51, 54, 15);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("\u83DC\u8C31\u7528\u6599");
			lblNewLabel_2.setBounds(27, 82, 54, 15);
			contentPanel.add(lblNewLabel_2);
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
				{
					menu_picture = new JButton("\u6DFB\u52A0\u83DC\u8C31\u56FE\u7247");
					menu_picture.setBounds(27, 111, 111, 40);
					menu_picture.addActionListener(this);
					contentPanel.add(menu_picture);
				}
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
	private JButton menu_picture;
	private String picture=null;
	@Override	
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource()==this.okButton) {
			Bean_menu b=new Bean_menu();
			
			try {
			b.setMe_name(me_name.getText());
			b.setMe_usage(me_usage.getText());
			b.setMe_step(me_step.getText());
			b.setMe_picture(this.picture);
			}
			catch (Exception p){
				JOptionPane.showMessageDialog(null, "错误", "请检查输入格式", JOptionPane.ERROR_MESSAGE); 
				p.printStackTrace();
				return;
			}
			
			start.Online_Market_Util.menu_manager.add_menu(b);
			JOptionPane.showMessageDialog(null, "成功添加菜谱", "成功", JOptionPane.INFORMATION_MESSAGE); 
			this.setVisible(false);
			f.reload_shop_menu();
			//f.reload_add_table();
		}
		else if(e.getSource()==this.cancelButton) {
			this.setVisible(false);
		}
		else if(e.getSource()==this.menu_picture) {
			 JFileChooser chooser = new JFileChooser();
		     chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		     chooser.showDialog(new JLabel(), "选择图片");
		        File file = chooser.getSelectedFile();
		        picture=file.getAbsoluteFile().toString();
		}
	}
}
