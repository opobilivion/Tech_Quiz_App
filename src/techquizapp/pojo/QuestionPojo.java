/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.pojo;

import java.util.Objects;

/**
 *
 * @author OP
 */
public class QuestionPojo       //answer1 -is of 20 length and answer3-is answer .
{

    public QuestionPojo(String examId, int Qno, String language, String answer1, String answer2, String answer, String answer4, String correct_answer, String question) {
        this.examId = examId;
        this.Qno = Qno;
        this.language = language;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer = answer;
        this.answer4 = answer4;
        this.correct_answer = correct_answer;
        this.question = question;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final QuestionPojo other = (QuestionPojo) obj;
        if (this.Qno != other.Qno) {
            return false;
        }
        if (!Objects.equals(this.examId, other.examId)) {
            return false;
        }
        if (!Objects.equals(this.language, other.language)) {
            return false;
        }
        if (!Objects.equals(this.answer1, other.answer1)) {
            return false;
        }
        if (!Objects.equals(this.answer2, other.answer2)) {
            return false;
        }
        if (!Objects.equals(this.answer, other.answer)) {
            return false;
        }
        if (!Objects.equals(this.answer4, other.answer4)) {
            return false;
        }
        if (!Objects.equals(this.correct_answer, other.correct_answer)) {
            return false;
        }
        if (!Objects.equals(this.question, other.question)) {
            return false;
        }
        return true;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public int getQno() {
        return Qno;
    }

    public void setQno(int Qno) {
        this.Qno = Qno;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public String getCorrect_answer() {
        return correct_answer;
    }

    public void setCorrect_answer(String correct_answer) {
        this.correct_answer = correct_answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "QuestionPojo{" + "examId=" + examId + ", Qno=" + Qno + ", language=" + language + ", answer1=" + answer1 + ", answer2=" + answer2 + ", answer=" + answer + ", answer4=" + answer4 + ", correct_answer=" + correct_answer + ", question=" + question + '}';
    }
   private String examId;
   private int Qno;
   private String language;
   private String answer1,answer2,answer,answer4;
   private String correct_answer;
   public String question;
   
}
