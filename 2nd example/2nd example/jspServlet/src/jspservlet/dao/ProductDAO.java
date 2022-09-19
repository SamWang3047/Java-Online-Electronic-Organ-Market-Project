package jspservlet.dao;

import jspservlet.vo.Product;

public interface ProductDAO {
    public int queryByItemName(Product pro) throws Exception;
    public int Search(Product pro) throws Exception;
    public Double[] Purchase(Product pro) throws Exception;//生成订单,直接购买（余额减1，生成订单）；
    public int AddCart(Product pro) throws Exception;//加入购物车，不直接购买；
    
}
