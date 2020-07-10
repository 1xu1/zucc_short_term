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
	private JButton btnLogin = new JButton("��½");
	private JButton btnCancel = new JButton("�˳�");
	private JButton btnRegister = new JButton("ע��");
	
	private JLabel labelUser = new JLabel("�û���");
	private JLabel labelPwd = new JLabel("���룺");
	private JTextField edtUserId = new JTextField(20);
	private JPasswordField edtPwd = new JPasswordField(20);
	
	

	private ImageIcon  background = new ImageIcon(".\\picture\\log_in.png");// ����ͼƬ
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
		
		
		//���ڴ�С
		this.setSize(1280, 720);
		
		
		//���ñ���ͼƬ
		JLabel label = new JLabel(background);
		// ����ͼƬ�Ĵ�С��λ��
		background.setImage(background.getImage().getScaledInstance(background.getIconWidth()/3,background.getIconHeight()/3,Image.SCALE_DEFAULT));
		label.setBounds(0, 0, background.getIconWidth(),
		background.getIconHeight());
		// �����ݴ���ת��ΪJPanel���������÷���setOpaque()��ʹ���ݴ���͸��
		imagePanel = (JPanel) this.getContentPane();
		imagePanel.setOpaque(false);
		
		// ���ݴ���Ĭ�ϵĲ��ֹ�����ΪBorderLayout
		imagePanel.setLayout(new FlowLayout());
		this.getLayeredPane().setLayout(null);
		// �ѱ���ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ����
		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		//this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		
		// ��Ļ������ʾ
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,
				(int) (height - this.getHeight()) / 2);

		this.validate();
		
		JLabel label_welcome = new JLabel("��ӭ������������ƽ̨");
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
					 JOptionPane.showMessageDialog(null, "��ӭ���������г�", "��¼�ɹ�", JOptionPane.INFORMATION_MESSAGE);	
				 }
				 else
					 return;
			} catch (BaseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "����",JOptionPane.ERROR_MESSAGE);
				return;
			}
			this.setVisible(false);
			
		} else if (e.getSource() == this.btnCancel) {
			System.exit(0);
		} else if(e.getSource()==this.btnRegister){
			Frm_Register dlg=new Frm_Register(this,"ע��",true);
			dlg.setVisible(true);
		} 
	}
}
