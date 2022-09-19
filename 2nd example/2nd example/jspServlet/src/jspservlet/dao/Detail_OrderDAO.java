package jspservlet.dao;

import jspservlet.vo.Detail_Order;
import jspservlet.vo.Order;
import jspservlet.vo.Product;

import java.util.ArrayList;
import java.util.List;

public interface Detail_OrderDAO {
    public int AddNewDetail_Order(Detail_Order de_Ord, Order ord) throws Exception;//生成新订单
    public ArrayList queryByItemID(Detail_Order de_Ord, Order ord) throws Exception;//订单排序
    public List<Product> getALlProducts() throws Exception;
}
