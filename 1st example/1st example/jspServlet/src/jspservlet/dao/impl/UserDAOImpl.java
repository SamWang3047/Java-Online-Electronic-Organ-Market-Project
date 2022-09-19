package jspservlet.dao.impl;

import jspservlet.dao.UserDAO;
import jspservlet.vo.User;


public class UserDAOImpl implements UserDAO {


	public int queryByUsername(User user) throws Exception {
		// TODO Auto-generated method stub
		int flag = 0; 
  
        //如果用户输入的用户名是tom，密码是123，那么置标志flag为1.   
        if(user.getUsername().equals("tom")&&user.getPassword().equals("123")){
               flag = 1;
            }   
		return flag;
	}
}

