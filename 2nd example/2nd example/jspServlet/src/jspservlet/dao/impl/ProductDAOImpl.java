package jspservlet.dao.impl;

import jspservlet.dao.ProductDAO;
import jspservlet.db.DBConnect;
import jspservlet.vo.Order;
import jspservlet.vo.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDAOImpl implements ProductDAO {

    @Override
    public int queryByItemName(Product pro) throws Exception {
        return 0;
    }

    @Override
    public int Search(Product pro) throws Exception {
        return 0;
    }

    @Override
    public Double[] Purchase(Product pro) throws Exception {
        // TODO Auto-generated method stub
        int flag1 = 0;//������Ʒ�Ŀ��ͼ۸�
        String sql = "SELECT remain, iPrice FROM product WHERE itemID=?";//
        PreparedStatement pstmt = null ;
        int remain = 0;
        int itemID = 0;
        int number_Purchase = 0;
        Double iPrice = null;
        DBConnect dbc1 = null;

        // ������������ݿ�ľ������
        try{
            // �������ݿ�
            dbc1 = new DBConnect() ;
            pstmt = dbc1.getConnection().prepareStatement(sql) ;
            pstmt.setInt(1,pro.getItemID());// �������ݿ��ѯ����
            ResultSet rs = pstmt.executeQuery();
            itemID = pro.getItemID();
            while(rs.next()){
                //��ѯ������
                remain = rs.getInt("remain");
                iPrice = rs.getDouble("iPrice");
            }
            rs.close() ;
            pstmt.close() ;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally{
            // �ر����ݿ�����
            dbc1.close() ;
        }

        int flag2 = 0;//���¿��
        String sql1 = "UPDATE product SET remain=? WHERE itemID=?";//
        PreparedStatement pstmt1 = null ;
        DBConnect dbc2 = null;

        // ������������ݿ�ľ������
        try{
            // �������ݿ�
            dbc2 = new DBConnect() ;
            pstmt1 = dbc2.getConnection().prepareStatement(sql1) ;
            if(remain >= pro.getNumber_Purchase()){
                number_Purchase = pro.getNumber_Purchase();
                pstmt1.setInt(1,(remain - number_Purchase));
                iPrice *= number_Purchase;
                pstmt1.setInt(2,itemID);
                boolean rs = pstmt1.execute();
                pstmt1.close() ;
                flag2 = 1;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
            flag2 = 0;
        }finally{
            // �ر����ݿ�����
            dbc2.close() ;
        }

        return new Double[]{(double) flag2, iPrice, (double) number_Purchase};



    }

    @Override
    public int AddCart(Product pro) throws Exception {
        return 0;
    }
}
