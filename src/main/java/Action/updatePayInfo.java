package Action;

import Service.pay.Pay;
import Service.user.Student;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "updatePayInfo",urlPatterns = "/updatePayInfo")
public class updatePayInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置编码格式

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");

        //获取前端传来的数据
        Pay pay = new Pay();
        pay.setBuildingID(request.getParameter("BuildingID"));
        pay.setRoomID(request.getParameter("RoomID"));
        pay.setCost(Float.parseFloat(request.getParameter("Cost")));
        pay.setPayType(request.getParameter("PayType"));
        pay.setPayDate(request.getParameter("PayDate"));
        //存入数据库

        Pay.updatePayInfo(pay);

        //返回响应数据

        JSONObject respJson = new JSONObject();

        respJson.put("State","1");

        response.getOutputStream().write(respJson.toString().getBytes("UTF-8"));




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
