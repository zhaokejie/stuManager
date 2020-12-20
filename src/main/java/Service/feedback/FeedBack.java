package Service.feedback;


import Dao.MyBatisConnect;
import Dao.FeedBackDaoImpl;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

public class FeedBack {
 /*  #反馈表：
    楼号

            发布时间

    发布者

            正文
            */

    private String buildingId;
    private String releaseDate;
    private String publisher;
    private String content;




    public static FeedBack getFeedBackByID(String buildingId,String releaseDate,String publisher) throws IOException {   //通过寝室楼号返回Building对象
        MyBatisConnect myBatisConnect = new MyBatisConnect();

        SqlSession sqlSession = myBatisConnect.getSqlSession();

        FeedBackDao feedBackDao = new FeedBackDaoImpl(sqlSession);


        HashMap map = new HashMap();
        map.put("buildingId",buildingId);
        map.put("releaseDate",releaseDate);
        map.put("publisher",publisher);
        FeedBack feedBack = feedBackDao.getFeedBackById(map);
        myBatisConnect.closeSqlSession();
        return feedBack;
    }

    public static String getFeedBackJSON(FeedBack feedBack) throws IOException {   //根据Buidling对象，返回该Building的相关信息(该寝室楼的所有寝室对象,所有学生对象)
      //  String buildingId = String.valueOf(building.getID());
        //String buildingId = room.buildingId;
      //  HashMap map = new HashMap();                                                //Building类需要实现什么样的功能？比如根据一个building对象返回对应的room列表或者student列表?
       // map.put("buildingId",buildingId);
        //  map.put("buildingId",buildingId);
      //  MyBatisConnect myBatisConnect = new MyBatisConnect();

      //  SqlSession sqlSession = myBatisConnect.getSqlSession();

        JSONObject json = new JSONObject();
        json.put("buildingId",feedBack.getBuildingId());
        json.put("releaseDate",feedBack.getReleaseDate());
        json.put("publisher",feedBack.getPublisher());
        json.put("content",feedBack.getContent());




      //  myBatisConnect.closeSqlSession();

        return json.toString();

    }
    public static boolean insertFeedBack(FeedBack feedBack) throws IOException {
        MyBatisConnect myBatisConnect = new MyBatisConnect();

        SqlSession sqlSession = myBatisConnect.getSqlSession();

       FeedBackDao  feedBackDao = new FeedBackDaoImpl(sqlSession);
       feedBackDao.insertFeedBack(feedBack);
        sqlSession.commit();
        myBatisConnect.closeSqlSession();
        return true;
    }

    public static boolean updateFeedBackInfo(FeedBack feedBack) throws IOException {
        FeedBackDao feedBackDao;
        MyBatisConnect myBatisConnect = new MyBatisConnect();
        SqlSession sqlSession = myBatisConnect.getSqlSession();
        feedBackDao = new FeedBackDaoImpl(sqlSession);
        feedBackDao.updateFeedBack(feedBack);
        sqlSession.commit();
//        Student student = studentDao.getStuInfoById(ID);
        myBatisConnect.closeSqlSession();
        return true;
    }
    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate =releaseDate;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher =publisher;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
