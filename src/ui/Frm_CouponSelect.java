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
import javax.swing.JCheckBox;

public class Frm_CouponSelect extends JDialog  implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private Bean_production  curPro=null;
	private int curPro_Index;
	private Frm_ShopMenu f=null;
	
	
	public Frm_CouponSelect(Frm_ShopMenu f) {
		this.f=f;
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,
				(int) (height - this.getHeight()) / 2);
		this.validate();
		setTitle("\u4E2A\u4EBA\u53EF\u7528\u4F18\u60E0\u5238");
		setBounds(100, 100, 569, 510);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 543, 438);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane_pro = new JScrollPane(this.shop_menu_table);
		scrollPane_pro.setBounds(10, 10, 530, 418);
		contentPanel.add(scrollPane_pro);
		
		//shop_menu_table.setBackground(Color.LIGHT_GRAY);
		//shop_menu_table.setBounds(10, 31, 414, 397);
		//contentPanel.add(shop_menu_table);
		this.reload_shop_menu();
				
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 438, 543, 33);
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
	}
	
	private JButton cancel_button,ok_button;
	private JLabel price=null;
	private Frm_AddSelect dlgAddS=null;
		
	private List<Bean_discount_coupon> coupon_list =null;
	private List<Bean_meet_discount> meet_list =null;
	DefaultTableModel shop_menu_table_model=new DefaultTableModel();
	private JTable shop_menu_table=new JTable(shop_menu_table_model);
	private static final String[] tableTitles = {"优惠券内容","要求金额","力度","开始日期","结束日期","类型"};
	public void reload_shop_menu(){
		coupon_list=start.Online_Market_Util.discount_Manager.load_all_discount_coupon(Bean_user.currentLoginUser);
		meet_list=start.Online_Market_Util.discount_Manager.load_all_meet_discount(Bean_user.currentLoginUser);
		Object[][] table_pro_data = new Object[this.coupon_list.size()+this.meet_list.size()][tableTitles.length];
		for(int i=0;i<coupon_list.size();i++){
			for(int j=0;j<tableTitles.length;j++)	 
				table_pro_data[i][j]=coupon_list.get(i).getCell(j);
		}
		
		for(int i=coupon_list.size();i<meet_list.size()+coupon_list.size();i++){
			for(int j=0;j<tableTitles.length;j++){
				//System.out.println(i-coupon_list.size());
				//System.out.println(meet_list.size());
				table_pro_data[i][j]=meet_list.get(i-coupon_list.size()).getCell(j);
			}
				
		}
		shop_menu_table_model.setDataVector(table_pro_data,tableTitles);
		this.shop_menu_table.validate();
		this.shop_menu_table.repaint();
		//this.pri
		shop_menu_table.addMouseListener(new MouseAdapter (){	
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=Frm_CouponSelect.this.shop_menu_table.getSelectedRow();
				
				if(i<0) {
					return;
				}
				else if(i<Frm_CouponSelect.this.coupon_list.size()) {
					curMeet=null;
					curCoupon=Frm_CouponSelect.this.coupon_list.get(i);
				}
				else{
					curCoupon=null;
					curMeet=Frm_CouponSelect.this.meet_list.get(i-Frm_CouponSelect.this.coupon_list.size());
				}
			}	    	
	    });
	}
	private Bean_discount_coupon curCoupon;
	private Bean_meet_discount curMeet;
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource()==this.ok_button) {
			if(curCoupon!=null) {
				f.curCoupon=this.curCoupon;
				try {
					if(f.calculate_price()==null)
						return;
					f.price.setText(f.calculate_price());
					f.coupon_label.setText("使用了"+this.curCoupon.getCell(5)+":"+this.curCoupon.getCell(0));
				} catch (BusinessException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
					return;
				}
				this.setVisible(false);
			}
			else if(curMeet!=null) {
				f.curMeet=this.curMeet;
				try {
					if(f.calculate_price()==null)
						return;
					f.price.setText(f.calculate_price());
					f.coupon_label.setText("使用了"+this.curMeet.getCell(5)+":"+this.curMeet.getCell(0));
				} catch (BusinessException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
					return;
				}
				this.setVisible(false);
			}
			else {
				
			}
			
		}
										
		else if(e.getSource()==this.cancel_button) {
			this.setVisible(false);
		}
	}
	
	
}
