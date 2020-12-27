package Action;

import Service.accessRecord.AccessRecord;
import Service.repairRecord.RepairRecord;
import Service.user.Student;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "insertRepairRecord",urlPatterns = "/insertRepairRecord")
public class insertRepairRecord extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式和参数
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");

        //获取前端数据
        HttpSession httpSession = request.getSession();
        Student student = (Student) httpSession.getAttribute("aStudent");
        RepairRecord repairRecord = new RepairRecord();

        repairRecord.setStuId(student.getId());
        repairRecord.setBuildingId(student.getBuildingId());
        repairRecord.setRoomID(student.getRoomId());
        repairRecord.setReason(request.getParameter("reason"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        repairRecord.setRecordDate(sdf.format(new Date()));

        //将数据存入数据库
        String state = "";
        if(RepairRecord.insertRepairRecord(repairRecord))
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
