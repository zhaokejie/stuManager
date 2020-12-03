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

public class Room {

    private int ID;
    private String buildingId;
    private float healthScore;
    private float electricityBalance;
    private float waterBalance;

    public static Room getRoomByID(String buildingId,String roomId) throws IOException {
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

    public static String getRoomJSON(Room room) throws IOException {
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
        json.put("bulidingId",room.buildingId);
        json.put("healthScore",room.healthScore);
        json.put("electricityBalance",room.electricityBalance);
        json.put(("waterBalance"),room.waterBalance);

//        将每个寝室的学生取出放入JSON数组
        JSONArray jsonStu = new JSONArray();
        for(Student stu:stuList)
        {

            jsonStu.put(Student.getStuJSON(stu));

        }
        json.put("studentList",jsonStu);


        myBatisConnect.closeSqlSession();

        return json.toString();

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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
