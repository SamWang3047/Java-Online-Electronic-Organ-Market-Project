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
  
        // ������������ݿ�ľ������   
        try{   
            // �������ݿ�   
            dbc = new DBConnect() ;   
            pstmt = dbc.getConnection().prepareStatement(sql) ; 
            pstmt.setInt(1,user.getUserID()) ;
            // �������ݿ��ѯ����   
            ResultSet rs = pstmt.executeQuery();
            System.out.println(user.getUserID());
            if(rs.next()){
                // ��ѯ�����ݣ�֮�󽫲�ѯ�������ݸ�ֵ��person����   
                if(rs.getString("uPassword").equals(user.getuPassword())){
                	flag = 1;
                } 
            }   
            rs.close() ; 
            pstmt.close() ;   
        }catch (SQLException e){   
            System.out.println(e.getMessage());   
        }finally{   
            // �ر����ݿ�����   
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
        //�����Ϊÿ�� IN ��������һ���ʺţ�����������Ϊռλ��
        DBConnect dbc1 = null;				//�����ݿ�ȡ������
        PreparedStatement pstmt = null;		//����statement
        try{
            dbc1 = new DBConnect() ;
            pstmt = dbc1.getConnection().prepareStatement(sql) ;
            pstmt.setInt(1,userID_temp);
            pstmt.setString(2,user.getuName()); //��ռλ����ֵ
            pstmt.setString(5,user.getTel()); //��ռλ����ֵ
            pstmt.setString(3,user.getuPassword()); //��ռλ����ֵ
            pstmt.setString(6,user.getAddress()); //��ռλ����ֵ
            pstmt.setString(4,user.getGender()); //��ռλ����ֵ
            pstmt.executeUpdate();//ִ��
            flag = 1;
        }catch(SQLException e){
            e.printStackTrace();
            flag = 0;
        }
        finally{
            dbc1.close();//����ر�
        }
        return new int[]{flag, userID_temp};
    }

    @Override
    public int updateUser(User user) throws Exception {
	    int flag = 0;
	    String sql ="UPDATE user SET " +
                "uName=?,uPassword=?,gender=?,tel=?,address=? WHERE userID=?";
        DBConnect dbc2 = null;				//�����ݿ�ȡ������
        PreparedStatement pstmt = null;
        try{
            dbc2 = new DBConnect() ;
            pstmt = dbc2.getConnection().prepareStatement(sql) ;
            pstmt.setInt(6,user.getUserID()); //��ռλ����ֵ
            pstmt.setString(1,user.getuName()); //��ռλ����ֵ
            pstmt.setString(4,user.getTel()); //��ռλ����ֵ
            pstmt.setString(2,user.getuPassword()); //��ռλ����ֵ
            pstmt.setString(5,user.getAddress()); //��ռλ����ֵ
            pstmt.setString(3,user.getGender()); //��ռλ����ֵ
            pstmt.executeUpdate();//ִ��
            flag = 1;
        }catch(SQLException e){
            e.printStackTrace();
            flag = 0;
        }
        finally{
            dbc2.close();//����ر�
        }
        return flag;

    }

    @Override
    public int delUser(User user) throws Exception {
        int flag = 0;
        String sql = "DELETE FROM user WHERE userID = ?";
        DBConnect dbc3 = null;				//�����ݿ�ȡ������
        PreparedStatement pstmt = null;
        try{
            dbc3 = new DBConnect() ;
            pstmt = dbc3.getConnection().prepareStatement(sql) ;
            pstmt.setInt(1,user.getUserID()); //��ռλ����ֵ
            pstmt.executeUpdate();//ִ��
            flag = 1;
        }catch(SQLException e){
            e.printStackTrace();
            flag = 0;
        }
        finally{
            dbc3.close();//����ر�
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
            dbc4.close();//�ر�
        }
        return productALl;
    }
}


