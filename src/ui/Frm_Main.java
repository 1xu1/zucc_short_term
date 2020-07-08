package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.*;
import model.*;
import ui.*;
import util.*;

public class Frm_Main extends JFrame implements ActionListener{
	private Frm_Login dlgLogin=null;
	private Frm_Index dlgIndex=null;
	
	public Frm_Main(){
		
		dlgLogin=new Frm_Login(this,"登陆",true);
		dlgLogin.setVisible(true);
		
		//载入当前用户数据
		Bean_user.currentLoginUser=start.Online_Market_Util.user_Manager.load_user_data();
		
		
		dlgIndex=new Frm_Index();
		dlgIndex.setVisible(true);
		
		
	}
	public void actionPerformed(ActionEvent e) {
		
	}
}
