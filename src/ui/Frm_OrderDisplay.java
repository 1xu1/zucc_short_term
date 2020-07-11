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

public class Frm_OrderDisplay extends JDialog  implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private Bean_order_more  curOrder=null;
	private int curOrder_Index;
	
	
	public Frm_OrderDisplay() {
		
		this.validate();
		setTitle("\u4E2A\u4EBA\u6D88\u8D39\u8BB0\u5F55");
		setBounds(100, 100, 569, 552);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 543, 503);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane_pro = new JScrollPane(this.shop_menu_table);
		scrollPane_pro.setBounds(10, 31, 530, 375);
		contentPanel.add(scrollPane_pro);
		{
			total_consume = new JLabel("New label");
			total_consume.setBounds(10, 417, 477, 15);
			contentPanel.add(total_consume);
		}
		{
			cut_total = new JLabel("New label");
			cut_total.setBounds(10, 440, 460, 15);
			contentPanel.add(cut_total);
		}
		
		//shop_menu_table.setBackground(Color.LIGHT_GRAY);
		//shop_menu_table.setBounds(10, 31, 414, 397);
		//contentPanel.add(shop_menu_table);
		this.reload_shop_menu();
		
		shop_menu_table.addMouseListener(new MouseAdapter (){	
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=Frm_OrderDisplay.this.shop_menu_table.getSelectedRow();
				
				if(i<0) {
					return;
				}
				
				curOrder=Frm_OrderDisplay.this.order_list.get(i);
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
		this.total_consume.setText("您已共计消费了： "+String.valueOf(this.total));		
		this.cut_total.setText("您已共计省钱： "+String.valueOf(this.pre_total-this.total));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 540, 21);
		contentPanel.add(menuBar);
		
		JMenu menu = new JMenu("\u8BA2\u5355\u64CD\u4F5C");
		menuBar.add(menu);
		
		 recieve_sales = new JMenuItem("\u786E\u8BA4\u6536\u8D27");
		menu.add(recieve_sales);
		this.recieve_sales.addActionListener(this);
		
		 return_sales = new JMenuItem("\u7533\u8BF7\u9000\u8D27");
		menu.add(return_sales);
		this.return_sales.addActionListener(this);
		
		 evaluate_sales = new JMenuItem("\u8BA2\u5355\u8BC4\u4EF7");
		menu.add(evaluate_sales);
		this.evaluate_sales.addActionListener(this);
								
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
	private static final String[] tableTitles = {"购买商品","购买数量","原价","优惠后","到达日期","订单状态"};
	private JLabel total_consume;
	private JLabel cut_total;
	private List<Bean_order_more> order_list=null;
	public void reload_shop_menu(){
		order_list = start.Online_Market_Util.order_Manager.load_order_more(Bean_user.currentLoginUser);
		Object[][] table_pro_data = new Object[order_list.size()][tableTitles.length];
		for(int i=0;i<order_list.size();i++){
			for(int j=0;j<tableTitles.length;j++)	 
				table_pro_data[i][j]=order_list.get(i).getCell(j);
		}
		shop_menu_table_model.setDataVector(table_pro_data,tableTitles);
		this.shop_menu_table.validate();
		this.shop_menu_table.repaint();
		//this.pri
	}
	private JMenuItem recieve_sales,return_sales,evaluate_sales;
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource()==this.ok_button) {
			this.setVisible(false);
		}									
		else if(e.getSource()==this.cancel_button) {
			this.setVisible(false);
		}
		else if(e.getSource()==this.recieve_sales) {
			if(curOrder==null) {
				JOptionPane.showMessageDialog(null, "请先选中订单", "错误", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			start.Online_Market_Util.order_Manager.edit_order(curOrder.getOrder_id(), "已送达");
			JOptionPane.showMessageDialog(null, "成功确认接收", "成功", JOptionPane.INFORMATION_MESSAGE);
			this.reload_shop_menu();
			curOrder=null;
		}
		else if(e.getSource()==this.return_sales) {
			if(curOrder==null) {
				JOptionPane.showMessageDialog(null, "请先选中订单", " ", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			start.Online_Market_Util.order_Manager.edit_order(curOrder.getOrder_id(), "退货中");
			JOptionPane.showMessageDialog(null, "退货受理中", "成功", JOptionPane.INFORMATION_MESSAGE);
			this.reload_shop_menu();
			curOrder=null;
		}
		else if(e.getSource()==this.evaluate_sales) {
			if(curOrder==null) {
				JOptionPane.showMessageDialog(null, "请先选中订单", "错误", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			
			curOrder=null;
		}
	}
	
}
