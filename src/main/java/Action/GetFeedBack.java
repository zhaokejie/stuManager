package Action;

import Service.feedback.FeedBack;
import Service.notice.Notice;
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

@WebServlet(name = "GetFeedBack")
public class GetFeedBack extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置编码格式

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");

        //获取前端传来的数据
        HttpSession httpSession = request.getSession();
        Student student = (Student) httpSession.getAttribute("aStudent");


        //获取数据库信息

        List<FeedBack> feedBacks = FeedBack.getFeedBack(student.getBuildingId());
        JSONArray feedBackList = new JSONArray();
        for(FeedBack fb:feedBacks)
        {
            feedBackList.put(FeedBack.getFeedBackJSON(fb));
        }

        //返回响应数据

        JSONObject respJson = new JSONObject();

        respJson.put("State","1");
        respJson.put("feedbacks",feedBackList);

        response.getOutputStream().write(respJson.toString().getBytes("UTF-8"));


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
