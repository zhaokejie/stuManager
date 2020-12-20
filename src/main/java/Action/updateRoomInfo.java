package Action;

import Service.building.Room;
import Service.user.Student;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "updateRoomInfo",urlPatterns = "/updateRoomInfo")
public class updateRoomInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置编码格式

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");

        //获取前端传来的数据
       Room room = new Room();
        room.setID(Integer.parseInt(request.getParameter("ID")));
       room.setHealthScore(Float.parseFloat(request.getParameter("HealthScore")));
        room.setElectricityBalance(Float.parseFloat(request.getParameter("ElectricityBalance")));
        room.setWaterBalance(Float.parseFloat(request.getParameter("WaterBalance")));

        //存入数据库

        Room.updateRoomInfo(room);

        //返回响应数据

        JSONObject respJson = new JSONObject();

        respJson.put("State","1");

        response.getOutputStream().write(respJson.toString().getBytes("UTF-8"));




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
