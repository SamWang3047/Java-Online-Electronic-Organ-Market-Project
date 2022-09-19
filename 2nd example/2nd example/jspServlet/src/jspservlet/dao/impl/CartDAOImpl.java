package jspservlet.dao.impl;

import jspservlet.dao.CartDAO;
import jspservlet.db.DBConnect;
import jspservlet.vo.Cart;
import jspservlet.vo.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class CartDAOImpl implements CartDAO {

    @Override
    /*
    ��һ�β�ѯ���
    �ڶ����޸Ŀ��
    �����μ���cart table
     */
    public int addItem(int User_userID, Cart cart) throws Exception {

        //��ѯ���
        int flag2= 0;
        String sql11 = "SELECT remain FROM product WHERE itemID=?";
        PreparedStatement pstmt11 = null ;
        int remain = 0;

        int itemID;
        itemID = cart.getProduct_itemID();
        DBConnect dbc2 = null;

        try{

            dbc2 = new DBConnect() ;
            pstmt11 = dbc2.getConnection().prepareStatement(sql11) ;
            pstmt11.setInt(1, itemID);
            ResultSet rs = pstmt11.executeQuery();

            while(rs.next()){

                remain = rs.getInt("remain");

            }
            rs.close() ;
            pstmt11.close() ;
            flag2 = 1;

        }catch (SQLException e){
            System.out.println(e.getMessage());
            flag2 = 0;
        }finally{

            dbc2.close() ;
        }


        //���¿��
        int flag3 = 0;//���¿��
        String sql12 = "UPDATE product SET remain=? WHERE itemID=?";//
        PreparedStatement pstmt12 = null ;
        DBConnect dbc3 = null;


        try{

            dbc3 = new DBConnect() ;
            pstmt12 = dbc3.getConnection().prepareStatement(sql12) ;
            if(remain >= cart.getcNumber()){
                pstmt12.setInt(1,(remain - cart.getcNumber()));

                pstmt12.setInt(2,itemID);
                boolean rs = pstmt12.execute();
                pstmt12.close() ;
                flag3 = 1;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
            flag3 = 0;
        }finally{
            // �ر����ݿ�����
            dbc3.close() ;
        }


        //
        int flag1 = 0;
        Random random = new Random();
        Integer cartID = random.nextInt(10000);//�������CartID
        String sql1 = "INSERT INTO cart(cartID, cPrice, cNumber, Product_itemID, User_userID)values(?,?,?,?,?)";
        DBConnect dbc1 = null;
        PreparedStatement pstmt1 = null;
        try {
            dbc1 = new DBConnect();
            pstmt1 = dbc1.getConnection().prepareStatement(sql1);
            pstmt1.setInt(1, cartID);
            pstmt1.setDouble(2, (cart.getcPrice()*cart.getcNumber()));
            pstmt1.setInt(3, cart.getcNumber());
            pstmt1.setInt(4, cart.getProduct_itemID());
            pstmt1.setInt(5, User_userID);

            boolean a1 = pstmt1.execute();
            flag1 = 1;
            pstmt1.close();
        } catch (SQLException e) {
            e.printStackTrace();
            flag1 = 0;
        } finally {
            dbc1.close();//�ر�
        }
        if(flag1 ==1 && flag2 ==1 && flag3==1)
        {
            return 1;
        }
        else return 0;

    }

    @Override
    public int changeNum(int User_userID, int Product_itemID, int num) throws Exception {
        DBConnect dbc2 = null;
        int flag2 = 0;
        String sql2 = "UPDATE cart SET cNumber=? WHERE User_userID=? AND Product_itemID=?";

        PreparedStatement pstmt2 = null;
        try {
            dbc2 = new DBConnect();
            pstmt2 = dbc2.getConnection().prepareStatement(sql2);
            pstmt2.setInt(1, num);
            pstmt2.setInt(2, User_userID);
            pstmt2.setInt(3, Product_itemID);

            boolean a2 = pstmt2.execute();
            pstmt2.close();
            flag2 = 1;
        } catch (SQLException e) {
            e.printStackTrace();
            flag2 = 0;
        } finally {
            dbc2.close();//�ر�

        }
        return flag2;
    }


    @Override
    /*��һ�β�ѯ�ܼ�
    �ڶ��β�ѯ��ַ��Ϊ����׼����
    ������д��All_Order���
    ���Ĵβ��num��price��pid��Ϊ����׼����
    �����д��detail_order���
     */

    public int checkOut(int User_userID) throws Exception {

        double price = 0;
        DBConnect dbc3 = null;
        //�����ܼ�
        int flag1=0;
        String sql3 = "SELECT cPrice FROM cart WHERE User_userID = ?";
        PreparedStatement pstmt3 = null;

        try {

            dbc3 = new DBConnect();
            pstmt3 = dbc3.getConnection().prepareStatement(sql3);
            pstmt3.setInt(1, User_userID);// �������ݿ��ѯ����
            ResultSet rs3 = pstmt3.executeQuery();
            while (rs3.next()) {
                //����۸�
                price += rs3.getDouble("cPrice");
            }
            rs3.close();
            pstmt3.close();
            flag1=1;
        } catch (SQLException e) {
            e.printStackTrace();
            flag1=0;
        }


        //��ѯ��ַ
        int flag2=0;
        String sql7 = "SELECT address from user WHERE userID = ?" ;
        PreparedStatement pstmt7 = null ;
        String address = null;
        try{
            // �������ݿ�
            pstmt7 = dbc3.getConnection().prepareStatement(sql7) ;
            pstmt7.setInt(1,User_userID);// �������ݿ��ѯ����
            ResultSet rs = pstmt7.executeQuery();
            while(rs.next()){
                address = rs.getString("address");
            }
            rs.close() ;
            pstmt7.close() ;
            flag2 = 1;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            flag2 = 0;
        }

        //д��All_Order
        int flag3 = 0;
        Random random = new Random();
        Integer orderID = random.nextInt(10000);
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeNow = sdf.format(d);
        String sql8 = "INSERT INTO all_order(orderID,oPrice,address,oDate,User_userID)values(?,?,?,?,?)";

        PreparedStatement pstmt8;
        try{
            pstmt8 = dbc3.getConnection().prepareStatement(sql8) ;
            pstmt8.setInt(1,orderID);
            pstmt8.setDouble(2,price); //��ռλ����ֵ
            pstmt8.setString(3,address); //��ռλ����ֵ
            pstmt8.setString(4,timeNow); //��ռλ����ֵ
            pstmt8.setInt(5,User_userID); //��ռλ����ֵ

            boolean a2 = pstmt8.execute();
            pstmt8.close() ;
            flag3 = 1;
        }catch(SQLException e){
            e.printStackTrace();
            flag3 = 0;
        }

        //Ϊд��Detail_order׼������
        int flag4=0;
        int[] denum=new int[100];
        double[] deprice=new double[100];
        int[] pid=new int[100];
        int i=0;
        String sql9 = "SELECT cPrice,cNumber,Product_itemID From cart WHERE User_userID = ?";

        PreparedStatement pstmt9 = null;
        try{

            pstmt9 = dbc3.getConnection().prepareStatement(sql9) ;
            pstmt9.setInt(1,User_userID);
            ResultSet rs9 = pstmt9.executeQuery();

            while (rs9.next()) {
                deprice[i] = rs9.getDouble("cPrice");
                denum[i] = rs9.getInt("cNumber");
                pid[i] = rs9.getInt("Product_itemID");
                i++;
            }

            rs9.close();
            pstmt9.close();

            flag4 = 1;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            flag4 = 0;
        }

        //д��Detail_order
        int flag5 = 0;

        //���д�벻ͬ��Ʒ

            String sql10 = "INSERT INTO detailed_order(detailed_orderID,iNumber,dPrice,status," +
                    "Order_orderID,Product_itemID,Official_user_official_userID)values(?,?,?,?,?,?,?)";

            PreparedStatement pstmt10 = null;
            try {
                for(int a=0;a<i;a++) {
                int detailed_OrderID = random.nextInt(1000);
                pstmt10 = dbc3.getConnection().prepareStatement(sql10);
                pstmt10.setInt(1, detailed_OrderID);
                pstmt10.setInt(2, denum[a]);
                pstmt10.setDouble(3, deprice[a]);
                pstmt10.setString(4, "ordered");
                pstmt10.setInt(5, orderID);
                pstmt10.setInt(6, pid[a]);
                pstmt10.setInt(7, 304714);
                pstmt10.executeUpdate();//ִ��
                }
                flag5 = 1;
                pstmt10.close() ;
            } catch (SQLException e) {
                e.printStackTrace();
                flag5 = 0;
            }

            //��չ��ﳵ
            int flag6 = 0;
            String sql15 = "DELETE FROM cart WHERE User_userID = ?";
            PreparedStatement pstmt15 = null;
             try{
                 pstmt15 = dbc3.getConnection().prepareStatement(sql15) ;
                 pstmt15.setInt(1,User_userID); //��ռλ����ֵ
                 pstmt15.executeUpdate();//ִ��
                 flag6 = 1;
                 pstmt15.close();
              }catch(SQLException e){
                  e.printStackTrace();
                    flag6 = 0;
                }
            finally {
                dbc3.close();//�ر�
            }



        if (flag1==1 && flag2==1 && flag3==1 && flag4==1 && flag5==1 && flag6==1){
            return 1;
        }
        else return 0;
    }

    @Override
    public List<Cart> getAllItems(int User_userID)throws Exception{
        List<Cart> list=new ArrayList<Cart>();
        DBConnect dbc4 = null;
        int flag4 = 0;
        PreparedStatement pstmt4 = null;
        String sql4="SELECT * FROM cart WHERE User_userID = ?";

        try{
            dbc4 = new DBConnect();
            pstmt4 = dbc4.getConnection().prepareStatement(sql4);
            pstmt4.setInt(1,User_userID);
            ResultSet rs4 = pstmt4.executeQuery();
            while(rs4.next()){
                Cart cart = new Cart(rs4.getInt("cartID"), rs4.getDouble("cPrice"), rs4.getInt("cNumber"), rs4.getInt("Product_itemID"), rs4.getInt("User_userID"));
                list.add(cart);
            }
            flag4=1;
            rs4.close();
            pstmt4.close();
        } catch (SQLException e) {
            e.printStackTrace();
            flag4=0;
        } finally {
            dbc4.close();//�ر�

        }
        return list;
    }


    @Override
    public Cart find(int User_userID,int Product_itemID) throws Exception{
        Cart cart = null;
        String sql5 = "SELECT * FROM cart WHERE User_userID = ? AND Product_itemID = ?";

        DBConnect dbc5 = null;
        PreparedStatement pstmt5 = null;
        try{
            dbc5 = new DBConnect();
            pstmt5 = dbc5.getConnection().prepareStatement(sql5);
            pstmt5.setInt(1,User_userID);
            pstmt5.setInt(2,Product_itemID);
            ResultSet rs5 = pstmt5.executeQuery();
            while(rs5.next()){
                cart = new Cart(rs5.getInt(1),rs5.getDouble(2),rs5.getInt(3),rs5.getInt(4),rs5.getInt(5));

            }
            rs5.close();
            pstmt5.close();
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            dbc5.close();//�ر�

        }
        return cart;
    }

    @Override
    public int deleteItem(int User_userID,int Product_itemID) throws Exception {

        int flag6 = 0;

        String sql6 = "DELET FROM cart WHERE User_userID = ? AND Product_itemID = ?";
        DBConnect dbc6 = null;
        PreparedStatement pstmt6 = null;
        try {
            dbc6 = new DBConnect();
            pstmt6 = dbc6.getConnection().prepareStatement(sql6);
            pstmt6.setInt(1,User_userID);
            pstmt6.setInt(2,Product_itemID);

            boolean a6 = pstmt6.execute();
            flag6 = 1;
            pstmt6.close();
        } catch (SQLException e) {
            e.printStackTrace();
            flag6 = 0;
        } finally {
            dbc6.close();//�ر�
        }
        return flag6;
    }

    @Override
    public double[] allPrice(int User_userID) throws Exception {
        double[] price = new double[2];
        price[0] = 0;
        price[1] = 0;
        DBConnect dbc3 = null;
        //�����ܼ�
        String sql3 = "SELECT cPrice FROM cart WHERE User_userID = ?";
        PreparedStatement pstmt3 = null;

        try {
            dbc3 = new DBConnect();
            pstmt3 = dbc3.getConnection().prepareStatement(sql3);
            pstmt3.setInt(1, User_userID);// �������ݿ��ѯ����
            ResultSet rs3 = pstmt3.executeQuery();
            while (rs3.next()) {
                //����۸�
                price[1] = price[1] + rs3.getDouble("cPrice");
            }
            rs3.close();
            pstmt3.close();
            price[0]=1;
        } catch (SQLException e) {
            e.printStackTrace();
            price[0]=0;
        }

        finally {
        dbc3.close();//�ر�
        }
        return price;
    }

    @Override
    public List<Product> getALlProducts() throws Exception {
        List<Product> productALl =new ArrayList<Product>();
        DBConnect dbc4 = null;
        String sql9 = "SELECT * FROM product";
        PreparedStatement pstmt9 = null;
        try {
            dbc4 = new DBConnect();
            pstmt9 = dbc4.getConnection().prepareStatement(sql9);
            ResultSet rs3 = pstmt9.executeQuery();
            while (rs3.next()) {
                Product product = new Product(rs3.getString("iName"),rs3.getInt("itemID"));
                productALl.add(product);
            }
            rs3.close();
            pstmt9.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbc4.close();//�ر�
        }
        return productALl;
    }


}