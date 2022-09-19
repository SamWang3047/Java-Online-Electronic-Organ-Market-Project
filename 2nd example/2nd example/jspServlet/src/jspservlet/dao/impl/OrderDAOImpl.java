package jspservlet.dao.impl;

import jspservlet.dao.OrderDAO;
import jspservlet.db.DBConnect;
import jspservlet.vo.Order;
import jspservlet.vo.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/*
�߼���������ɵ�OrderID��ѡ��ʹ��UserID+�������4λ��ʵ��
��һ�����ӣ�User_address��User_userID,����orderID��status��
�ڶ������ӣ��Ž�ȥ��
*/
public class OrderDAOImpl implements OrderDAO {
    @Override
    public int[] AddNewOrder(Order ord,User user) throws Exception {

        DBConnect dbc1 = null;
        int userID = user.getUserID();
        int flag2 = 0;
        String sql1 = "SELECT address from user WHERE userID = ?";//
        PreparedStatement pstmt1;
        String address = null;
        // ������������ݿ�ľ������
        try{
            // �������ݿ�
            dbc1 = new DBConnect() ;
            pstmt1 = dbc1.getConnection().prepareStatement(sql1) ;
            pstmt1.setInt(1,userID);// �������ݿ��ѯ����
            ResultSet rs = pstmt1.executeQuery();
            while(rs.next()){
                //��ѯ������\
                address = rs.getString("address");
            }
            System.out.println(address);
            rs.close() ;
            pstmt1.close() ;
            flag2 = 1;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }


        int flag3;
        Random random = new Random();
        int orderID = random.nextInt(6000) + 4000;//����orderID
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeNow = sdf.format(d);
        String sql2 = "INSERT INTO all_order(orderID,oPrice,address,oDate,User_userID)values(?,?,?,?,?)";
        //�����Ϊÿ�� IN ��������һ���ʺţ�����������Ϊռλ��
			//�����ݿ�ȡ������
        PreparedStatement pstmt2;		//����statement
        try{
            pstmt2 = dbc1.getConnection().prepareStatement(sql2) ;
            pstmt2.setInt(1,orderID);
            pstmt2.setDouble(2,ord.getoPrice()); //��ռλ����ֵ
            pstmt2.setString(3,address); //��ռλ����ֵ
            pstmt2.setString(4,timeNow); //��ռλ����ֵ
            pstmt2.setInt(5,userID); //��ռλ����ֵ

            pstmt2.execute();
            flag3 = 1;
        }catch(SQLException e){
            e.printStackTrace();
            flag3 = 0;
        }
        finally{
            dbc1.close();//����ر�
        }
        //�ж�
        if (flag2==1&&flag3==1){
            return new int[]{1,orderID};
        }else return new int[]{0,orderID};

    }

    @Override
    public ArrayList queryByUserID(Order ord, User user) throws Exception {
        String sql = "SELECT * FROM all_order WHERE User_userID =?";
        PreparedStatement pstmt;
        DBConnect dbc1;
        int userID = user.getUserID();
        ArrayList order_Full = new ArrayList<Order>();

        try{
            // �������ݿ�
            dbc1 = new DBConnect() ;
            pstmt = dbc1.getConnection().prepareStatement(sql) ;
            pstmt.setInt(1,userID);// �������ݿ��ѯ����
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                //��ѯ������\
                Order o =new Order();
                o.setOrderID(rs.getInt("orderID"));
                o.setoPrice(rs.getDouble("oPrice"));
                o.setAddress(rs.getString("address"));
                o.setDate(rs.getString("oDate"));
                order_Full.add(o);
            }

            rs.close() ;
            pstmt.close() ;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return order_Full;
    }

    @Override
    public int DeleteOrder(Order ord) throws Exception {
        String sql = "DELETE FROM detailed_order WHERE Order_orderID = ?";
        DBConnect dbc3 = null;				//�����ݿ�ȡ������
        PreparedStatement pstmt;
        try{
            dbc3 = new DBConnect() ;
            pstmt = dbc3.getConnection().prepareStatement(sql) ;
            pstmt.setInt(1,ord.getOrderID()); //��ռλ����ֵ
            pstmt.executeUpdate();//ִ��
        }catch(SQLException e){
            e.printStackTrace();
        }

        int flag2;
        String sql2 = "DELETE FROM all_order WHERE orderID = ?";
        PreparedStatement pstmt2;
        try{
            pstmt2 = dbc3.getConnection().prepareStatement(sql2) ;
            pstmt2.setInt(1,ord.getOrderID()); //��ռλ����ֵ
            pstmt2.executeUpdate();//ִ��
            flag2 = 1;
        }catch(SQLException e){
            e.printStackTrace();
            flag2 = 0;
        }
        finally{
            dbc3.close();//����ر�
        }
        return flag2;
    }
}
