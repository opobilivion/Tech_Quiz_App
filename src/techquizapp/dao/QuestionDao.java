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
import java.util.ArrayList;
import techquizapp.dbutil.DBConnectionQuiz;
import techquizapp.pojo.QuestionPojo;
import techquizapp.pojo.QuestionStore;

/**
 *
 * @author OP
 */
public class QuestionDao {
    public static void addQuestion(QuestionStore qs)throws SQLException
    {
        //9
        String qry="insert into questions values(?,?,?,?,?,?,?,?,?)";
        ArrayList<QuestionPojo>questionList=qs.getAllQuestions();
        Connection conn=DBConnectionQuiz.getConnection();
        PreparedStatement ps=conn.prepareStatement(qry);
        for(QuestionPojo obj:questionList)
        {
            ps.setString(1,obj.getExamId());
            ps.setInt(2,obj.getQno());
            ps.setString(3,obj.getQuestion());
            ps.setString(4,obj.getAnswer1());
            ps.setString(5,obj.getAnswer2());
            ps.setString(6,obj.getAnswer());
            ps.setString(7,obj.getAnswer4());
            ps.setString(8,obj.getCorrect_answer());
            ps.setString(9,obj.getLanguage());
            ps.executeUpdate();
        }
                
    }
  public static ArrayList<QuestionPojo> getQuestionByExamId(String examId) throws SQLException
    {
       ArrayList<QuestionPojo> questionList=new ArrayList<>();
       String qry="select * from questions where examid=? order by qno";
       Connection con=DBConnectionQuiz.getConnection();
       PreparedStatement ps=con.prepareStatement(qry);
       ps.setString(1,examId);
       ResultSet rs=ps.executeQuery();
       System.out.println(" Exam Id in DAO is"+examId);
       while(rs.next())
        {
            int qno=-rs.getInt(2);
            String question=rs.getString(3);
            String option1=rs.getString(4);
            String option2=rs.getString(5);
            String option3=rs.getString(6);
            String option4=rs.getString(7);
            String correctAnswer=rs.getString(8);
            String language=rs.getString(9);
            
            QuestionPojo obj=new QuestionPojo(examId,qno,language, question,option1, option2, option3, option4, correctAnswer);
            
            questionList.add(obj);
        }
        return questionList;
        
    }
    
}
