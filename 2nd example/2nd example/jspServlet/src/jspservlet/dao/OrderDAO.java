package jspservlet.dao;

import jspservlet.vo.Order;
import jspservlet.vo.User;

import java.util.ArrayList;

public interface OrderDAO {
    public int[] AddNewOrder(Order ord, User user) throws Exception;//Éú³ÉÐÂ¶©µ¥
    public ArrayList queryByUserID(Order ord, User user) throws Exception;//¶©µ¥ÅÅÐò
    public int DeleteOrder(Order ord) throws Exception;//É¾³ý¶©µ¥

}
