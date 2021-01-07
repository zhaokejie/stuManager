package Action;

import Service.user.Student;
import org.json.JSONObject;
import org.json.JSONPointer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "updateStudentInfo",urlPatterns = "/updateStudentInfo")
public class updateStudentInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置编码格式

        HttpSession session = request.getSession();
        Student student = (Student) session.getAttribute("aStudent");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");

        //获取前端传来的数据

        student.setId(student.getId());
        student.setName(request.getParameter("name"));
        student.setClassId(request.getParameter("classId"));
        student.setMobilePhone(request.getParameter("mobilePhone"));
        student.setBuildingId(request.getParameter("buildingId"));
        student.setRoomId(request.getParameter("roomId"));
        student.setHomeAddress(request.getParameter("homeAdress"));
        student.setEmail(request.getParameter("Email"));

        //存入数据库

        Student.updateStuInfo(student);

        //返回响应数据

        JSONObject respJson = new JSONObject();

        respJson.put("State","1");

        response.getOutputStream().write(respJson.toString().getBytes("UTF-8"));




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
