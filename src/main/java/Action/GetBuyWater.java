package Action;



import Service.buyWater.BuyWater;
import Service.user.Student;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetBuyWater",urlPatterns = "/GetBuyWater")
public class GetBuyWater extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置编码格式

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");

        //获取前端传来的数据
        HttpSession httpSession = request.getSession();
        Student student = (Student) httpSession.getAttribute("aStudent");


        //获取数据库信息

        // List<BuyWater> buyWaters = BuyWater.getBuyWaterByID(student.getBuildingId(),student.getRoomId());
        // List<BuyWater> buyWaters = BuyWater.getBuyWaterByID("1","205");
        String json = BuyWater.getBuyWaterJSON(student.getBuildingId(),student.getRoomId());
        //  String json = BuyWater.getBuyWaterJSON("1","205");
        //   JSONArray buyWaterList = new JSONArray();
       /* for(BuyWater buyWater:buyWaters)
        {
            buyWaterList.put(BuyWater.getBuyWaterJSON(buyWater.getBuildingID(),buyWater.getRoomID()));
        }

        //返回响应数据

        JSONObject respJson = new JSONObject();

        respJson.put("State","1");
        respJson.put("buyWaters",buyWaterList);
*/
        response.getOutputStream().write(json.toString().getBytes("UTF-8"));


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");

        //获取前端传来的数据
        HttpSession httpSession = request.getSession();
         Student student = (Student) httpSession.getAttribute("aStudent");


        //获取数据库信息

        // List<BuyWater> buyWaters = BuyWater.getBuyWaterByID(student.getBuildingId(),student.getRoomId());
        // List<BuyWater> buyWaters = BuyWater.getBuyWaterByID("1","205");
         String json = BuyWater.getBuyWaterJSON(student.getBuildingId(),student.getRoomId());
      //  String json = BuyWater.getBuyWaterJSON("1","205");
        //   JSONArray buyWaterList = new JSONArray();
       /* for(BuyWater buyWater:buyWaters)
        {
            buyWaterList.put(BuyWater.getBuyWaterJSON(buyWater.getBuildingID(),buyWater.getRoomID()));
        }

        //返回响应数据

        JSONObject respJson = new JSONObject();

        respJson.put("State","1");
        respJson.put("buyWaters",buyWaterList);
*/
        response.getOutputStream().write(json.toString().getBytes("UTF-8"));


    }
}
