package jspservlet.dao;

import jspservlet.vo.Product;

public interface ProductDAO {
    public int queryByItemName(Product pro) throws Exception;
    public int Search(Product pro) throws Exception;
    public Double[] Purchase(Product pro) throws Exception;//���ɶ���,ֱ�ӹ�������1�����ɶ�������
    public int AddCart(Product pro) throws Exception;//���빺�ﳵ����ֱ�ӹ���
    
}
