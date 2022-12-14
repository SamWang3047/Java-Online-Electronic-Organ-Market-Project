package jspservlet.dao;

import jspservlet.vo.Order;
import jspservlet.vo.User;

import java.util.ArrayList;

public interface OrderDAO {
    public int[] AddNewOrder(Order ord, User user) throws Exception;//生成新订单
    public ArrayList queryByUserID(Order ord, User user) throws Exception;//订单排序
    public int DeleteOrder(Order ord) throws Exception;//删除订单

}
