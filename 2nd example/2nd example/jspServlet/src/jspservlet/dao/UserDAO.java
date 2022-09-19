package jspservlet.dao;

import jspservlet.vo.Product;
import jspservlet.vo.User;

import java.util.List;

public interface UserDAO {	
	public int queryByUsername(User user) throws Exception;
	public int[] addUser(User user) throws Exception;
	public int updateUser(User user) throws Exception;
	public int delUser(User user) throws Exception;
	public List<Product> getALlProducts() throws Exception;
}
