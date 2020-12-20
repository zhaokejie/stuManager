package Service.building;

import Dao.MyBatisConnect;
import Dao.RoomDaoImpl;
import Dao.StudentDaoImpl;
import Service.user.Student;
import Service.user.StudentDao;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Room {     //定义类的属性

    private int ID;
    private String buildingId;
    private float healthScore;
    private float electricityBalance;
    private float waterBalance;

    public static Room getRoomByID(String buildingId,String roomId) throws IOException {   //通过寝室楼号和房间号返回room对象
        MyBatisConnect myBatisConnect = new MyBatisConnect();

        SqlSession sqlSession = myBatisConnect.getSqlSession();

        RoomDao roomDao = new RoomDaoImpl(sqlSession);

        HashMap map = new HashMap();
        map.put("roomId",roomId);
        map.put("buildingId",buildingId);
        Room room = roomDao.getRoomById(map);
        myBatisConnect.closeSqlSession();
        return room;
    }

    public static String getRoomJSON(Room room) throws IOException {   //根据room对象，返回该room的相关信息
        String roomId = String.valueOf(room.getID());
        String buildingId = room.buildingId;
        HashMap map = new HashMap();
        map.put("roomId",roomId);
        map.put("buildingId",buildingId);
        MyBatisConnect myBatisConnect = new MyBatisConnect();

        SqlSession sqlSession = myBatisConnect.getSqlSession();
        StudentDao studentDao = new StudentDaoImpl(sqlSession);
        List<Student> stuList = studentDao.getStuInfoByRoomId(map);
        JSONObject json = new JSONObject();
        json.put("roomId",room.getID());
        json.put("buildingId",room.buildingId);
        json.put("healthScore",room.healthScore);
        json.put("electricityBalance",room.electricityBalance);
        json.put(("waterBalance"),room.waterBalance);

//        将每个寝室的学生取出放入JSON数组
        JSONArray jsonStu = new JSONArray();
        for(Student stu:stuList)
        {

            jsonStu.put(Student.getStuJSON(stu));

        }
        json.put("studentList",jsonStu);   //把该寝室的学生列表放进json


        myBatisConnect.closeSqlSession();

        return json.toString();

    }
    public static boolean insertRoom(Room room) throws IOException {
        MyBatisConnect myBatisConnect = new MyBatisConnect();

        SqlSession sqlSession = myBatisConnect.getSqlSession();

        RoomDao roomDao = new RoomDaoImpl(sqlSession);

        roomDao.insertRoom(room);
        sqlSession.commit();
        myBatisConnect.closeSqlSession();
        return true;
    }

    public static boolean updateRoomInfo(Room room) throws IOException {
        RoomDao roomDao;
        MyBatisConnect myBatisConnect = new MyBatisConnect();
        SqlSession sqlSession = myBatisConnect.getSqlSession();
        roomDao= new RoomDaoImpl(sqlSession);
        roomDao.updateRoom(room);
        sqlSession.commit();
//        Student student = studentDao.getStuInfoById(ID);
        myBatisConnect.closeSqlSession();
        return true;
    }



    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId= buildingId;
    }

    public float getHealthScore() {
        return healthScore;
    }

    public void setHealthScore(float healthScore) {
        this.healthScore = healthScore;
    }

    public float getElectricityBalance() {
        return electricityBalance;
    }

    public void setElectricityBalance(float electricityBalance) {
        this.electricityBalance = electricityBalance;
    }

    public float getWaterBalance() {
        return waterBalance;
    }

    public void setWaterBalance(float waterBalance) {
        this.waterBalance = waterBalance;
    }
}
