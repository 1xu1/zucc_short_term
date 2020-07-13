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

import model.Bean_comment;
import model.Bean_discount_coupon;
import model.Bean_meet_discount;
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
import javax.swing.JCheckBox;

public class Frm_CommentDisplay extends JDialog  implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private Bean_production  curPro=null;
	private int curPro_Index;
	private JFrame f=null;
	
	
	public Frm_CommentDisplay(Bean_production curPro) {
		this.curPro=curPro;
		this.validate();
		setTitle("\u8BC4\u8BBA");
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
		
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,
				(int) (height - this.getHeight()) / 2);
	}
	
	private JButton cancel_button,ok_button;
	private JLabel price=null;
	private Frm_AddSelect dlgAddS=null;
		
	private List<Bean_comment> comment_list =null;
	DefaultTableModel shop_menu_table_model=new DefaultTableModel();
	private JTable shop_menu_table=new JTable(shop_menu_table_model);
	private static final String[] tableTitles = {"姓名","评论","打分","评价日期","点赞数"};
	public void reload_shop_menu(){
		comment_list=start.Online_Market_Util.comment_Manager.load_comment(curPro);
		Object[][] table_pro_data = new Object[this.comment_list.size()+this.comment_list.size()][tableTitles.length];
		for(int i=0;i<comment_list.size();i++){
			for(int j=0;j<tableTitles.length;j++)	 
				table_pro_data[i][j]=comment_list.get(i).getCell(j);
		}				
		
		shop_menu_table_model.setDataVector(table_pro_data,tableTitles);
		this.shop_menu_table.validate();
		this.shop_menu_table.repaint();
		//this.pri
		this.setAlwaysOnTop(true);
	}
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource()==this.ok_button) {
			this.setVisible(false);
		}
										
		else if(e.getSource()==this.cancel_button) {
			this.setVisible(false);
		}
	}
	
	
}
