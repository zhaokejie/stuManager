package Action;

import Service.feedback.FeedBack;
import Service.pay.Pay;
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

@WebServlet(name = "GetPayInfo",urlPatterns = "/GetPayInfo")
public class GetPayInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");

        //获取前端传来的数据，通过Cookie中的Session信息获取操作者
        HttpSession httpSession = request.getSession();
        Student student = (Student) httpSession.getAttribute("aStudent");


        //获取数据库信息

        List<Pay> pays= Pay.getPayByID(student.getBuildingId(),student.getRoomId());
        JSONArray payJsonList = new JSONArray();
        for(Pay p:pays)
        {
            payJsonList.put(Pay.getRecordJSON(p));
        }

        //返回响应数据

        JSONObject respJson = new JSONObject();

        respJson.put("State","1");
        respJson.put("pays",payJsonList);

        response.getOutputStream().write(respJson.toString().getBytes("UTF-8"));
    }
}
