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

        if(httpSession == null)
        {
            response.setHeader("ifOnline","0");
        }
        else
        {

            Student student = (Student) httpSession.getAttribute("aStudent");
            JSONObject json = Student.getStuJSON(student);
            response.getOutputStream().write(json.toString().getBytes("UTF-8"));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession(false);
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("Access-Control-Expose-Headers","ifOnline");

        if(httpSession == null)
        {
            response.setHeader("ifOnline","0");
        }
        else
        {

            Student student = (Student) httpSession.getAttribute("aStudent");
            JSONObject json = Student.getStuJSON(student);
            response.getOutputStream().write(json.toString().getBytes("UTF-8"));
        }
    }
}
