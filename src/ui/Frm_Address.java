package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

public class Frm_Address extends JDialog  implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private Bean_address  curAdd=null;
	private int curAdd_Index;
	private JFrame f=null;
	private List<Bean_address> add_list =null;
	private JMenuItem delete_address,edit_address;
	
	public Frm_Address() {
		
		setTitle("\u6211\u7684\u5730\u5740");
		setBounds(100, 100, 450, 510);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 438);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 424, 21);
		contentPanel.add(menuBar);
		
		JMenu menu = new JMenu("\u64CD\u4F5C\u9009\u9879");
		menuBar.add(menu);
		
		edit_address = new JMenuItem("\u7F16\u8F91\u5730\u5740");
		edit_address.addActionListener(this);
		
		add_address = new JMenuItem("\u6DFB\u52A0\u5730\u5740");
		add_address.addActionListener(this);
		menu.add(add_address);
		menu.add(edit_address);
		
		delete_address = new JMenuItem("\u79FB\u9664\u5730\u5740");
		delete_address.addActionListener(this);
		menu.add(delete_address);
		
		JScrollPane scrollPane_pro = new JScrollPane(this.address_menu);
		scrollPane_pro.setBounds(10, 31, 414, 397);
		contentPanel.add(scrollPane_pro);
		
		//address_menu.setBackground(Color.LIGHT_GRAY);
		//address_menu.setBounds(10, 31, 414, 397);
		//contentPanel.add(address_menu);
		this.reload_add_table();
		address_menu.addMouseListener(new MouseAdapter (){	
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=Frm_Address.this.address_menu.getSelectedRow();
				
				if(i<0) {
					return;
				}
				
				curAdd=Frm_Address.this.add_list.get(i);
				curAdd_Index=i;
			}	    	
	    });
			
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 438, 434, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				ok_button = new JButton("\u786E\u8BA4");
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
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,
				(int) (height - this.getHeight()) / 2);
		
	}
	
	private JButton cancel_button,ok_button;
	private Frm_AddAdd dlgAdd=null;
	private Frm_AddEdit dlgEdit=null;
	
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource()==this.ok_button) {
			this.setVisible(false);
		}
		else if(e.getSource()==this.cancel_button){
			this.setVisible(false);
		}
		else if(e.getSource()==this.delete_address) {
			if(curAdd==null) {
				JOptionPane.showMessageDialog(null, "请先选中地址", "错误", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			start.Online_Market_Util.address_Manager.delete_address(curAdd);
			this.add_list.remove(this.curAdd_Index);
			this.reload_add_table();
			curAdd=null;
		}
		else if(e.getSource()==this.edit_address) {
			if(curAdd==null) {
				JOptionPane.showMessageDialog(null, "请先选中地址", "错误", JOptionPane.ERROR_MESSAGE);
				return;
			}
			//System.out.println(curAdd.getAddress_id());
			dlgEdit=new Frm_AddEdit(curAdd,this);
			dlgEdit.setVisible(true);
			this.reload_add_table();
			curAdd=null;
		}
		else if(e.getSource()==this.add_address) {
			dlgAdd=new Frm_AddAdd(this);
			dlgAdd.setVisible(true);
			this.reload_add_table();
		}
	}
	
	
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
	
	private JMenuItem add_address;
	
	
}
