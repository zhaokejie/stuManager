package Dao;


//import Service.Model.DormManager;
//import Service.Model.Students;
import Service.user.Manager;
import Service.user.Student;
import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class UserLoginDAO2 {
    public Student StudentLogin(Student student) throws Exception{     //根据前端传过来的账号(学号)和密码去数据库中匹配学生对象
        Student resultStudent=null;

        Connection con=null;
        PreparedStatement prepStmt=null;
        ResultSet rs=null;

        try {
            con=DBConnection.getDBconnection();
            prepStmt=con.prepareStatement("SELECT * FROM stumanager_db.student_table WHERE Student_ID=? and Student_Password=?");
            prepStmt.setString(1, student.getUID());
            prepStmt.setString(2, student.getpassword());
            rs=prepStmt.executeQuery();
            if(rs.next()) {    //匹配到之后把当前学生对象的所有属性赋值给resultStudent,最后返回resultStudent
                resultStudent=new Student();
                //resultStudent=new Student();
                resultStudent.setUID(rs.getString(2));   //学号
                resultStudent.setStudent_Building_ID(rs.getString(3));  // 楼号
                resultStudent.setStudent_DormitoryID(rs.getString(4));   //寝室号
                // resultStudent.setStudent_Username(rs.getString(3));   学号就是用户名
                resultStudent.setpassword(rs.getString(5));  // 密码
                resultStudent.setStudent_Name(rs.getString(6));
                resultStudent.setStudent_Sex(rs.getString(7));
                resultStudent.setStudent_Class(rs.getString(8));
                resultStudent.setStudent_State(rs.getString(9));
                resultStudent.setStudent_Tel(rs.getString(10));   //寝室号

            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBConnection.closeDB(con, prepStmt, rs);
        }

        return resultStudent;
    }

    public Manager DormLogin(Manager dormManager) throws Exception{    //根据前端传过来的账号(工号)和密码去数据库中匹配寝室管理员对象
        Manager resultDormer=null;

        Connection con=null;
        PreparedStatement prepStmt=null;
        ResultSet rs=null;

        try {
            con=DBConnection.getDBconnection();
            prepStmt=con.prepareStatement("SELECT * FROM stumanager_db.dormmanager_table WHERE DormManager_ID=? and DormManager_Password=?");
            prepStmt.setString(1, dormManager.getUID());
            prepStmt.setString(2, dormManager.getpassword());
            rs=prepStmt.executeQuery();
            if(rs.next()) {
                resultDormer=new Manager();
                resultDormer.setUID(rs.getString(2));
                resultDormer.setManager_Building_ID(rs.getString(3));
                resultDormer.setpassword(rs.getString(4));
                resultDormer.setManager_Name(rs.getString(5));
                resultDormer.setManager_Sex(rs.getString(6));
                resultDormer.setManager_Tel(rs.getString(7));

            }
        }
        catch (Exception e)  {
            e.printStackTrace();
        }finally {
            DBConnection.closeDB(con, prepStmt, rs);
        }

        return resultDormer;
    }
  /*
    public String getDormId(Student student) throws Exception{
        Connection con=null;
        PreparedStatement prepStmt=null;
        ResultSet rs=null;

        String dormId=null;

        try {
            con=DBConnection.getDBconnection();
            String selectDorm="select Student_DomitoryID from stumanager_db.student_table  where Student_ID=?";
            prepStmt=con.prepareStatement(selectDorm);
            prepStmt.setString(1, student.getUID());
            rs=prepStmt.executeQuery();
            if(rs.next()) {   //有记录
                dormId=rs.getString(1);
            }


        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBConnection.closeDB(con, prepStmt, rs);
        }
        return  dormId;

    }
*/
}


