package Service.pay;

import Dao.MyBatisConnect;
import Dao.PayDaoImpl;
import Service.pay.PayDao;

import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Pay {
  /*  楼号

            寝室号

    缴费金额

    缴费类型（水/电）

    缴费时间
    */


    private String buildingId;
    private String roomId;
    private float cost;
    private String payType;
    private String payDate;

    public static List<Pay> getPayByID(String buildingId, String roomId) throws IOException {   //通过寝室楼号和房间号,缴费类型和缴费日期返回一个缴费记录
        MyBatisConnect myBatisConnect = new MyBatisConnect();

        SqlSession sqlSession = myBatisConnect.getSqlSession();

        PayDao payDao = new PayDaoImpl(sqlSession);

        HashMap map = new HashMap();
        map.put("roomId",roomId);
        map.put("buildingId",buildingId);

        List<Pay> payList = payDao.getPayById(map);
        myBatisConnect.closeSqlSession();
        return payList;
    }

    public static List<Pay> getPayAll(String buildingId, String roomId) throws IOException {   //通过寝室楼号和房间号返回缴费记录的集合
        MyBatisConnect myBatisConnect = new MyBatisConnect();

        SqlSession sqlSession = myBatisConnect.getSqlSession();

        PayDao payDao = new PayDaoImpl(sqlSession);

        HashMap map = new HashMap();
        map.put("roomId",roomId);
        map.put("buildingId",buildingId);

        List<Pay>  list = payDao.getPayAll(map);
        myBatisConnect.closeSqlSession();
        return list;
    }

 /*   private String buildingId;
    private String roomId;
    private float cost;
    private String payType;
    private String payDate;
    */
    public static JSONObject getRecordJSON(Pay pay)
    {
        JSONObject json = new JSONObject();
        json.put("cost",pay.getCost());
        json.put("payType",pay.getPayType());
        json.put("payDate",pay.getPayDate());

        return json;
    }
    public static String getPayJSON(String buildingId,String roomId) throws IOException {   //根据寝室号和房间号返回该寝室所有的缴费记录
    //    String buildingId = String.valueOf(pay.buildingId);
        //String buildingId = room.buildingId;

        JSONObject json = new JSONObject();
        json.put("buildingId",buildingId);
        json.put("roomId",roomId);

        MyBatisConnect myBatisConnect = new MyBatisConnect();

      //  SqlSession sqlSession = myBatisConnect.getSqlSession();
       // PayDao payDao = new PayDaoImpl(sqlSession);
        List<Pay> list = Pay.getPayAll(buildingId,roomId);
        JSONArray jsonRecord= new JSONArray();
        for(Pay record:list)
        {

            jsonRecord.put(Pay.getRecordJSON(record));

        }
        json.put("recordList",jsonRecord);   //把该寝室的缴费记录表放进json








        myBatisConnect.closeSqlSession();

        return json.toString();

    }

    public static boolean insertPay(Pay pay) throws IOException {
        MyBatisConnect myBatisConnect = new MyBatisConnect();

        SqlSession sqlSession = myBatisConnect.getSqlSession();

        PayDao  payDao = new PayDaoImpl(sqlSession);

        payDao.insertPay(pay);
        sqlSession.commit();
        myBatisConnect.closeSqlSession();
        return true;
    }

    public static boolean updatePayInfo(Pay pay) throws IOException {
       PayDao payDao;
        MyBatisConnect myBatisConnect = new MyBatisConnect();
        SqlSession sqlSession = myBatisConnect.getSqlSession();
        payDao = new PayDaoImpl(sqlSession);
       payDao.updatePay(pay);
        sqlSession.commit();
//        Student student = studentDao.getStuInfoById(ID);
        myBatisConnect.closeSqlSession();
        return true;
    }




    public String getBuildingID() {
        return buildingId;
    }

    public void setBuildingID(String buildingId) {
        this.buildingId= buildingId;
    }

    public String getRoomID() {
        return roomId;
    }

    public void setRoomID(String roomId) {
        this.roomId = roomId;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }
    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }
}
