package model;
import util.*;
public  class error_deal {
	public void error_null() throws BusinessException {
		throw new BusinessException("输入不能为空！");
	}
}
