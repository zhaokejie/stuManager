package Service.healthScore;


import Dao.MyBatisConnect;
import Dao.HealthScoreDaoImpl;
import Service.healthScore.HealthScore;
import Service.healthScore.HealthScoreDao;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
public class HealthScore{

/*#卫生评分历史数据：
        楼号

        寝室号

        评分

        时间
        */


    private String buildingId;
    private String roomId;
    private float score;
    private String recordDate;


    public static HealthScore getHealthScoreByID(String buildingId,String roomId,String recordDate) throws IOException {  //根据寝室楼号,房间号,日期来返回一个卫生评分记录
        MyBatisConnect myBatisConnect = new MyBatisConnect();

        SqlSession sqlSession = myBatisConnect.getSqlSession();

        HealthScoreDao healthScoreDao = new HealthScoreDaoImpl(sqlSession);

        HashMap map = new HashMap();
        map.put("roomId",roomId);
        map.put("buildingId",buildingId);
        map.put("recordDate",recordDate);
        HealthScore healthScore = healthScoreDao.getHealthScoreById(map);
        myBatisConnect.closeSqlSession();
        return healthScore;
    }

    public static List<HealthScore> getHealthScoreAll(String buildingId,String roomId) throws IOException {  //根据寝室楼号,房间号返回卫生记录的集合
        MyBatisConnect myBatisConnect = new MyBatisConnect();

        SqlSession sqlSession = myBatisConnect.getSqlSession();

        HealthScoreDao healthScoreDao = new HealthScoreDaoImpl(sqlSession);


        HashMap map = new HashMap();
        map.put("roomId",roomId);
        map.put("buildingId",buildingId);
        List<HealthScore> list = healthScoreDao.getHealthScoreAll(map);
        myBatisConnect.closeSqlSession();
        return list;
    }
    public static JSONObject getScoreJSON(HealthScore healthScore)
    {
        JSONObject json = new JSONObject();

        json.put("score",healthScore.getScore());
        json.put("recordDate",healthScore.getRecordDate());

        return json;
    }
    public static String getHealthScoreJSON(String buildingId,String roomId) throws IOException {   //根据寝室楼号和房间号，返回该寝室对应的所有卫生检查记录
      //  String buildingId = String.valueOf(healthScore.buildingId);
        //String buildingId = room.buildingId;
      /*  HashMap map = new HashMap();
        map.put("buildingId",buildingId);
        map.put("roomId",roomId);
        */
        JSONObject json = new JSONObject();
        json.put("buildingId",buildingId);
        json.put("roomId",roomId);

        MyBatisConnect myBatisConnect = new MyBatisConnect();

     //   SqlSession sqlSession = myBatisConnect.getSqlSession();
       // HealthScoreDao healthScoreDao = new HealthScoreDaoImpl(sqlSession);
        List<HealthScore> list = HealthScore.getHealthScoreAll(buildingId,roomId);
        JSONArray jsonScore= new JSONArray();
        for(HealthScore score:list)
        {

            jsonScore.put(HealthScore.getScoreJSON(score));

        }
        json.put("scoreList",jsonScore);   //把卫生记录表放进json








        myBatisConnect.closeSqlSession();

        return json.toString();

    }


    public String getBuildingID() {
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

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }

}


