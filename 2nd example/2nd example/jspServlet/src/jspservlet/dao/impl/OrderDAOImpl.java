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
逻辑：随机生成的OrderID，选择使用UserID+随机生成4位数实现
第一次连接，User_address，User_userID,生成orderID，status。
第二次连接，放进去。
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
        // 下面是针对数据库的具体操作
        try{
            // 连接数据库
            dbc1 = new DBConnect() ;
            pstmt1 = dbc1.getConnection().prepareStatement(sql1) ;
            pstmt1.setInt(1,userID);// 进行数据库查询操作
            ResultSet rs = pstmt1.executeQuery();
            while(rs.next()){
                //查询出内容\
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
        int orderID = random.nextInt(6000) + 4000;//生成orderID
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeNow = sdf.format(d);
        String sql2 = "INSERT INTO all_order(orderID,oPrice,address,oDate,User_userID)values(?,?,?,?,?)";
        //该语句为每个 IN 参数保留一个问号（“？”）作为占位符
			//和数据库取得连接
        PreparedStatement pstmt2;		//创建statement
        try{
            pstmt2 = dbc1.getConnection().prepareStatement(sql2) ;
            pstmt2.setInt(1,orderID);
            pstmt2.setDouble(2,ord.getoPrice()); //给占位符赋值
            pstmt2.setString(3,address); //给占位符赋值
            pstmt2.setString(4,timeNow); //给占位符赋值
            pstmt2.setInt(5,userID); //给占位符赋值

            pstmt2.execute();
            flag3 = 1;
        }catch(SQLException e){
            e.printStackTrace();
            flag3 = 0;
        }
        finally{
            dbc1.close();//必须关闭
        }
        //判断
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
            // 连接数据库
            dbc1 = new DBConnect() ;
            pstmt = dbc1.getConnection().prepareStatement(sql) ;
            pstmt.setInt(1,userID);// 进行数据库查询操作
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                //查询出内容\
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
        DBConnect dbc3 = null;				//和数据库取得连接
        PreparedStatement pstmt;
        try{
            dbc3 = new DBConnect() ;
            pstmt = dbc3.getConnection().prepareStatement(sql) ;
            pstmt.setInt(1,ord.getOrderID()); //给占位符赋值
            pstmt.executeUpdate();//执行
        }catch(SQLException e){
            e.printStackTrace();
        }

        int flag2;
        String sql2 = "DELETE FROM all_order WHERE orderID = ?";
        PreparedStatement pstmt2;
        try{
            pstmt2 = dbc3.getConnection().prepareStatement(sql2) ;
            pstmt2.setInt(1,ord.getOrderID()); //给占位符赋值
            pstmt2.executeUpdate();//执行
            flag2 = 1;
        }catch(SQLException e){
            e.printStackTrace();
            flag2 = 0;
        }
        finally{
            dbc3.close();//必须关闭
        }
        return flag2;
    }
}
