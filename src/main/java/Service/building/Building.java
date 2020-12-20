package Service.building;

   //building要实现什么样的功能，还需要再考虑一下
import Dao.MyBatisConnect;
import Dao.RoomDaoImpl;
import Dao.StudentDaoImpl;
import Dao.BuildingDaoImpl;
import Service.user.Student;
import Service.user.StudentDao;
import Service.building.BuildingDao;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Building {
  /*  #寝室楼表：

    寝室楼号

    管理员账户（唯一）

    管理员密码

    男生/女生楼
*/
   // private int ID;
    private int ID;//寝室楼号
    private int ManagerID; //管理员ID
    private String password; //管理员密码
    private String BuildingSex;  //这栋楼是男生楼还是女生楼

    public static Building getBuildingByID(int Id) throws IOException {   //通过寝室楼号返回Building对象
        MyBatisConnect myBatisConnect = new MyBatisConnect();

        SqlSession sqlSession = myBatisConnect.getSqlSession();

        BuildingDao buildingDao = new BuildingDaoImpl(sqlSession);


       // HashMap map = new HashMap();
      //  map.put("ID",Id);
        Building building = buildingDao.getBuildingById(Id);
        myBatisConnect.closeSqlSession();
        return building;
    }

    public static String getBuildingJSON(Building building) throws IOException {   //根据Building对象，返回该Building的相关信息(该寝室楼的所有寝室对象,所有学生对象)
        String buildingId = String.valueOf(building.getID());
        //String buildingId = room.buildingId;
        HashMap map = new HashMap();                                                //Building类需要实现什么样的功能？比如根据一个building对象返回对应的room列表或者student列表?
        map.put("buildingId",buildingId);
      //  map.put("buildingId",buildingId);
        MyBatisConnect myBatisConnect = new MyBatisConnect();

       // SqlSession sqlSession = myBatisConnect.getSqlSession();
         JSONObject json = new JSONObject();
        json.put("buildingId",building.getID());
        json.put("ManagerId",building.ManagerID);
        json.put("password",building.password);
        json.put("buildingSex",building.BuildingSex);

        myBatisConnect.closeSqlSession();

        return json.toString();

    }


    public static boolean insertBuilding(Building building) throws IOException {
        MyBatisConnect myBatisConnect = new MyBatisConnect();

        SqlSession sqlSession = myBatisConnect.getSqlSession();

       BuildingDao buildingDao = new BuildingDaoImpl(sqlSession);

        buildingDao.insertBuilding(building);
        sqlSession.commit();
        myBatisConnect.closeSqlSession();
        return true;
    }

    public static boolean updateBuildingInfo(Building building) throws IOException {
        BuildingDao buildingDao;
        MyBatisConnect myBatisConnect = new MyBatisConnect();
        SqlSession sqlSession = myBatisConnect.getSqlSession();
        buildingDao = new BuildingDaoImpl(sqlSession);
         buildingDao.updateBuilding(building);
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

    public void setManagerID(int ManagerID) {
        this.ManagerID=ManagerID;
    }
    public int getManagerID() {
        return ManagerID;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }

    public void setBuildingSex(String BuildingSex) {
        this.BuildingSex = BuildingSex;
    }

    public String getBuildingSex() { return BuildingSex; }


}
