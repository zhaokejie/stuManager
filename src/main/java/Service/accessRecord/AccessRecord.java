package Service.accessRecord;

import Dao.MyBatisConnect;

import Dao.AccessRecordDaoImpl;
import Service.accessRecord.AccessRecord;
import Service.accessRecord.AccessRecordDao;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class AccessRecord {


/*#出入校登记
            学号

    出校时间

            入校时间

    出校原因
    */

    private int stuId;
    private String outDate;  //出校时间
    private String outReason; //出校原因
    private String comeDate; //入校时间


    public static List<AccessRecord> getAccessRecordByID(int stuId) throws IOException {   //通过stuID返回出入校记录集合
        MyBatisConnect myBatisConnect = new MyBatisConnect();

        SqlSession sqlSession = myBatisConnect.getSqlSession();

        AccessRecordDao accessRecordDao = new AccessRecordDaoImpl(sqlSession);

        List<AccessRecord> accessRecordList = accessRecordDao.getAccessRecordById(stuId);
        myBatisConnect.closeSqlSession();
        return accessRecordList;
    }

    public static JSONObject getRecordJSON(AccessRecord accessRecord)
    {
        JSONObject json = new JSONObject();
        json.put("outDate", accessRecord.getOutDate());
        json.put("outReason",accessRecord.getOutReason());
        json.put("comeDate",accessRecord.getComeDate());

        return json;
    }
    public static String getAccessRecordJSON(int stuId) throws IOException { //根据学生学号，返回该学生的所有出入校记录
       // String stuId= String.valueOf(accessRecord.stuId);

        JSONObject json = new JSONObject();
        json.put("stuId",stuId);


        MyBatisConnect myBatisConnect = new MyBatisConnect();

        SqlSession sqlSession = myBatisConnect.getSqlSession();
     //   AccessRecordDao accessRecordDao = new AccessRecordDaoImpl(sqlSession);
        List<AccessRecord> list = AccessRecord.getAccessRecordByID(stuId);
        JSONArray jsonRecord= new JSONArray();
        for(AccessRecord record:list)
        {

            jsonRecord.put(AccessRecord.getRecordJSON(record));

        }
        json.put("recordList",jsonRecord);   //把该学生的出入校记录列表放进json








        myBatisConnect.closeSqlSession();

        return json.toString();

    }



    public int getStuID() {
        return stuId;
    }

    public void setStuID(int stuId) {
        this.stuId = stuId;
    }

    public String getOutDate() {
        return outDate;
    }

    public void setOutDate(String outDate) {
        this.outDate = outDate;
    }

    public String getOutReason() {
        return outReason;
    }

    public void setOutReason(String outReason) {
        this.outReason = outReason;
    }

    public String getComeDate() {
        return comeDate;
    }

    public void setComeDate(String comeDate) {
        this.comeDate = comeDate;
    }
}



