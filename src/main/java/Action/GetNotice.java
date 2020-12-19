package Action;

import Service.accessRecord.AccessRecord;
import Service.notice.Notice;
import Service.user.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;

@WebServlet(name = "GetNotice",urlPatterns = "/GetNotice")
public class GetNotice extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY/MM/dd");

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

            String noticeList = Notice.getJSONBuildingAllNotice(student.getBuildingId()).toString();
            response.getOutputStream().write(noticeList.getBytes("UTF-8"));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY/MM/dd");

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

            String noticeList = Notice.getJSONBuildingAllNotice(student.getBuildingId()).toString();
            response.getOutputStream().write(noticeList.getBytes("UTF-8"));
        }
    }
}
