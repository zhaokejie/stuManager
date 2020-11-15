package Dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Service.user.UserType;
import Service.user.IaboutAccount;
import Service.user.*;
import db.DBConnection;


public class AccountTools implements IaboutAccount {
    public boolean  addAccount(int UID,String password,UserType u){

       return true;
    }
    //如果添加成功返回true

    public Student getStudent(String somewhere){       //查询，自定义查询条件，返回符合条件的单个学生
        Connection con = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        Student resultStudent=null;
        try {
            con = DBConnection.getDBconnection();
            prepStmt = con.prepareStatement("SELECT * FROM student_table"+somewhere);
            rs = prepStmt.executeQuery();
            if(rs.next()) {

                          //下面根据数据库具体的定义情况来
                resultStudent.setUID(rs.getInt(1));//学号
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
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeDB(con, prepStmt, rs);
        }
        return resultStudent;
    }


    public Manager getManager(String somewhere){      //查询，自定义查询条件，返回符合条件的单个管理员
        Connection con = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        Manager resultManager=null;
        try {
            con = DBConnection.getDBconnection();
            prepStmt = con.prepareStatement("SELECT * FROM Manager_table"+somewhere);
            rs = prepStmt.executeQuery();
            if(rs.next()) {

                //下面根据数据库具体的定义情况来
                resultManager.setUID(rs.getInt(1));//学号
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
