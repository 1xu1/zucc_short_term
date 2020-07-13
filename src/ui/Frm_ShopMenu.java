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
import model.Bean_meet_discount;
import model.Bean_production;
import model.Bean_user;
import util.BusinessException;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

public class Frm_ShopMenu extends JDialog  implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private Bean_production  curPro=null;
	private int curPro_Index;
	private JFrame f=null;
	private List<Bean_production> pro_list =null;
	private JMenuItem delete_pro,add_coupon;
	
	public Frm_ShopMenu(List<Bean_production> pro_list) {
		this.pro_list=pro_list;
		
		this.validate();
		setTitle("\u8D2D\u7269\u8F66");
		setBounds(100, 100, 450, 543);
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
		
		delete_pro = new JMenuItem("\u79FB\u9664\u5546\u54C1");
		delete_pro.addActionListener(this);
		
		Add_Select = new JMenuItem("\u9009\u62E9\u6536\u8D27\u5730\u5740");
		Add_Select.addActionListener(this);
		menu.add(Add_Select);
		menu.add(delete_pro);
		
		add_coupon = new JMenuItem("\u4F7F\u7528\u4F18\u60E0\u5238");
		add_coupon.addActionListener(this);
		menu.add(add_coupon);
		
		JScrollPane scrollPane_pro = new JScrollPane(this.shop_menu_table);
		scrollPane_pro.setBounds(10, 31, 414, 368);
		contentPanel.add(scrollPane_pro);
		
		price = new JLabel("\u8D2D\u4E70\u4EF7\u683C");
		price.setFont(new Font("宋体", Font.PLAIN, 15));
		price.setForeground(new Color(0, 0, 0));
		price.setBounds(20, 407, 389, 21);
		
		contentPanel.add(price);
		
		//shop_menu_table.setBackground(Color.LIGHT_GRAY);
		//shop_menu_table.setBounds(10, 31, 414, 397);
		//contentPanel.add(shop_menu_table);
		this.reload_shop_menu();
		shop_menu_table.addMouseListener(new MouseAdapter (){	
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=Frm_ShopMenu.this.shop_menu_table.getSelectedRow();
				
				if(i<0) {
					return;
				}
				
				curPro=Frm_ShopMenu.this.pro_list.get(i);
				curPro_Index=i;
			}	    	
	    });
			
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 474, 434, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				ok_button = new JButton("\u786E\u8BA4\u8D2D\u4E70");
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
		
		coupon_label = new JLabel("");
		coupon_label.setBounds(21, 448, 392, 15);
		getContentPane().add(coupon_label);
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,
				(int) (height - this.getHeight()) / 2);
	}
	
	private JButton cancel_button,ok_button;
	public JLabel price=null;
	public JLabel coupon_label=null;
	public Bean_address curAddress=null;
	private Frm_AddSelect dlgAddS=null;
	
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource()==this.ok_button) {
			if(curAddress==null) {
				JOptionPane.showMessageDialog(null, "请先选中地址", "错误", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(this.curCoupon!=null) {
				start.Online_Market_Util.order_Manager.add_order(Bean_user.currentLoginUser, curAddress, pro_list, pre_price, now_price, this.curCoupon);
			}
			else if(this.curMeet!=null) {
				start.Online_Market_Util.order_Manager.add_order(Bean_user.currentLoginUser, curAddress, pro_list, pre_price, now_price, this.curMeet);
			}
			else {
				start.Online_Market_Util.order_Manager.add_order(Bean_user.currentLoginUser, curAddress, pro_list, pre_price, now_price);
			}
			
			JOptionPane.showMessageDialog(null, "成功下单", "成功", JOptionPane.INFORMATION_MESSAGE);		
			this.pro_list.clear();
			this.reload_shop_menu();
			curAddress=null;
		}
		else if(e.getSource()==this.Add_Select) {
			dlgAddS=new Frm_AddSelect(this);
			this.dlgAddS.setVisible(true);
		}
		else if(e.getSource()==this.cancel_button){
			this.setVisible(false);
		}
		else if(e.getSource()==this.delete_pro) {
			if(curPro==null) {
				JOptionPane.showMessageDialog(null, "请先选中商品", "错误", JOptionPane.ERROR_MESSAGE);
				return;
			}
			this.pro_list.remove(this.curPro_Index);
			this.reload_shop_menu();
			curPro=null;
		}
		else if(e.getSource()==this.add_coupon) {
			dlgCouSelect=new Frm_CouponSelect(this);
			this.dlgCouSelect.setVisible(true);
			
		}
	}
	public String type_cou;
	private Frm_CouponSelect dlgCouSelect=null;

	DefaultTableModel shop_menu_table_model=new DefaultTableModel();
	private JTable shop_menu_table=new JTable(shop_menu_table_model);
	private static final String[] tableTitles = {"名称","商品原价","优惠价","规格","购买数量","详情 " };
	public void reload_shop_menu(){
		
		Object[][] table_pro_data = new Object[this.pro_list.size()][tableTitles.length];
		for(int i=0;i<pro_list.size();i++){
			for(int j=0;j<tableTitles.length;j++)
				 if(j==4) {
					 table_pro_data[i][j]=pro_list.get(i).getCell(6);
				 }
				 else
					 table_pro_data[i][j]=pro_list.get(i).getCell(j);
		}
		
		shop_menu_table_model.setDataVector(table_pro_data,tableTitles);
		this.shop_menu_table.validate();
		this.shop_menu_table.repaint();
		try {
			price.setText(calculate_price());
		} catch (BusinessException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		//this.pri
	}
	private double pre_price=0,now_price=0;
	public Bean_discount_coupon curCoupon=null;
	public Bean_meet_discount curMeet=null;
	private JMenuItem Add_Select;
	public String calculate_price() throws BusinessException {
		String result;
		int t=0;
		pre_price=now_price=0;
		for(int i=0;i<this.pro_list.size();i++) {
			pre_price+=this.pro_list.get(i).getPro_price()*this.pro_list.get(i).getPro_purchase();
			if(Bean_user.currentLoginUser.getVip()==1) {
				now_price+=this.pro_list.get(i).getVip_price()*this.pro_list.get(i).getPro_purchase();
				t=1;
			}
		}
		
		if(t==0)
			now_price=pre_price;
		if(curCoupon!=null) {
			if(now_price<this.curCoupon.getDis_amout()) {
				JOptionPane.showMessageDialog(null, "金额不满足", "错误", JOptionPane.ERROR_MESSAGE);
				return null;
				//return;
			}
			else {	
				now_price=now_price-this.curCoupon.getCut_amout();
			}
		}
		else if(curMeet!=null) {
			if(now_price<this.curMeet.getMd_amout()) {
				JOptionPane.showMessageDialog(null, "金额不满足", "错误", JOptionPane.ERROR_MESSAGE);
				return null;
				//return;
			}
			else {	
				now_price=now_price*this.curMeet.getDiscount();
			}
		}
		
		double cut=pre_price-now_price;
		result="总价:"+pre_price+"-"+cut+"="+now_price;
		return result;
	}
}
