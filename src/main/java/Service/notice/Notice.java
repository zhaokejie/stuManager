package Service.notice;


import Dao.MyBatisConnect;
import Dao.NoticeDaoImpl;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import java.io.IOException;
import java.util.HashMap;
public class Notice {

  /*  #通知表：
    楼号

            发布时间

    正文
    */

    private String buildingId;
    private String releaseDate;
    private String content;

    public static Notice getNoticeByID(String buildingId,String releaseDate) throws IOException {   //通过寝室楼号返回Building对象
        MyBatisConnect myBatisConnect = new MyBatisConnect();

        SqlSession sqlSession = myBatisConnect.getSqlSession();

        NoticeDao noticeDao = new NoticeDaoImpl(sqlSession);


        HashMap map = new HashMap();
        map.put("buildingId",buildingId);
        map.put("releaseDate",releaseDate);

        Notice notice = noticeDao.getNoticeById(map);
        myBatisConnect.closeSqlSession();
        return notice;
    }

    public static String getNoticeJSON(Notice notice) throws IOException {   //根据Buidling对象，返回该Building的相关信息(该寝室楼的所有寝室对象,所有学生对象)
        //  String buildingId = String.valueOf(building.getID());
        //String buildingId = room.buildingId;
        //  HashMap map = new HashMap();                                                //Building类需要实现什么样的功能？比如根据一个building对象返回对应的room列表或者student列表?
        // map.put("buildingId",buildingId);
        //  map.put("buildingId",buildingId);
        //  MyBatisConnect myBatisConnect = new MyBatisConnect();

        //  SqlSession sqlSession = myBatisConnect.getSqlSession();

        JSONObject json = new JSONObject();
        json.put("buildingId",notice.getBuildingId());
        json.put("releaseDate",notice.getReleaseDate());
        json.put("content",notice.getContent());




        //  myBatisConnect.closeSqlSession();

        return json.toString();

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
