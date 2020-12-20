package Action;

import Service.notice.Notice;
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

@WebServlet(name = "insertNotice",urlPatterns = "/insertNotice")
public class insertNotice extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式和参数
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");

        //获取前端数据
        HttpSession httpSession = request.getSession();
        Manager manager = (Manager) httpSession.getAttribute("aManager");
       Notice notice = new Notice();

        notice.setBuildingId(manager.getManager_Building_ID());
        notice.setContent(request.getParameter("Content"));
        notice.setReleaseDate(request.getParameter("ReleaseDate"));


        //将数据存入数据库
        String state = "";
        if(Notice.insertNotice(notice))
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
