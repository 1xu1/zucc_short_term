package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Bean_production;
import model.Bean_promotion;
import model.Bean_type;
import model.Bean_user;
import util.BusinessException;

import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class Frm_Index extends JFrame implements ActionListener{
	JLabel label =null;
	JMenuItem pro_stock=null,shop_menu_edit=null;
	
	public Frm_Index() {
		//System.out.print(Bean_user.currentLoginUser.getVip_end_date().toString());
		if(Bean_user.currentLoginUser.getVip_end_date()!=null) {
			long vip_date = Bean_user.currentLoginUser.getVip_end_date().getTime();			
			if(vip_date>System.currentTimeMillis())				
				Bean_user.currentLoginUser.setVip_valid(1);
		}
		
		 
		setTitle("\u751F\u9C9C\u5E02\u573A\u9996\u9875");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 952, 583);
		// 屏幕居中显示
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
			this.setLocation((int) (width - this.getWidth()) / 2,
						(int) (height - this.getHeight()) / 2);
			this.validate();
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u4E2A\u4EBA\u4E2D\u5FC3");
		menuBar.add(menu);
		
		change_pwd = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		menu.add(change_pwd);
		change_pwd.addActionListener(this);
		
		edit_user_date = new JMenuItem("\u4FEE\u6539\u4E2A\u4EBA\u8D44\u6599");
		menu.add(edit_user_date);
		edit_user_date.addActionListener(this);
		load_user_data = new JMenuItem("\u67E5\u770B\u4E2A\u4EBA\u8D44\u6599");
		menu.add(load_user_data);
		load_user_data.addActionListener(this);
		
		edit_address = new JMenuItem("\u7F16\u8F91\u5730\u5740");
		edit_address.addActionListener(this);
		menu.add(edit_address);
		
		shop_record = new JMenuItem("\u67E5\u770B\u4E2A\u4EBA\u6D88\u8D39\u8BB0\u5F55");
		menu.add(shop_record);
		shop_record.addActionListener(this);
		
		load_coupon = new JMenuItem("\u67E5\u770B\u4E2A\u4EBA\u4F18\u60E0");
		menu.add(load_coupon);
		load_coupon.addActionListener(this);
		shop_menu = new JMenuItem("\u67E5\u770B\u8D2D\u7269\u8F66");
		menu.add(shop_menu);
		shop_menu.addActionListener(this);
		
		add_vip = new JMenuItem("\u6210\u4E3AVIP");
		add_vip.addActionListener(this);
		menu.add(add_vip);
		
		menu_2 = new JMenu("\u5546\u54C1\u64CD\u4F5C\u9009\u9879");
		menuBar.add(menu_2);
		
		load_comment = new JMenuItem("\u67E5\u770B\u5546\u54C1\u8BC4\u4EF7");
		load_comment.addActionListener(this);
		menu_2.add(load_comment);
		
		menu_1 = new JMenu("\u7BA1\u7406\u5458\u9009\u9879");
		menuBar.add(menu_1);
		
		pro_manager = new JMenu("\u7BA1\u7406\u5546\u54C1");
		pro_manager.addActionListener(this);
		
		JMenu user_manger = new JMenu("\u7BA1\u7406\u7528\u6237");
		menu_1.add(user_manger);
		
		user_edit = new JMenuItem("\u7F16\u8F91\u7528\u6237\u4FE1\u606F");
		user_manger.add(user_edit);
		user_edit.addActionListener(this);
		
		user_delete = new JMenuItem("\u6CE8\u9500\u7528\u6237");
		user_manger.add(user_delete);
		user_delete.addActionListener(this);
		menu_1.add(pro_manager);
		
		add_type = new JMenuItem("\u589E\u6DFB\u79CD\u7C7B");
		add_type.addActionListener(this);
		pro_manager.add(add_type);
		
		delete_type = new JMenuItem("\u5220\u9664\u79CD\u7C7B");
		delete_type.addActionListener(this);
		
		edit_type = new JMenuItem("\u7F16\u8F91\u79CD\u7C7B");
		edit_type.addActionListener(this);
		pro_manager.add(edit_type);
		pro_manager.add(delete_type);
		
		add_pro = new JMenuItem("\u4E0A\u67B6\u5546\u54C1");
		add_pro.addActionListener(this);
		pro_manager.add(add_pro);
		
		delete_pro = new JMenuItem("\u4E0B\u67B6\u5546\u54C1");
		delete_pro.addActionListener(this);
		
		edit_pro = new JMenuItem("\u7F16\u8F91\u5546\u54C1");
		edit_pro.addActionListener(this);
		pro_manager.add(edit_pro);
		pro_manager.add(delete_pro);
		
		add_pr = new JMenuItem("\u589E\u6DFB\u4FC3\u9500");
		pro_manager.add(add_pr);
		add_pr.addActionListener(this);
		
		delete_pr = new JMenuItem("\u79FB\u9664\u4FC3\u9500");
		pro_manager.add(delete_pr);
		delete_pr.addActionListener(this);
		
		JMenu coupon_manager = new JMenu("\u7BA1\u7406\u4F18\u60E0\u5238");
		menu_1.add(coupon_manager);
		
		add_coupon = new JMenuItem("\u53D1\u653E\u4F18\u60E0\u5238");
		add_coupon.addActionListener(this);
		coupon_manager.add(add_coupon);
		
		delete_coupon = new JMenuItem("\u64A4\u9500\u4F18\u60E0\u5238");
		delete_coupon.addActionListener(this);
		coupon_manager.add(delete_coupon);
		
		JMenu mnNewMenu = new JMenu("\u7F16\u8F91\u5546\u54C1\u91C7\u8D2D\u5355");
		menu_1.add(mnNewMenu);
		
		pro_stock = new JMenuItem("\u5BF9\u9009\u4E2D\u5546\u54C1\u91C7\u8D2D");
		mnNewMenu.add(pro_stock);
		pro_stock.addActionListener(this);
		
		shop_menu_edit = new JMenuItem("\u7F16\u8F91\u91C7\u8D2D\u8BA2\u5355\u72B6\u6001");
		mnNewMenu.add(shop_menu_edit);
		
		edit_menu = new JMenuItem("\u7F16\u8F91\u83DC\u5355");
		menu_1.add(edit_menu);
		edit_menu.addActionListener(this);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setText("\u8F93\u5165\u751F\u9C9C\u540D\u67E5\u8BE2");
		textField.setFont(new Font("宋体", Font.PLAIN, 15));
		textField.setForeground(Color.BLACK);
		textField.setBounds(176, 10, 390, 43);
		contentPane.add(textField);
		textField.setColumns(10);
		
		name_search = new JButton("\u641C\u7D22");
		name_search.setBounds(643, 10, 93, 43);
		name_search.addActionListener(this);
		contentPane.add(name_search);
		
		
		
		
		label = new JLabel("\u6B22\u8FCE");
		label.setBounds(10, 498, 537, 15);
		contentPane.add(label);
		
		//table_pro = new JTable();
		//table_pro.setBackground(Color.LIGHT_GRAY);
		//table_pro.setBounds(338, 79, 318, 332);
		//contentPane.add(table_pro);
		if(Bean_user.currentLoginUser.getManager()==0) {
				this.menu_1.setVisible(false);
			}
		
		JScrollPane scrollPane = new JScrollPane(table_type);
		scrollPane.setBounds(10, 79, 318, 409);
		contentPane.add(scrollPane);
		
		mntmNewMenuItem = new JMenuItem("New menu item");
		scrollPane.setColumnHeaderView(mntmNewMenuItem);
		
		
		JScrollPane scrollPane_pro = new JScrollPane(table_pro);
		scrollPane_pro.setBounds(338, 79, 398, 409);
		contentPane.add(scrollPane_pro);
		
		button_purchase = new JButton("\u52A0\u5165\u8D2D\u7269\u8F66");
		button_purchase.setBounds(760, 79, 106, 61);
		button_purchase.addActionListener(this);
		contentPane.add(button_purchase);
		
		promotion_b = new JButton("\u9650\u65F6\u4FC3\u9500\uFF01\uFF01\uFF01");
		promotion_b.setBounds(760, 166, 127, 70);
		promotion_b.addActionListener(this);
		contentPane.add(promotion_b);
		
		lblNewLabel = new JLabel("\u79CD\u7C7B\u5217\u8868\uFF1A");
		lblNewLabel.setBounds(10, 57, 74, 15);
		contentPane.add(lblNewLabel);
		
		label_1 = new JLabel("\u5546\u54C1\u5217\u8868\uFF1A");
		label_1.setBounds(338, 57, 106, 15);
		contentPane.add(label_1);
		
		JButton menu_button = new JButton("\u83DC\u8C31\u63A8\u8350");
		menu_button.setBounds(756, 246, 131, 70);
		contentPane.add(menu_button);
		
		hot_pro = new JButton("\u70ED\u9500\u5546\u54C1\u63A8\u8350");
		hot_pro.setBounds(760, 334, 127, 70);
		hot_pro.addActionListener(this);
		contentPane.add(hot_pro);
		
		if(Bean_user.currentLoginUser.getManager()==0) {
				this.menu_1.setVisible(false);
			}
		
		
		
		this.reloadTypeTable();
		if(Bean_user.currentLoginUser.getVip_valid()==1)
			this.label.setText("欢迎尊敬的VIP会员： "+Bean_user.currentLoginUser.getName());
		else
			this.label.setText("欢迎尊敬用户： "+Bean_user.currentLoginUser.getName());
		table_type.addMouseListener(new MouseAdapter (){	
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=Frm_Index.this.table_type.getSelectedRow();
				
				if(i<0) {
					return;
				}
				
				Frm_Index.this.reload_pro(i);
				
			}	    	
	    });
		table_pro.addMouseListener(new MouseAdapter (){	
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=Frm_Index.this.table_pro.getSelectedRow();
				
				if(i<0) {
					return;
				}
				
				curPro=allPro.get(i);
				
			}	    	
	    });
		
	}
	private JPanel contentPane;
	private JTextField textField;
	private JMenuItem change_pwd;
	private JMenuItem edit_user_date;
	private JMenuItem load_user_data;
	private JMenuItem load_coupon;
	private JMenuItem shop_menu;
	private JMenu menu_1;
	private JMenuItem user_edit=null;
	private JMenuItem user_delete=null;
	private JMenuItem add_pr=null,delete_pr=null;
	
	private Frm_ChangePwd dlgChangePwd =null;
	private Frm_UserData dlgUserData=null;
	private Frm_UserData_Display dlgUserDataDisplay=null;
	private Frm_ProAdd dlgProAdd=null;	
	private Frm_ProEdit dlgProEdit=null;
	private Frm_TypeAdd dlgTypeAdd=null;
	private Frm_TypeEdit dlgTypeEdit=null;
	private Frm_ShopMenu dlgShopMenu=null;
	private Frm_PurchaseQuantity dlgQ=null;
	private Frm_Address dlgAdd=null;
	private Frm_CouponAdd dlgCoupAdd=null;
	private Frm_CouponDelete dlgCoupDelete=null;
	private Frm_CouponDisplay dlgCoupDisplay=null;
	private Frm_UserDelete dlgUserDelete=null;
	private Frm_UserEdit dlgUserEdit=null;
	private Frm_OrderDisplay dlgOrderDisplay=null;
	private Frm_CommentDisplay dlgCommentDisplay=null;
	private Frm_PrAdd dlgPrAdd=null;
	private Frm_ShopMenuQuatity dlgShopMenuQuatity=null;
	private Frm_ShopMenuEdit dlgShopMenuEdit=null;
	private Frm_Menu dlgMenu=null;
	
	private JButton name_search,promotion_b, hot_pro ;
	
	
	@Override
	public void actionPerformed(ActionEvent e){
		// TODO 自动生成的方法存根
		if(e.getSource()==this.change_pwd) {
			dlgChangePwd=new Frm_ChangePwd(this,"修改密码",true);
			dlgChangePwd.setVisible(true);
		}
		else if(e.getSource()==this.edit_user_date) {
			dlgUserData=new Frm_UserData(this,"个人信息修改",true);
			dlgUserData.setVisible(true);
		}
		else if(e.getSource()==this.load_user_data) {
			dlgUserDataDisplay=new Frm_UserData_Display();
			dlgUserDataDisplay.setVisible(true);
		}
		
		else if(e.getSource()==this.load_coupon) {
			dlgCoupDisplay=new Frm_CouponDisplay();
			dlgCoupDisplay.setVisible(true);
		}
		else if(e.getSource()==this.add_pr) {
			if(curPro==null) {
				JOptionPane.showMessageDialog(null, "请先选中商品", "错误", JOptionPane.ERROR_MESSAGE);
				return;
			}
			this.dlgPrAdd=new Frm_PrAdd(curPro);
			dlgPrAdd.setVisible(true);
		}
		else if(e.getSource()==this.delete_pr) {
			if(curPro==null) {
				JOptionPane.showMessageDialog(null, "请先选中商品", "错误", JOptionPane.ERROR_MESSAGE);
				return;
			}			
			start.Online_Market_Util.production_Manager.delete_pr(curPro);			
			JOptionPane.showMessageDialog(null, "成功移除促销商品", "成功", JOptionPane.INFORMATION_MESSAGE);
			
		}
		else if(e.getSource()==this.shop_menu) {
			this.dlgShopMenu=new Frm_ShopMenu(this.pro_list);
			this.dlgShopMenu.setVisible(true);
		}
		else if(e.getSource()==this.add_coupon) {
			dlgCoupAdd=new Frm_CouponAdd();
			this.dlgCoupAdd.setVisible(true);
		}
		else if(e.getSource()==this.delete_coupon) {
			this.dlgCoupDelete=new Frm_CouponDelete();
			this.dlgCoupDelete.setVisible(true);
		}
		else if(e.getSource()==this.edit_menu) {
			this.dlgMenu=new Frm_Menu();
			this.dlgMenu.setVisible(true);
		}
		else if(e.getSource()==this.shop_menu_edit) {
			this.dlgShopMenuEdit=new Frm_ShopMenuEdit();
			this.dlgShopMenuEdit.setVisible(true);
		}
		else if(e.getSource()==this.pro_stock) {
			if(curType==null) {
				JOptionPane.showMessageDialog(null, "请先选中种类", "错误", JOptionPane.ERROR_MESSAGE);
				return;
			}
			dlgShopMenuQuatity=new Frm_ShopMenuQuatity(curPro);
			dlgShopMenuQuatity.setVisible(true);
		}
		else if(e.getSource()==this.add_type) {
			dlgTypeAdd = new Frm_TypeAdd(this);
			dlgTypeAdd.setVisible(true);
			this.reloadTypeTable();
		}
		else if(e.getSource()==this.edit_type) {
			if(curType==null) {
				JOptionPane.showMessageDialog(null, "请先选中种类", "错误", JOptionPane.ERROR_MESSAGE);
				return;
			}
			dlgTypeEdit=new Frm_TypeEdit(curType,this);
			dlgTypeEdit.setVisible(true);
			
			this.reloadTypeTable();
		}
		else if(e.getSource()==this.delete_type) {
			if(curType==null) {
				JOptionPane.showMessageDialog(null, "请先选中种类", "错误", JOptionPane.ERROR_MESSAGE);
				return;
			}
			start.Online_Market_Util.production_Manager.delete_type(curType);
			this.reloadTypeTable();
			curType=null;
		}
		else if(e.getSource()==this.add_pro) {
			if(curType==null) {
				JOptionPane.showMessageDialog(null, "请先选中种类", "错误", JOptionPane.ERROR_MESSAGE);
				return;
			}
			dlgProAdd = new Frm_ProAdd(this);
			dlgProAdd.type=curType;
			dlgProAdd.setVisible(true);
			//this.reloadTypeTable();
			curType=null;
		}
		else if(e.getSource()==this.edit_pro) {
			if(curPro==null) {
				JOptionPane.showMessageDialog(null, "请先选中商品", "错误", JOptionPane.ERROR_MESSAGE);
				return;
			}
			dlgProEdit = new Frm_ProEdit(curPro);
			dlgProEdit.setVisible(true);
			curType=null;
		}
		else if(e.getSource()==this.delete_pro) {
			if(curPro==null) {
				JOptionPane.showMessageDialog(null, "请先选中商品", "错误", JOptionPane.ERROR_MESSAGE);
				return;
			}
			start.Online_Market_Util.production_Manager.delete_pro(curPro);
			JOptionPane.showMessageDialog(null, "成功下架商品", "成功", JOptionPane.INFORMATION_MESSAGE);
			this.reloadTypeTable();
			curPro=null;
		}
		else if(e.getSource()==this.button_purchase) {
			if(curPro==null) {
				JOptionPane.showMessageDialog(null, "请先选中商品", "错误", JOptionPane.ERROR_MESSAGE);
				return;
			}
			dlgQ=new Frm_PurchaseQuantity(curPro,pro_list);
			dlgQ.setVisible(true);
			//pro_list.add(curPro);
			curPro=null;
			
		}
		else if(e.getSource()==this.name_search) {
			this.reload_pro(textField.getText());
		}
		else if(e.getSource()==this.add_vip) {
			start.Online_Market_Util.user_Manager.add_vip(Bean_user.currentLoginUser);
		}
		else if(e.getSource()==this.edit_address) {
			dlgAdd=new Frm_Address();
			dlgAdd.setVisible(true);
		}
		else if(e.getSource()==this.user_edit) {
			this.dlgUserEdit=new Frm_UserEdit();
			this.dlgUserEdit.setVisible(true);			
		}
		else if(e.getSource()==this.user_delete) {
			this.dlgUserDelete=new Frm_UserDelete();
			this.dlgUserDelete.setVisible(true);
		}
		else if(e.getSource()==this.shop_record) {
			dlgOrderDisplay=new Frm_OrderDisplay();
			this.dlgOrderDisplay.setVisible(true);
		}
		else if(e.getSource()==this.load_comment) {
			if(curPro==null) {
				JOptionPane.showMessageDialog(null, "请先选中商品", "错误", JOptionPane.ERROR_MESSAGE);
				return;
			}
			this.dlgCommentDisplay=new Frm_CommentDisplay(curPro);
			this.dlgCommentDisplay.setVisible(true);
		}
		else if(e.getSource()==promotion_b) {
			this.reload_pr();
		}
		else if(e.getSource()==hot_pro) {
			this.reload_pro(Bean_user.currentLoginUser);
		}
	}

	private List<Bean_production> pro_list = new ArrayList<Bean_production>();
	//private Frm_
	private Object table_type_data[][];
	private Object type_tile[]=Bean_type.tableTitles;
	DefaultTableModel type_model=new DefaultTableModel();
	private JTable table_type=new JTable(type_model);
	
	 
	
	
	List<Bean_production> allPro=null;
	List<Bean_type> allType=null;
	Bean_type curType=null;
	Bean_production curPro=null;
	public void reloadTypeTable(){
		try {
			allType=start.Online_Market_Util.production_Manager.load_all_type();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		table_type_data =  new Object[allType.size()][Bean_type.tableTitles.length];
		for(int i=0;i<allType.size();i++){
			for(int j=0;j<Bean_type.tableTitles.length;j++)
				table_type_data[i][j]=allType.get(i).getCell(j);
		}
		type_model.setDataVector(table_type_data,type_tile);
		this.table_type.validate();
		this.table_type.repaint();
	}
	
	private Object table_pro_data[][];
	private Object pro_tile[]=Bean_production.tableTitles;
	DefaultTableModel pro_model=new DefaultTableModel();
	private JTable table_pro=new JTable(pro_model);
	private JButton button_purchase;
	private JMenu pro_manager;
	private JMenuItem add_pro;
	private JMenuItem delete_pro;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem add_type;
	private JMenuItem delete_type;
	private JMenuItem edit_type;
	private JMenuItem edit_pro;
	private JMenuItem add_vip;
	private JMenuItem shop_record;
	private JMenu menu_2;
	private JMenuItem load_comment;
	private JMenuItem edit_address;
	private JMenuItem add_coupon,delete_coupon;
	
	
	public void reload_pro(int planIdx){
		if(planIdx<0) return;
		curType=allType.get(planIdx);
		try {
			allPro=start.Online_Market_Util.production_Manager.load_pro(curType);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		table_pro_data =new Object[allPro.size()][Bean_production.tableTitles.length];
		for(int i=0;i<allPro.size();i++){
			for(int j=0;j<Bean_production.tableTitles.length;j++)
				table_pro_data[i][j]=allPro.get(i).getCell(j);
		}
		
		pro_model.setDataVector(table_pro_data,pro_tile);
		this.table_pro.validate();
		this.table_pro.repaint();	
	}
	public void reload_pro(String name){
		if(name.equals("")) return;
		try {
			allPro=start.Online_Market_Util.production_Manager.load_pro(name);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		table_pro_data =new Object[allPro.size()][Bean_production.tableTitles.length];
		for(int i=0;i<allPro.size();i++){
			for(int j=0;j<Bean_production.tableTitles.length;j++)
				table_pro_data[i][j]=allPro.get(i).getCell(j);
		}
		
		pro_model.setDataVector(table_pro_data,pro_tile);
		this.table_pro.validate();
		this.table_pro.repaint();	
	}
	public void reload_pro(Bean_user user){
		
		try {
			allPro=start.Online_Market_Util.production_Manager.load_pro(user);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		table_pro_data =new Object[allPro.size()][Bean_production.tableTitles.length];
		for(int i=0;i<allPro.size();i++){
			for(int j=0;j<Bean_production.tableTitles.length;j++)
				table_pro_data[i][j]=allPro.get(i).getCell(j);
		}
		
		pro_model.setDataVector(table_pro_data,pro_tile);
		this.table_pro.validate();
		this.table_pro.repaint();	
	}
	String tabel_pr[]= {"名称","商品原价","促销价","规格","剩余数量","详情","开始日期 ","结束日期" };
	private JLabel lblNewLabel;
	private JLabel label_1;
	private JMenuItem edit_menu;
	public void reload_pr(){
		try {
			allPro=start.Online_Market_Util.production_Manager.load_pr();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		table_pro_data =new Object[allPro.size()][tabel_pr.length];
		int t=0;
		for(int i=0;i<allPro.size();i++){
			for(int j=0;j<tabel_pr.length;j++) {
				if(j>=6)
					t=j+1;
				else
					t=j;
				table_pro_data[i][j]=allPro.get(i).getCell(t);
			}
				
		}
		
		pro_model.setDataVector(table_pro_data,tabel_pr);
		this.table_pro.validate();
		this.table_pro.repaint();	
	}
}
