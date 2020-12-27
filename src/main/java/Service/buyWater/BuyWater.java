package Service.buyWater;

import Dao.MyBatisConnect;
import Dao.BuyWaterDaoImpl;
import Service.accessRecord.AccessRecordDao;

import Service.buyWater.BuyWaterDao;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class BuyWater {
  /*  楼号

            寝室号

    缴费金额

    缴费类型（水/电）

    缴费时间
    */


    private String buildingId;
    private String roomId;
    private float cost;
    private String waterType;
    private int buyNumber;
    private String buyDate;
    private String Tel;

    public static List<BuyWater> getBuyWaterByID(String buildingId, String roomId) throws IOException {   //通过寝室楼号和房间号,缴费类型和缴费日期返回一个缴费记录
        MyBatisConnect myBatisConnect = new MyBatisConnect();

        SqlSession sqlSession = myBatisConnect.getSqlSession();

        BuyWaterDao buyWaterDao = new BuyWaterDaoImpl(sqlSession);

        HashMap map = new HashMap();
        map.put("roomId",roomId);
        map.put("buildingId",buildingId);
        List<BuyWater> list = buyWaterDao.getBuyWaterById(map);
        myBatisConnect.closeSqlSession();
        return list;
    }

    public static List<BuyWater> getBuyWaterAll(String buildingId) throws IOException {   //通过寝室楼号和房间号返回缴费记录的集合
        MyBatisConnect myBatisConnect = new MyBatisConnect();

        SqlSession sqlSession = myBatisConnect.getSqlSession();

        BuyWaterDao buyWaterDao = new BuyWaterDaoImpl(sqlSession);

        HashMap map = new HashMap();

        map.put("buildingId",buildingId);

        List<BuyWater>  list = buyWaterDao.getBuyWaterAll(map);
        myBatisConnect.closeSqlSession();
        return list;
    }

    /*   private String buildingId;
       private String roomId;
       private float cost;
       private String buyWaterType;
       private String buyWaterDate;
       */
    public static JSONObject getRecordJSON(BuyWater buyWater)
    {
        JSONObject json = new JSONObject();
        json.put("PayDate",buyWater.getBuyDate());
        json.put("buildingId",buyWater.getBuildingID());
        json.put("roomId",buyWater.getRoomID());
        json.put("PayType",buyWater.getWaterType());
        json.put("PayQuantity",buyWater.getBuyNumber());
        json.put("MobilePhone",buyWater.getTel());

        return json;
    }
    public static String getBuyWaterJSON(String buildingId,String roomId) throws IOException {   //根据寝室号和房间号返回该寝室所有的缴费记录
        //    String buildingId = String.valueOf(buyWater.buildingId);
        //String buildingId = room.buildingId;

        JSONObject json = new JSONObject();
        //json.put("buildingId",buildingId);
        //json.put("roomId",roomId);
        json.put("state",1);

        MyBatisConnect myBatisConnect = new MyBatisConnect();

        //  SqlSession sqlSession = myBatisConnect.getSqlSession();
        // BuyWaterDao buyWaterDao = new BuyWaterDaoImpl(sqlSession);
        List<BuyWater> list = BuyWater.getBuyWaterByID(buildingId,roomId);
        JSONArray jsonRecord= new JSONArray();
        for(BuyWater record:list)
        {

            jsonRecord.put(BuyWater.getRecordJSON(record));

        }
        json.put("recordList",jsonRecord);   //把该寝室的缴费记录表放进json


        myBatisConnect.closeSqlSession();

        return json.toString();

    }

    public static boolean insertBuyWater(BuyWater buyWater) throws IOException {
        MyBatisConnect myBatisConnect = new MyBatisConnect();

        SqlSession sqlSession = myBatisConnect.getSqlSession();

        BuyWaterDao  buyWaterDao = new BuyWaterDaoImpl(sqlSession);

        buyWaterDao.insertBuyWater(buyWater);
        sqlSession.commit();
        myBatisConnect.closeSqlSession();
        return true;
    }

    public static boolean updateBuyWaterInfo(BuyWater buyWater) throws IOException {
        BuyWaterDao buyWaterDao;
        MyBatisConnect myBatisConnect = new MyBatisConnect();
        SqlSession sqlSession = myBatisConnect.getSqlSession();
        buyWaterDao = new BuyWaterDaoImpl(sqlSession);
        buyWaterDao.updateBuyWater(buyWater);
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

    public String getWaterType() {
        return waterType;
    }

    public void setWaterType(String waterType) {
        this.waterType = waterType;
    }
    public String getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(String buyDate) {
        this.buyDate = buyDate;
    }



    public  int getBuyNumber() {
        return buyNumber;
    }

    public void setBuyNumber(int buyNumber) {this.buyNumber= buyNumber; }


    public String getTel() {return Tel;}

    public void setTel(String tel) {this.Tel = tel;}

}



