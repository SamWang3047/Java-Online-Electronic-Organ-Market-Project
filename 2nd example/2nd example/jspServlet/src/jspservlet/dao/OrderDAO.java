package jspservlet.dao;

import jspservlet.vo.Order;
import jspservlet.vo.User;

import java.util.ArrayList;

public interface OrderDAO {
    public int[] AddNewOrder(Order ord, User user) throws Exception;//�����¶���
    public ArrayList queryByUserID(Order ord, User user) throws Exception;//��������
    public int DeleteOrder(Order ord) throws Exception;//ɾ������

}
