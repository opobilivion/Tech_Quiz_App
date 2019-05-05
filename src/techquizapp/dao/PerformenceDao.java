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
import java.sql.Statement;
import java.util.ArrayList;
import techquizapp.dbutil.DBConnectionQuiz;
import techquizapp.pojo.Performance;
import techquizapp.pojo.StudentScorePojo;

/**
 *
 * @author OP
 */
public class PerformenceDao {
    
    public static ArrayList<String> getAllStudentId()throws SQLException
    {
       String qry="select distinct userid from performance";
       ArrayList<String> studentIdList=new ArrayList<>();
       Connection conn=DBConnectionQuiz.getConnection();
       Statement st=conn.createStatement();
       ResultSet rs=st.executeQuery(qry);
           
           while(rs.next()){
               String id=rs.getString(1);
               studentIdList.add(id);
           }
               
    return studentIdList;                      
   }
 public static ArrayList<String> getAllExamId(String studentId)throws SQLException
 {
     String qry="select examid from performence where userid=?";
       ArrayList<String> examIDList=new ArrayList<>();
       Connection conn=DBConnectionQuiz.getConnection();
       PreparedStatement ps=conn.prepareStatement(qry);
       ps.setString(1,studentId);
       ResultSet rs=ps.executeQuery();
       while(rs.next())
       {
           String id=rs.getString(1);
           examIDList.add(id);
       }
       return examIDList;
 }
 
 public static StudentScorePojo getScore(String studentId,String examId) throws SQLException
 {
     String qry="select language,per from performence where userid=? and examid=?";
     Connection con=DBConnectionQuiz.getConnection();
     PreparedStatement ps=con.prepareStatement(qry);
     ps.setString(1,studentId);
     ps.setString(2,examId);
     ResultSet rs=ps.executeQuery();
     rs.next();
     StudentScorePojo scoreObj=new StudentScorePojo();
     scoreObj.setLanguage(rs.getString(1));
     scoreObj.setPer(rs.getDouble(2));
     return scoreObj;
 }
 
 public static void addPerformance(Performance performance)throws SQLException{
  String qry="Insert into performance values(?,?,?,?,?,?,?)";
  Connection conn=DBConnectionQuiz.getConnection();
  PreparedStatement ps=conn.prepareStatement(qry);
  ps.setString(1, performance.getUserId());
  ps.setString(2, performance.getExamId());
           ps.setInt(3,performance.getRight());
           ps.setInt(4,performance.getWrong());
           ps.setInt(5,performance.getUnattempted());
           ps.setDouble(6,performance.getPer());
           ps.setString(7,performance.getLanguage());
           ps.executeUpdate();
           }

 public static ArrayList<Performance> getAllData()throws SQLException{
       String qry="Select * from Performance";
       ArrayList<Performance> performanceList=new ArrayList<Performance>();
       Connection conn=DBConnectionQuiz.getConnection();
       Statement st=conn.createStatement();
       ResultSet rs=st.executeQuery(qry);
       while(rs.next()){
               String userId=rs.getString("userid");
               String examId=rs.getString("examid");
               String language=rs.getString("language");
               int right=rs.getInt("right");
               int wrong=rs.getInt("wrong");
               int unattempted=rs.getInt("unattempted");
               double per=rs.getDouble("per");
               Performance p=new Performance(examId,language,userId,right,wrong,unattempted,per);
               performanceList.add(p);
          }
       return performanceList;
         
        }


}
