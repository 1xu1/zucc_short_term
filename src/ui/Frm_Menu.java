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

import model.Bean_discount_coupon;
import model.Bean_meet_discount;
import model.Bean_menu;
import model.Bean_order_more;
import model.Bean_production;
import model.Bean_u_order;
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
import javax.swing.JCheckBox;

public class Frm_Menu extends JDialog  implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private Bean_menu  curOrder=null;
	private int curOrder_Index;
	private JMenuItem edit_menu,delete_menu,menu_addpro,menu_more;
	
	public Frm_Menu() {
		
		this.validate();
		setTitle("\u83DC\u8C31");
		setBounds(100, 100, 569, 552);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 543, 503);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane_pro = new JScrollPane(this.shop_menu_table);
		scrollPane_pro.setBounds(10, 31, 530, 428);
		contentPanel.add(scrollPane_pro);
		
		//shop_menu_table.setBackground(Color.LIGHT_GRAY);
		//shop_menu_table.setBounds(10, 31, 414, 397);
		//contentPanel.add(shop_menu_table);
		this.reload_shop_menu();
		
		shop_menu_table.addMouseListener(new MouseAdapter (){	
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=Frm_Menu.this.shop_menu_table.getSelectedRow();
				
				if(i<0) {
					return;
				}
				
				curOrder=Frm_Menu.this.menu_list.get(i);
				
				curOrder_Index=i;
			}	    	
	    });
		
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,
				(int) (height - this.getHeight()) / 2);
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 540, 21);
		contentPanel.add(menuBar);
		
		JMenu menu = new JMenu("\u83DC\u8C31\u64CD\u4F5C");
		menuBar.add(menu);
		
		 add_menu = new JMenuItem("\u6DFB\u52A0\u83DC\u8C31");
		 add_menu.addActionListener(this);
		menu.add(add_menu);
		
		edit_menu = new JMenuItem("\u7F16\u8F91\u83DC\u8C31");
		edit_menu.addActionListener(this);
		menu.add(edit_menu);
		
		delete_menu = new JMenuItem("\u64A4\u9500\u83DC\u8C31");
		delete_menu.addActionListener(this);
		menu.add(delete_menu);
		
		menu_addpro = new JMenuItem("\u83DC\u8C31\u5173\u8054\u4EA7\u54C1");
		menu_addpro.addActionListener(this);
		menu.add(menu_addpro);
		
		JMenu mnNewMenu = new JMenu("\u67E5\u770B\u83DC\u5355");
		
		menuBar.add(mnNewMenu);
		
		menu_more = new JMenuItem("\u67E5\u770B\u83DC\u8C31\u8BE6\u7EC6\u4FE1\u606F");
		mnNewMenu.add(menu_more);
		menu_more.addActionListener(this);
		
								
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 470, 543, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			
			ok_button = new JButton("\u786E\u8BA4");
			ok_button.addActionListener(this);
			buttonPane.add(ok_button);
			getRootPane().setDefaultButton(ok_button);
			
			
			cancel_button = new JButton("\u53D6\u6D88");
			cancel_button.addActionListener(this);
			buttonPane.add(cancel_button);
			
				
				
		
	}
	
	
	private double total=0,pre_total=0;
	private JButton cancel_button,ok_button;
	
	DefaultTableModel shop_menu_table_model=new DefaultTableModel();
	private JTable shop_menu_table=new JTable(shop_menu_table_model);
	private static final String[] tableTitles = {"菜谱名称","方法","用料"};
	private List<Bean_menu> menu_list=null;
	public void reload_shop_menu(){
		menu_list = start.Online_Market_Util.menu_manager.load_menu();
		Object[][] table_pro_data = new Object[menu_list.size()][tableTitles.length];
		for(int i=0;i<menu_list.size();i++){
			for(int j=0;j<tableTitles.length;j++)	 
				table_pro_data[i][j]=menu_list.get(i).getCell(j);
		}
		shop_menu_table_model.setDataVector(table_pro_data,tableTitles);
		this.shop_menu_table.validate();
		this.shop_menu_table.repaint();
		//this.pri
	}
	private JMenuItem add_menu;
	private Frm_MenuAdd dlgAdd=null;
	private Frm_MenuEdit dlgEdit=null;
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource()==this.ok_button) {
			this.setVisible(false);
		}									
		else if(e.getSource()==this.cancel_button) {
			this.setVisible(false);
		}
		else if(e.getSource()==this.edit_menu) {
			if(curOrder==null) {
				JOptionPane.showMessageDialog(null, "请先选中菜谱", "错误", JOptionPane.ERROR_MESSAGE);
				return;
			}
			dlgEdit=new Frm_MenuEdit(this,this.curOrder);
			this.dlgEdit.setVisible(true);
			curOrder=null;
		}
		else if(e.getSource()==this.add_menu) {
			dlgAdd=new Frm_MenuAdd(this);
			dlgAdd.setVisible(true);
			
		}
		else if(e.getSource()==this.delete_menu) {
			if(curOrder==null) {
				JOptionPane.showMessageDialog(null, "请先选中菜谱", "错误", JOptionPane.ERROR_MESSAGE);
				return;
			}
			start.Online_Market_Util.menu_manager.delete_menu(curOrder);
			JOptionPane.showMessageDialog(null, "成功撤销菜谱", "成功", JOptionPane.INFORMATION_MESSAGE);
			this.reload_shop_menu();
		}
		else if(e.getSource()==this.menu_addpro) {
			
		}
		else if(e.getSource()==this.menu_more) {
			
		}
	}
		
	
	
}
