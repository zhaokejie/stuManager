package Service.user;

import Dao.StudentDaoImpl;
import Dao.MyBatisConnect;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class Student{

    private int ID;
    private String name;
    private String classId;
    private String mobilePhone;
    private String buildingId;
    private String roomId;
    private String Email;
    private String homeAddress;
    private int cardBalance;


    public static Student getStudentByID(int ID) throws IOException {
        StudentDao studentDao;
        MyBatisConnect myBatisConnect = new MyBatisConnect();
        SqlSession sqlSession = myBatisConnect.getSqlSession();
        studentDao = new StudentDaoImpl(sqlSession);
        Student student = studentDao.getStuInfoById(ID);
        return student;
    }



    public int getId() {
        return ID;
    }

    public void setId(int id) {
        this.ID = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public int getCardBalance() {
        return cardBalance;
    }

    public void setCardBalance(int cardBalance) {
        this.cardBalance = cardBalance;
    }




}