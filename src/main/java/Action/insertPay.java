package Action;

import Service.accessRecord.AccessRecord;
import Service.pay.Pay;
import Service.user.Manager;
import Service.user.Student;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "insertPay",urlPatterns = "/insertPay")
public class insertPay extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式和参数
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");

        //获取前端数据
        HttpSession httpSession = request.getSession();
        Manager manager = (Manager) httpSession.getAttribute("aManager");
        Pay pay = new Pay();

        pay.setBuildingID(manager.getManager_Building_ID());
        pay.setRoomID(request.getParameter("RoomID"));
        pay.setCost(Float.parseFloat(request.getParameter("Cost")));
        pay.setPayType(request.getParameter("PayType"));
        pay.setPayDate(request.getParameter("PayDate"));
        //将数据存入数据库
        String state = "";
        if(Pay.insertPay(pay))
        {
            state = "1";
        }
        else
        {
            state = "0";
        }


        //返回相应数据

        JSONObject respJson = new JSONObject();
        respJson.put("state",state);
        response.getOutputStream().write(respJson.toString().getBytes("UTF-8"));


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
