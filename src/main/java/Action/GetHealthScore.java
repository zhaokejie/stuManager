package Action;

import Service.healthScore.HealthScore;
import Service.user.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "GetHealthScore",urlPatterns = "/GetHealthScore")
public class GetHealthScore extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession(false);
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        if(httpSession == null)
        {
            response.setHeader("ifOnline","0");
        }
        else
        {
            response.setHeader("ifOnline","1");
            Student student = (Student) httpSession.getAttribute("aStudent");

            String healthScore = HealthScore.getHealthScoreJSON(student.getRoomId(),student.getBuildingId());
            response.getOutputStream().write(healthScore.getBytes("UTF-8"));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession(false);
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        if(httpSession == null)
        {
            response.setHeader("ifOnline","0");
        }
        else
        {
            response.setHeader("ifOnline","1");
            Student student = (Student) httpSession.getAttribute("aStudent");

            String healthScore = HealthScore.getHealthScoreJSON(student.getRoomId(),student.getBuildingId());
            response.getOutputStream().write(healthScore.getBytes("UTF-8"));
        }
    }
}
