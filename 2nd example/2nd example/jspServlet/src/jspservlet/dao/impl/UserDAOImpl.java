package jspservlet.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import jspservlet.dao.UserDAO;
import jspservlet.db.DBConnect;
import jspservlet.vo.Product;
import jspservlet.vo.User;


public class UserDAOImpl implements UserDAO {

	public int queryByUsername(User user) throws Exception {
		// TODO Auto-generated method stub
		int flag = 0;
		String sql = "select * from user where userID=?";
        PreparedStatement pstmt = null ;   
        DBConnect dbc = null;   
  
        // 下面是针对数据库的具体操作   
        try{   
            // 连接数据库   
            dbc = new DBConnect() ;   
            pstmt = dbc.getConnection().prepareStatement(sql) ; 
            pstmt.setInt(1,user.getUserID()) ;
            // 进行数据库查询操作   
            ResultSet rs = pstmt.executeQuery();
            System.out.println(user.getUserID());
            if(rs.next()){
                // 查询出内容，之后将查询出的内容赋值给person对象   
                if(rs.getString("uPassword").equals(user.getuPassword())){
                	flag = 1;
                } 
            }   
            rs.close() ; 
            pstmt.close() ;   
        }catch (SQLException e){   
            System.out.println(e.getMessage());   
        }finally{   
            // 关闭数据库连接   
            dbc.close() ;   
        }   
		return flag;
	}

    @Override
    public int[] addUser(User user) throws SQLException {
	    int flag = 0;
        Random random = new Random();
        int userID_temp = random.nextInt(1000000);

        String sql = "INSERT INTO user(userID,uName,uPassword,uDate," +
                "gender,tel,address)values(?,?,?,CURRENT_DATE,?,?,?)";
        //该语句为每个 IN 参数保留一个问号（“？”）作为占位符
        DBConnect dbc1 = null;				//和数据库取得连接
        PreparedStatement pstmt = null;		//创建statement
        try{
            dbc1 = new DBConnect() ;
            pstmt = dbc1.getConnection().prepareStatement(sql) ;
            pstmt.setInt(1,userID_temp);
            pstmt.setString(2,user.getuName()); //给占位符赋值
            pstmt.setString(5,user.getTel()); //给占位符赋值
            pstmt.setString(3,user.getuPassword()); //给占位符赋值
            pstmt.setString(6,user.getAddress()); //给占位符赋值
            pstmt.setString(4,user.getGender()); //给占位符赋值
            pstmt.executeUpdate();//执行
            flag = 1;
        }catch(SQLException e){
            e.printStackTrace();
            flag = 0;
        }
        finally{
            dbc1.close();//必须关闭
        }
        return new int[]{flag, userID_temp};
    }

    @Override
    public int updateUser(User user) throws Exception {
	    int flag = 0;
	    String sql ="UPDATE user SET " +
                "uName=?,uPassword=?,gender=?,tel=?,address=? WHERE userID=?";
        DBConnect dbc2 = null;				//和数据库取得连接
        PreparedStatement pstmt = null;
        try{
            dbc2 = new DBConnect() ;
            pstmt = dbc2.getConnection().prepareStatement(sql) ;
            pstmt.setInt(6,user.getUserID()); //给占位符赋值
            pstmt.setString(1,user.getuName()); //给占位符赋值
            pstmt.setString(4,user.getTel()); //给占位符赋值
            pstmt.setString(2,user.getuPassword()); //给占位符赋值
            pstmt.setString(5,user.getAddress()); //给占位符赋值
            pstmt.setString(3,user.getGender()); //给占位符赋值
            pstmt.executeUpdate();//执行
            flag = 1;
        }catch(SQLException e){
            e.printStackTrace();
            flag = 0;
        }
        finally{
            dbc2.close();//必须关闭
        }
        return flag;

    }

    @Override
    public int delUser(User user) throws Exception {
        int flag = 0;
        String sql = "DELETE FROM user WHERE userID = ?";
        DBConnect dbc3 = null;				//和数据库取得连接
        PreparedStatement pstmt = null;
        try{
            dbc3 = new DBConnect() ;
            pstmt = dbc3.getConnection().prepareStatement(sql) ;
            pstmt.setInt(1,user.getUserID()); //给占位符赋值
            pstmt.executeUpdate();//执行
            flag = 1;
        }catch(SQLException e){
            e.printStackTrace();
            flag = 0;
        }
        finally{
            dbc3.close();//必须关闭
        }
        return flag;

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
                Product product = new Product(rs3.getString("iName"),rs3.getDouble("iPrice"),rs3.getInt("itemID"));
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


