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

public class Frm_OrderEdit extends JDialog  implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private Bean_order_more  curOrder=null;
	private int curOrder_Index;
	
	
	public Frm_OrderEdit() {
		
		this.validate();
		setTitle("\u7528\u6237\u8BA2\u5355\u64CD\u4F5C");
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
				int i=Frm_OrderEdit.this.shop_menu_table.getSelectedRow();
				
				if(i<0) {
					return;
				}
				
				curOrder=Frm_OrderEdit.this.order_list.get(i);
				curOrder_Index=i;
			}	    	
	    });
		
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,
				(int) (height - this.getHeight()) / 2);
		
		for(int i=0;i<this.order_list.size();i++){
			this.total+=this.order_list.get(i).getNow_price();
			this.pre_total+=this.order_list.get(i).getPre_price();
		}
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 540, 21);
		contentPanel.add(menuBar);
		
		JMenu menu = new JMenu("\u8BA2\u5355\u64CD\u4F5C");
		menuBar.add(menu);
		
		order_1 = new JMenuItem("\u8BA2\u5355\u914D\u9001");
		order_1.addActionListener(this);
		menu.add(order_1);
		
		order_re = new JMenuItem("\u8BA2\u5355\u786E\u8BA4\u9000\u8D27");
		order_re.addActionListener(this);
		menu.add(order_re);
								
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
	private static final String[] tableTitles = {"用户id","购买商品","购买数量","原价","优惠后","到达日期","订单状态"};
	private List<Bean_order_more> order_list=null;
	public void reload_shop_menu(){
		order_list = start.Online_Market_Util.order_Manager.load_order_more();
		Object[][] table_pro_data = new Object[order_list.size()][tableTitles.length];
		for(int i=0;i<order_list.size();i++){
			for(int j=0;j<tableTitles.length;j++)	 
				table_pro_data[i][j]=order_list.get(i).getCell2(j);
		}
		shop_menu_table_model.setDataVector(table_pro_data,tableTitles);
		this.shop_menu_table.validate();
		this.shop_menu_table.repaint();
		//this.pri
	}
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource()==this.ok_button) {
			this.setVisible(false);
		}									
		else if(e.getSource()==this.cancel_button) {
			this.setVisible(false);
		}
		else if(e.getSource()==this.order_1) {
			if(curOrder==null) {
				JOptionPane.showMessageDialog(null, "请先选中订单", "错误", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			if(!curOrder.getOrder_state().equals("已下单")) {
				JOptionPane.showMessageDialog(null, "请先选中已下单的订单", "错误 ", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			start.Online_Market_Util.order_Manager.edit_order(curOrder.getOrder_id(), "配送中");
			JOptionPane.showMessageDialog(null, "成功确认配送", "成功", JOptionPane.INFORMATION_MESSAGE);
			this.reload_shop_menu();
			curOrder=null;
		}
		else if(e.getSource()==this.order_re) {
			if(curOrder==null) {
				JOptionPane.showMessageDialog(null, "请先选中订单", "错误 ", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			if(!curOrder.getOrder_state().equals("退货中")) {
				JOptionPane.showMessageDialog(null, "请先选中退货中的订单", "错误 ", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			start.Online_Market_Util.order_Manager.edit_order(curOrder.getOrder_id(), "已退货");
			JOptionPane.showMessageDialog(null, "退货成功", "成功", JOptionPane.INFORMATION_MESSAGE);
			this.reload_shop_menu();
			curOrder=null;
		}
		
	}
	private Frm_coment dlgCom=null;
	private JMenuItem order_1;
	private JMenuItem order_re;
}
