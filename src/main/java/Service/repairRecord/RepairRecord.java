package Service.repairRecord;

import Dao.AccessRecordDaoImpl;
import Dao.MyBatisConnect;
import Dao.RepairRecordDaoImpl;
import Service.repairRecord.RepairRecord;
import Service.repairRecord.RepairRecordDao;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class RepairRecord {

    /* #报修登记
             学号

     寝室楼号

             寝室号

     报修原因

             报修时间
             */
    private int stuId;
    private String buildingId;
    private String roomId;
    private String reason;

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    private String recordDate;

    public static List<RepairRecord> getRepairRecordByID(String buildingId, String roomId) throws IOException {   //通过寝室楼号和房间号返回报修记录的集合
        MyBatisConnect myBatisConnect = new MyBatisConnect();

        SqlSession sqlSession = myBatisConnect.getSqlSession();

        RepairRecordDao repairRecordDao = new RepairRecordDaoImpl(sqlSession);

        HashMap map = new HashMap();
        map.put("roomId", roomId);
        map.put("buildingId", buildingId);

        List<RepairRecord> list = repairRecordDao.getRepairRecordById(map);
        myBatisConnect.closeSqlSession();
        return list;
    }


    public static JSONObject getRecordJSON(RepairRecord repairRecord)
    {
        JSONObject json = new JSONObject();
        json.put("stuId", repairRecord.getStuId());
        json.put("reason",repairRecord.getReason());
        json.put("recordDate",repairRecord.getRecordDate());


        return json;
    }
    public static String getRepairRecordJSON(String buildingId,String roomId) throws IOException {   //根据寝室楼号和房间号返回该寝室的所有报修记录


        JSONObject json = new JSONObject();

        json.put("buildingId",buildingId);
        json.put("roomId",roomId);

      /*  HashMap map = new HashMap();
        map.put("roomId",buildingId);
        map.put("buildingId",roomId);
*/
        MyBatisConnect myBatisConnect = new MyBatisConnect();

     //   SqlSession sqlSession = myBatisConnect.getSqlSession();
        //RepairRecordDao repairRecordDao = new RepairRecordDaoImpl(sqlSession);
        List<RepairRecord> list = RepairRecord.getRepairRecordByID(buildingId,roomId);
        JSONArray jsonRecord= new JSONArray();
        for(RepairRecord record:list)
        {

            jsonRecord.put(RepairRecord.getRecordJSON(record));

        }
        json.put("recordList",jsonRecord);   //把该寝室的报修记录列表放进json








        myBatisConnect.closeSqlSession();

        return json.toString();

    }


    public static boolean insertRepairRecord(RepairRecord repairRecord) throws IOException {
        MyBatisConnect myBatisConnect = new MyBatisConnect();

        SqlSession sqlSession = myBatisConnect.getSqlSession();

        RepairRecordDao repairRecordDao = new RepairRecordDaoImpl(sqlSession);

        repairRecordDao.insertRepairRecord(repairRecord);
        sqlSession.commit();
        myBatisConnect.closeSqlSession();
        return true;
    }

    public static boolean updateRepairRecordInfo(RepairRecord repairRecord) throws IOException {
        RepairRecordDao repairRecordDao;
        MyBatisConnect myBatisConnect = new MyBatisConnect();
        SqlSession sqlSession = myBatisConnect.getSqlSession();
        repairRecordDao = new RepairRecordDaoImpl(sqlSession);
        repairRecordDao.updateRepairRecord(repairRecord);
        sqlSession.commit();
//        Student student = studentDao.getStuInfoById(ID);
        myBatisConnect.closeSqlSession();
        return true;
    }







    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }

    public String getRoomID() {
        return roomId;
    }

    public void setRoomID(String roomId) {
        this.roomId = roomId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }
}

