package Action;

import  Service.accessRecord.AccessRecord;
import Service.user.Student;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "updateAccessRecordInfo",urlPatterns = "/updateAccessRecordInfo")
public class updateAccessRecordInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置编码格式

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");

        //获取前端传来的数据
        AccessRecord accessRecord = new AccessRecord();
        accessRecord.setStuID(Integer.parseInt(request.getParameter("StuID")));
        accessRecord.setOutDate(request.getParameter("OutDate"));
        accessRecord.setComeDate(request.getParameter("ComeDate"));
        accessRecord.setOutReason(request.getParameter("OutReason"));


        //存入数据库

        AccessRecord.updateAccessRecordInfo(accessRecord);

        //返回响应数据

        JSONObject respJson = new JSONObject();

        respJson.put("State","1");

        response.getOutputStream().write(respJson.toString().getBytes("UTF-8"));




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
