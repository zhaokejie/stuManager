package Action;

import Service.feedback.FeedBack;
import Service.user.Student;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "updateFeedBackInfo",urlPatterns = "/updateFeedBackInfo")
public class updateFeedBackInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置编码格式

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");

        //获取前端传来的数据
        FeedBack feedBack = new FeedBack();
        feedBack.setBuildingId(request.getParameter("BuildingId"));
        feedBack.setReleaseDate(request.getParameter("ReleaseDate"));
        feedBack.setPublisher(request.getParameter("Publisher"));
        feedBack.setContent(request.getParameter("Content"));

        //存入数据库

        FeedBack.updateFeedBackInfo(feedBack);

        //返回响应数据

        JSONObject respJson = new JSONObject();

        respJson.put("State","1");

        response.getOutputStream().write(respJson.toString().getBytes("UTF-8"));




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
