package Action;

import Service.healthScore.HealthScore;
import Service.user.Student;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.geom.Arc2D;
import java.io.IOException;

@WebServlet(name = "updateHealthScoreInfo",urlPatterns = "/updateHealthScoreInfo")
public class updateHealthScoreInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置编码格式

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");

        //获取前端传来的数据
        HealthScore healthScore = new HealthScore();
        healthScore.setBuildingId(request.getParameter("BuildingId"));
        healthScore.setRoomId(request.getParameter("RoomId"));
        healthScore.setScore(Float.parseFloat(request.getParameter("Score")));
        healthScore.setRecordDate(request.getParameter("RecordDate"));

        //存入数据库

        HealthScore.updateHealthScoreInfo(healthScore);

        //返回响应数据

        JSONObject respJson = new JSONObject();

        respJson.put("State","1");

        response.getOutputStream().write(respJson.toString().getBytes("UTF-8"));




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
