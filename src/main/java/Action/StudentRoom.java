package Action;

import Service.building.Room;
import Service.user.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "StudentRoom",urlPatterns = "/StudentRoom")
public class StudentRoom extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            Room room =  Room.getRoomByID(student.getBuildingId(),student.getRoomId());
            String json = Room.getRoomJSON(room);
            response.getOutputStream().write(json.getBytes("UTF-8"));
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
            Room room =  Room.getRoomByID(student.getBuildingId(),student.getRoomId());
            String json = Room.getRoomJSON(room);
            response.getOutputStream().write(json.getBytes("UTF-8"));
        }
    }
}
