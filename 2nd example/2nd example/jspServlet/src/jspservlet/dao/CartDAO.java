package jspservlet.dao;

import jspservlet.vo.Cart;
import jspservlet.vo.Product;

import java.util.List;

public interface CartDAO {
    public int addItem(int User_userID, Cart cart) throws Exception;
    public Cart find(int User_userID,int Product_itemID) throws Exception;
    public int changeNum(int User_userID,int Product_itemID,int num)throws Exception;
    public int deleteItem(int User_userID,int Product_itemID) throws Exception;
    public int checkOut (int User_userID) throws Exception;
    public List<Cart> getAllItems(int User_userID)throws Exception;
    public double[] allPrice(int User_userID)throws Exception;
    public List<Product> getALlProducts() throws Exception;
}
