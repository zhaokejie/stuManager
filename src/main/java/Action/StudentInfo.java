package Action;

import Service.user.Student;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "StudentInfo",urlPatterns = "/StudentInfo")
public class StudentInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession(false);
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Expose-Headers","ifOnline");
        response.setHeader("Access-Control-Expose-Headers","Set-Cookie");
        if(httpSession == null)
        {
            response.setHeader("ifOnline","0");
        }
        else
        {

            Student student = (Student) httpSession.getAttribute("aStudent");
            JSONObject json = new JSONObject();
            json.put("ID",student.getId());
            json.put("name",student.getName());
            json.put("classId",student.getClassId());
            json.put("mobilePhone",student.getMobilePhone());
            json.put("buildingId",student.getBuildingId());
            json.put("roomId",student.getRoomId());
            json.put("Email",student.getEmail());
            json.put("homeAddress",student.getHomeAddress());
            json.put("cardBalance",student.getCardBalance());
            response.getOutputStream().write(json.toString().getBytes("UTF-8"));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession(false);
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("Access-Control-Expose-Headers","ifOnline");
        response.setHeader("Access-Control-Expose-Headers","Set-Cookie");
        if(httpSession == null)
        {
            response.setHeader("ifOnline","0");
        }
        else
        {

            Student student = (Student) httpSession.getAttribute("aStudent");
            JSONObject json = new JSONObject();
            json.put("ID",student.getId());
            json.put("name",student.getName());
            json.put("classId",student.getClassId());
            json.put("mobilePhone",student.getMobilePhone());
            json.put("buildingId",student.getBuildingId());
            json.put("roomId",student.getRoomId());
            json.put("Email",student.getEmail());
            json.put("homeAddress",student.getHomeAddress());
            json.put("cardBalance",student.getCardBalance());
            response.getOutputStream().write(json.toString().getBytes("UTF-8"));
        }
    }
}
