package ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



import model.*;
import ui.*;
import util.*;


public class Frm_Login extends JDialog implements ActionListener{
	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private JButton btnLogin = new JButton("登陆");
	private JButton btnCancel = new JButton("退出");
	private JButton btnRegister = new JButton("注册");
	
	private JLabel labelUser = new JLabel("用户：");
	private JLabel labelPwd = new JLabel("密码：");
	private JTextField edtUserId = new JTextField(20);
	private JPasswordField edtPwd = new JPasswordField(20);
	
	

	private ImageIcon  background = new ImageIcon(".\\picture\\log_in.png");// 背景图片
	private JPanel imagePanel;
	
	public Frm_Login(Frame f, String s, boolean b) {
		super(f, s, b);
		toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar.add(this.btnRegister);
		toolBar.add(btnLogin);
		toolBar.add(btnCancel);
		
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		workPane.add(labelUser);
		workPane.add(edtUserId);
		workPane.add(labelPwd);
		workPane.add(edtPwd);
		this.getContentPane().add(workPane, BorderLayout.CENTER);
		
		
		//窗口大小
		this.setSize(1280, 720);
		
		
		//设置背景图片
		JLabel label = new JLabel(background);
		// 设置图片的大小与位置
		background.setImage(background.getImage().getScaledInstance(background.getIconWidth()/3,background.getIconHeight()/3,Image.SCALE_DEFAULT));
		label.setBounds(0, 0, background.getIconWidth(),
		background.getIconHeight());
		// 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
		imagePanel = (JPanel) this.getContentPane();
		imagePanel.setOpaque(false);
		
		// 内容窗格默认的布局管理器为BorderLayout
		imagePanel.setLayout(new FlowLayout());
		this.getLayeredPane().setLayout(null);
		// 把背景图片添加到分层窗格的最底层作为背景
		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		//this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		
		// 屏幕居中显示
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,
				(int) (height - this.getHeight()) / 2);

		this.validate();
		
		JLabel label_welcome = new JLabel("欢迎来到外卖生鲜平台");
		label_welcome.setFont(new Font("", getDefaultCloseOperation(), 50));
		label_welcome.setBounds(400, -300, 2000, 1000);
		this.getLayeredPane().add(label_welcome);
        //this.getContentPane().add(label_welcome);
		//label_welcome.setVisible(true);
		
		btnLogin.addActionListener(this);
		btnCancel.addActionListener(this);
		this.btnRegister.addActionListener(this);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btnLogin) {
			String userid=this.edtUserId.getText();
			String pwd=new String(this.edtPwd.getPassword());
			try {
				Bean_user.currentLoginUser=start.Online_Market_Util.user_Manager.login(userid, pwd);
				 if(Bean_user.currentLoginUser!=null) {
					 JOptionPane.showMessageDialog(null, "欢迎进入生鲜市场", "登录成功", JOptionPane.INFORMATION_MESSAGE);	
				 }
				 else
					 return;
			} catch (BaseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
			this.setVisible(false);
			
		} else if (e.getSource() == this.btnCancel) {
			System.exit(0);
		} else if(e.getSource()==this.btnRegister){
			Frm_Register dlg=new Frm_Register(this,"注册",true);
			dlg.setVisible(true);
		} 
	}
}
