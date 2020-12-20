package Action;

import Service.accessRecord.AccessRecord;
import Service.user.Student;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "insertStudent",urlPatterns = "/insertStudent")
public class insertStudent extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式和参数
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");

        //获取前端数据
        HttpSession httpSession = request.getSession();
       // Student student = (Student) httpSession.getAttribute("aStudent");
        Student student = new Student();

        student.setId(Integer.parseInt(request.getParameter("Id")));
        student.setName(request.getParameter("Name"));
        student.setClassId(request.getParameter("ClassId"));
        student.setMobilePhone(request.getParameter("MobilePhone"));
        student.setBuildingId(request.getParameter("BuildingId"));
        student.setRoomId(request.getParameter("RoomId"));
        student.setEmail(request.getParameter("Email"));
        student.setHomeAddress(request.getParameter("HomeAddress"));
        student.setCardBalance(Integer.parseInt(request.getParameter("CardBalance")));


        //将数据存入数据库
        String state = "";
        if(Student.insertStudent(student))
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
