package Action;

import Service.building.Building;
import Service.user.Student;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "updateBuildingInfo",urlPatterns = "/updateBuildingInfo")
public class updateBuildingInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置编码格式

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");

        //获取前端传来的数据
        Building building = new Building();
        building.setID(Integer.parseInt(request.getParameter("ID")));
        building.setManagerID(Integer.parseInt(request.getParameter("ManagerID")));
        building.setPassword(request.getParameter("Password"));
        building.setBuildingSex(request.getParameter("BuildingSex"));

        //存入数据库

       Building.updateBuildingInfo(building);

        //返回响应数据

        JSONObject respJson = new JSONObject();

        respJson.put("State","1");

        response.getOutputStream().write(respJson.toString().getBytes("UTF-8"));




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
