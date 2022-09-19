package jspservlet.dao.impl;

import jspservlet.dao.Detail_OrderDAO;
import jspservlet.db.DBConnect;
import jspservlet.vo.Detail_Order;
import jspservlet.vo.Order;
import jspservlet.vo.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Detail_OrderDAOImpl implements Detail_OrderDAO {

    @Override
    public int AddNewDetail_Order(Detail_Order de_Ord, Order ord) throws Exception {

            DBConnect dbc1 = null;
            int flag2 = 0;
            Random random = new Random();
            int detailed_OrderID = random.nextInt(1000);//三位数

            String sql2 = "INSERT INTO detailed_order(detailed_orderID,iNumber,dPrice,status," +
                    "Order_orderID,Product_itemID,Official_user_official_userID)values(?,?,?,?,?,?,?)";
            //该语句为每个 IN 参数保留一个问号（“？”）作为占位符
            //和数据库取得连接
            PreparedStatement pstmt2 = null;		//创建statement
            try{
                dbc1 = new DBConnect() ;
                pstmt2 = dbc1.getConnection().prepareStatement(sql2) ;
                pstmt2.setInt(1,detailed_OrderID); //给占位符赋值
                pstmt2.setInt(2,de_Ord.getNumber()); //给占位符赋值
                pstmt2.setDouble(3,de_Ord.getdPrice()); //给占位符赋值
                pstmt2.setString(4,"ordered"); //给占位符赋值
                pstmt2.setInt(5,de_Ord.getOrder_orderID()); //给占位符赋值
                pstmt2.setInt(6,de_Ord.getProduct_itemID()); //给占位符赋值
                pstmt2.setInt(7,304714); //给占位符赋值
                pstmt2.executeUpdate();//执行
                flag2 = 1;
            }catch(SQLException e){
                e.printStackTrace();
                flag2 = 0;
            }
            finally{
                dbc1.close();//必须关闭
            }
            //判断
            if (flag2==1){
                return 1;
            }else return 0;

        }


    @Override
    public ArrayList queryByItemID(Detail_Order de_Ord, Order ord) throws Exception {
        String sql = "SELECT * FROM detailed_order WHERE Order_orderID =?";
        PreparedStatement pstmt = null ;
        DBConnect dbc1 = null;
        ArrayList detailed_Order_Full = new ArrayList<Detail_Order>();
        int orderID = ord.getOrderID();

        try{
            // 连接数据库
            dbc1 = new DBConnect() ;
            pstmt = dbc1.getConnection().prepareStatement(sql) ;
            pstmt.setInt(1,orderID);// 进行数据库查询操作
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                //查询出内容\
                int i =0;
                Detail_Order de_o =new Detail_Order();
                de_o.setDetailed_orderID(rs.getInt("detailed_orderID"));
                de_o.setNumber(rs.getInt("iNumber"));
                de_o.setdPrice(rs.getInt("dPrice"));
                de_o.setStatus(rs.getString("status"));
                de_o.setOrder_orderID(rs.getInt("Order_orderID"));
                de_o.setProduct_itemID(rs.getInt("Product_itemID"));
                detailed_Order_Full.add(de_o);
            }

            rs.close() ;
            pstmt.close() ;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return detailed_Order_Full;
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
                dbc4.close();//关闭
            }
            return productALl;
        }
    }

