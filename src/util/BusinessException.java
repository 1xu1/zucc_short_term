package util;

import javax.swing.JOptionPane;

public class BusinessException extends BaseException {
	public BusinessException(String msg){
		super(msg);
		JOptionPane.showMessageDialog(null, msg,"����" , JOptionPane.ERROR_MESSAGE);
	}
}
