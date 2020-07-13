package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Bean_address;
import model.Bean_discount_coupon;
import model.Bean_production;
import model.Bean_user;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

public class Frm_AddSelect extends JDialog  implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private Bean_address  curAdd=null;
	private int curAdd_Index;
	private Frm_ShopMenu f=null;
	private List<Bean_production> pro_list =null;

	
	public Frm_AddSelect(Frm_ShopMenu f) {
		this.f=f;
		this.setAlwaysOnTop(true);
		
		this.validate();
		this.pro_list=pro_list;
		this.pre_price=pre_price;
		this.now_price=now_price;
		setTitle("\u5730\u5740\u9009\u62E9");
		setBounds(100, 100, 450, 416);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 438);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane_add = new JScrollPane(this.address_menu);
		scrollPane_add.setBounds(10, 10, 414, 317);
		contentPanel.add(scrollPane_add);
		
		{
		JPanel buttonPane = new JPanel();
		buttonPane.setBounds(10, 337, 434, 33);
		contentPanel.add(buttonPane);
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		{
			ok_button = new JButton("\u786E\u8BA4\u9009\u62E9\u5730\u5740");
			ok_button.addActionListener(this);
			buttonPane.add(ok_button);
			getRootPane().setDefaultButton(ok_button);
		}
		{
			 cancel_button = new JButton("\u53D6\u6D88");
			cancel_button.addActionListener(this);
			buttonPane.add(cancel_button);
		}
		}
		
		//address_menu.setBackground(Color.LIGHT_GRAY);
		//address_menu.setBounds(10, 31, 414, 397);
		//contentPanel.add(address_menu);
		this.reload_add_table();
		// 屏幕居中显示
				double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
				double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
				this.setLocation((int) (width - this.getWidth()) / 2,
						(int) (height - this.getHeight()) / 2);
		address_menu.addMouseListener(new MouseAdapter (){	
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=Frm_AddSelect.this.address_menu.getSelectedRow();
				
				if(i<0) {
					return;
				}
				
				curAdd=Frm_AddSelect.this.add_list.get(i);
				curAdd_Index=i;
			}	    	
	    });this.setAlwaysOnTop(true);
	}
	
	private JButton cancel_button,ok_button;
	private double pre_price,now_price;
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource()==this.ok_button) {
			if(curAdd==null) {
				JOptionPane.showMessageDialog(null, "请先选中地址", "错误", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			f.curAddress=curAdd;
			this.setVisible(false);
		}
		else if(e.getSource()==this.cancel_button){
			this.setVisible(false);
		}		
	}
	
	private List<Bean_address> add_list=new ArrayList<Bean_address>();
	DefaultTableModel address_menu_model=new DefaultTableModel();
	private JTable address_menu=new JTable(address_menu_model);
	private static final String[] tableTitles = {"联系人名字","联系人手机号","省份","城市","街区","详细地址 " };
	public void reload_add_table(){
		this.add_list=start.Online_Market_Util.address_Manager.load_all_address(Bean_user.currentLoginUser);
		Object[][] table_pro_data = new Object[this.add_list.size()][tableTitles.length];
		for(int i=0;i<add_list.size();i++){
			for(int j=0;j<tableTitles.length;j++)
				table_pro_data[i][j]=add_list.get(i).getCell(j);
		}
		
		address_menu_model.setDataVector(table_pro_data,tableTitles);
		this.address_menu.validate();
		this.address_menu.repaint();
		//this.pri
	}
	
	
}
