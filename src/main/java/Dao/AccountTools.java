package Dao;


import Service.Model.outComer;
import Service.user.IaboutAccount;
import Service.user.Manager;
import Service.user.Student;
import Service.user.UserType;
import db.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AccountTools implements IaboutAccount {
  //  public boolean  addAccount(int UID,String password,UserType u){

      // return true;
   // }
    //如果添加成功返回true

    public Student getStudent(String somewhere){       //查询，自定义查询条件，返回符合条件的单个学生
        Connection con = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        Student resultStudent=null;
        try {
            con = DBConnection.getDBconnection();
            Statement stmt = con.createStatement();

            // 执行SQL语句
             rs = stmt.executeQuery("select * from stumanager_db.student_table");
           // prepStmt = con.prepareStatement("SELECT * FROM stumanager_db.student_table"+somewhere);
           // rs = prepStmt.executeQuery();
            if(rs.next()) {

                          //下面根据数据库具体的定义情况来
                resultStudent.setUID(rs.getString(1));//学号
                resultStudent.setStudent_Building_ID(rs.getString(2));//寝室号
                resultStudent.setStudent_DormitoryID(rs.getString(3));//寝室号
                resultStudent.setUsername(rs.getString(3));//学号就是用户名
                resultStudent.setpassword(rs.getString(4));//密码
                resultStudent.setStudent_Name(rs.getString(5));
                resultStudent.setStudent_Sex(rs.getString(6));
                resultStudent.setStudent_Class(rs.getString(7));
                resultStudent.setStudent_State(rs.getString(8));
                resultStudent.setStudent_Tel(rs.getString(9));//寝室号

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeDB(con, prepStmt, rs);
        }
        return resultStudent;
    }

    public List<Student> getAllStudent(String somewhere){       //查询，自定义查询条件，返回符合条件的所有学生(学生列表)
        Connection con = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        //Student oneStudent=null;
        List<Student> list = new ArrayList<Student>();
        try {
            con = DBConnection.getDBconnection();
            if(con==null){
                System.out.println("连接数据库失败");
            }
            else {

                // 执行SQL语句
                prepStmt = con.prepareStatement("SELECT * FROM stumanager_db.student_table "+somewhere);
                // prepStmt = con.prepareStatement("select * from stumanager_db.student_table");
                rs = prepStmt.executeQuery();
                while (rs.next()) {
                    Student oneStudent = new Student();
                    //下面根据数据库具体的定义情况来
                    oneStudent.setUID(rs.getString(1));//学号
                    oneStudent.setStudent_Building_ID(rs.getString(3));//寝室号
                    oneStudent.setStudent_DormitoryID(rs.getString(4));//寝室号
                    oneStudent.setUsername(rs.getString(5));//学号就是用户名
                    oneStudent.setpassword(rs.getString(5));//密码
                    oneStudent.setStudent_Name(rs.getString(6));
                    oneStudent.setStudent_Sex(rs.getString(7));
                    oneStudent.setStudent_Class(rs.getString(8));
                    oneStudent.setStudent_State(rs.getString(9));
                    oneStudent.setStudent_Tel(rs.getString(10));//寝室号
                    list.add(oneStudent);

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeDB(con, prepStmt, rs);
        }
        return list;
    }
/*
    public void  UpdateStudent(String somewhere) throws Exception{   //修改某个学生的相关信息


        Connection con=null;
        PreparedStatement prepStmt=null;
        ResultSet rs=null;

        try {
            con=DBConnection.getDBconnection();
            if(con==null){
                System.out.println("连接数据库失败");
            }
            else {
                String sql = "update stumanager_db.student_table " + somewhere;
                prepStmt = con.prepareStatement(sql);
                // prepStmt.setString(1,password);
                // prepStmt.setString(2, workId);
                prepStmt.executeUpdate();
            }
        }catch (Exception e)	{
            e.printStackTrace();
        }finally {
            DBConnection.closeDB(con, prepStmt, rs);
        }
    }
*/






    public List<outComer> getAllOutComer(String somewhere){       //查询，自定义查询条件，返回符合条件的所有外来人员(外来人员列表)
        Connection con = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        //Student oneStudent=null;
        List<outComer> list = new ArrayList<outComer>();
        try {
            con = DBConnection.getDBconnection();
            if(con==null){
                System.out.println("连接数据库失败");
            }
            else {

                // 执行SQL语句
                prepStmt = con.prepareStatement("select * from stumanager_db.outcomer_table "+somewhere);
                // prepStmt = con.prepareStatement("select * from stumanager_db.student_table");
                rs = prepStmt.executeQuery();
                while (rs.next()) {
                    outComer oneOutComer = new outComer();
                    //下面根据数据库具体的定义情况来
                    oneOutComer.setName(rs.getString(2));
                    oneOutComer.setSex(rs.getString(3));
                    oneOutComer.setTel(rs.getString(4));
                    oneOutComer.setReason(rs.getString(5));
                    oneOutComer.setComeTime(rs.getString(6));
                    oneOutComer.setLeaveTime(rs.getString(7));
                    oneOutComer.setConnectStudentID(rs.getString(8));
                    oneOutComer.setConnectStudentName(rs.getString(9));
                    oneOutComer.setConnectBuildingID(rs.getString(10));
                    list.add(oneOutComer);

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeDB(con, prepStmt, rs);
        }
        return list;
    }


/*
    public List<hygieneCheckRecord> getAllHygieneCheckRecord(String somewhere){       //查询，自定义查询条件，返回所有符合条件的卫生检查记录(列表)
        Connection con = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        //Student oneStudent=null;
        List<hygieneCheckRecord> list = new ArrayList<hygieneCheckRecord>();
        try {
            con = DBConnection.getDBconnection();
            if(con==null){
                System.out.println("连接数据库失败");
            }
            else {

                // 执行SQL语句
                prepStmt = con.prepareStatement("SELECT * FROM stumanager_db.hygienecheckrecord_table "+somewhere);
                // prepStmt = con.prepareStatement("select * from stumanager_db.student_table");
                rs = prepStmt.executeQuery();
                while (rs.next()) {
                   hygieneCheckRecord oneRecord = new hygieneCheckRecord();
                    //下面根据数据库具体的定义情况来
                    oneRecord.setBuilding_ID(rs.getString(2));//学号
                    oneRecord.setDormitoryID(rs.getString(3));//寝室号
                    oneRecord.setCheckDate(rs.getString(4));//寝室号
                    oneRecord.setScore(rs.getString(5));//学号就是用户名
                    oneRecord.setProblem(rs.getString(6));//密码
                    oneRecord.setRecorder(rs.getString(7));

                    list.add(oneRecord);

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeDB(con, prepStmt, rs);
        }
        return list;
    }
*/



    public Manager getManager(String somewhere){      //查询，自定义查询条件，返回符合条件的单个管理员
        Connection con = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        Manager resultManager=null;
        try {
            con = DBConnection.getDBconnection();
            prepStmt = con.prepareStatement("SELECT * FROM stumanager_db.Manager_table"+somewhere);
            rs = prepStmt.executeQuery();
            if(rs.next()) {

                //下面根据数据库具体的定义情况来
                resultManager.setUID(rs.getString(1));//学号
                resultManager.setManager_Building_ID(rs.getString(2));//所属楼号
                resultManager.setUsername(rs.getString(3));//学号就是用户名
                resultManager.setpassword(rs.getString(4));//密码
                resultManager.setManager_Name(rs.getString(5));
                resultManager.setManager_Sex(rs.getString(6));
                resultManager.setManager_Tel(rs.getString(9));//寝室号
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeDB(con, prepStmt, rs);
        }
        return resultManager;
    }


    public UserType getUserType(int UID){


        String somewhere="Where UID=uid";
        Student stu=getStudent(somewhere);
        Manager man=getManager(somewhere);
        if(stu!=null) {
            return UserType.student;
        }
        else if(man!=null) {
            return UserType.manager;
        }

        return null;
    }
    //返回用户的类型学生 or 管理员


    public String getPassword(int uid) {
       if(getUserType(uid)==UserType.student){
           Student s=getStudent("Where UID="+uid);
           return s.getpassword();
       }
       else if(getUserType(uid)==UserType.manager){
           Manager m=getManager("Where UID="+uid);
           return m.getpassword();
       }

       return "-1";

    }
       // return resultStudent;
    //返回账户的密码,若不存在返回“-1”

    public boolean changePassword(int UID,String newPassword){

      if (getPassword(UID)!=null) {
          if (getUserType(UID) == UserType.student) {
              Student s = getStudent("Where UID=" + UID);
              s.setpassword(newPassword);
          } else if (getUserType(UID) == UserType.student) {
              Manager m = getManager("Where UID=" + UID);
              m.setpassword(newPassword);
          }
          return true;
      }
        return false;

    }
    //修改密码成功返回true


}
