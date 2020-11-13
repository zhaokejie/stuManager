//package Dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import db.DBConnection;
//import Service.Model.Students;
//import Service.Model.Admin;
//import Service.Model.DormManager;
//public class UserLoginDAO {
//    public Students StudentLogin(Students student) throws Exception{
//        Students resultStudent=null;
//
//        Connection con=null;
//        PreparedStatement prepStmt=null;
//        ResultSet rs=null;
//
//        try {
//            con=DBConnection.getDBconnection();
//            prepStmt=con.prepareStatement("SELECT * FROM student_table WHERE Student_ID=? and Student_Password=?");
//            prepStmt.setString(1, student.getStudent_ID());
//            prepStmt.setString(2, student.getStudent_Password());
//            rs=prepStmt.executeQuery();
//            if(rs.next()) {
//                resultStudent=new Students();
//               // resultStudent=new Students();
//
//
//
//                resultStudent.setStudent_ID(rs.getString(1));//学号
//                resultStudent.setStudent_Building_ID(rs.getString(2));//寝室号
//                resultStudent.setStudent_DormitoryID(rs.getString(3));//寝室号
//               // resultStudent.setStudent_Username(rs.getString(3));//学号就是用户名
//                resultStudent.setStudent_Password(rs.getString(4));//密码
//                resultStudent.setStudent_Name(rs.getString(5));
//                resultStudent.setStudent_Sex(rs.getString(6));
//                resultStudent.setStudent_Class(rs.getString(7));
//                resultStudent.setStudent_State(rs.getString(8));
//                resultStudent.setStudent_Tel(rs.getString(9));//寝室号
//
//            }
//        }catch (Exception e)	{
//            e.printStackTrace();
//        }finally {
//            DBConnection.closeDB(con, prepStmt, rs);
//        }
//
//        return resultStudent;
//    }
//
//    public DormManager DormLogin(DormManager dormManager) throws Exception{
//        DormManager resultDormer=null;
//
//        Connection con=null;
//        PreparedStatement prepStmt=null;
//        ResultSet rs=null;
//
//        try {
//            con=DBConnection.getDBconnection();
//            prepStmt=con.prepareStatement("SELECT * FROM dormmanager_table WHERE DormManager_ID=? and DormManager_Password=?");
//            prepStmt.setString(1, dormManager.getDormManager_ID());
//            prepStmt.setString(2, dormManager.getDormManager_Password());
//            rs=prepStmt.executeQuery();
//            if(rs.next()) {
//                resultDormer=new DormManager();
//                resultDormer.setDormManager_ID(rs.getString(1));
//                resultDormer.setDormManager_Building_ID(rs.getString(2));
//                resultDormer.setDormManager_Password(rs.getString(3));
//                resultDormer.setDormManager_Name(rs.getString(4));
//                resultDormer.setDormManager_Sex(rs.getString(5));
//                resultDormer.setDormManager_Tel(rs.getString(6));
//
//            }
//        }
//        catch (Exception e)	{
//            e.printStackTrace();
//        }finally {
//            DBConnection.closeDB(con, prepStmt, rs);
//        }
//
//        return resultDormer;
//    }
//
//    public String getDormId(Students student) throws Exception{
//        Connection con=null;
//        PreparedStatement prepStmt=null;
//        ResultSet rs=null;
//
//        String dormId=null;
//
//        try {
//            con=DBConnection.getDBconnection();
//            String selectDorm="select Student_DomitoryID from student_table  where Student_ID=?";
//            prepStmt=con.prepareStatement(selectDorm);
//            prepStmt.setString(1, student.getStudent_ID());
//            rs=prepStmt.executeQuery();
//            if(rs.next()) {//有记录
//                dormId=rs.getString(1);
//            }
//
//
//        }catch (Exception e)	{
//            e.printStackTrace();
//        }finally {
//            DBConnection.closeDB(con, prepStmt, rs);
//        }
//        return  dormId;
//
//    }
//
//}
//
//
