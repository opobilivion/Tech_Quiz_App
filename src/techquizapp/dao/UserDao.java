/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import techquizapp.dbutil.DBConnectionQuiz;
import techquizapp.pojo.UserPojo;

/**
 *
 * @author OP
 */
public class UserDao {
    public static boolean validateUser(UserPojo user) throws SQLException
    {
        Connection con=DBConnectionQuiz.getConnection();
        PreparedStatement ps=con.prepareStatement("select * from users where userid=? and password=? and usertype=?");
        ps.setString(1,user.getUserId());
        ps.setString(2,user.getPassword());
        ps.setString(3,user.getUserType());
        ResultSet rs=ps.executeQuery();
        return rs.next();
    }
  /*  public static ResultSet setCombobox() throws SQLException
    {
         Connection con=DBConnectionQuiz.getConnection();
         PreparedStatement ps=con.prepareStatement("select userid from users ");
         ResultSet rs=ps.executeQuery();
         return rs;
    }*/
    public static boolean addUser(UserPojo user)throws SQLException
    {
        String qry="select * from users where userid=?";
        boolean status=true;
        Connection conn=DBConnectionQuiz.getConnection();
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1,user.getUserId());
        ResultSet rs=ps.executeQuery();
        if(rs.next())            //iska mtlb h ki is naam ka user phle se aviliable to status false ie user add nahi krna h.
             status=false;     
        else
        {
            qry="insert into users values(?,?,?)";
            ps=conn.prepareStatement(qry);
            ps.setString(1,user.getUserId());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getUserType());
            ps.executeUpdate();
        }
        return status;
    }
    
    public static boolean changePassword(String userid,String password)throws SQLException{
        String qry="Update users set password=? where userid=?";
        boolean status=true;
        Connection conn=DBConnectionQuiz.getConnection();
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1,password);
        ps.setString(2,userid);
        int ans=ps.executeUpdate();
        if(ans==0)
               status=false;
     return status;
     } 
}
