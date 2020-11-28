package Service.ManagerService;

import Dao.AccountTools;
import Service.Model.hygieneCheckRecord;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "SearchHygieneCheckRecord",urlPatterns="/SearchHygieneCheckRecord")
public class SearchHygieneCheckRecord extends HttpServlet {
    //寝室管理员登录成功之后,BuildingID字段应该存入session，以便后续使用
    //功能:某个寝室管理员登录系统后，他可以看到他所负责的这栋楼里面的所有卫生检查记录(现在是所有的记录都搜索出来，后期要加上按条件查询的功能)
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        //设置逻辑实现
        PrintWriter out = response.getWriter();
        out.println("<h1>这里是获取卫生登记记录的后台</h1>");
        HttpSession session = request.getSession();

        //获取当前寝室管理员的信息，看他是负责的是哪栋寝室楼，根据楼号进行下一步
        //在卫生检查记录数据表中去搜索，把所有检查楼号为当前寝室管理员对应楼号的卫生检查记录都搜索出来
        String buildingID = (String) session.getAttribute("BuildingID");
        out.println("<h2>" + buildingID + "</h2>");
        AccountTools accountTools = new AccountTools();
        List<hygieneCheckRecord> list = new ArrayList<hygieneCheckRecord>();
        list = accountTools.getAllHygieneCheckRecord("Where BuildingID=" + buildingID); //得到了该寝室楼的所有的卫生检查记录
        for(int i=0;i<list.size();i++){
            out.println("<h3>" + list.get(i).getProblem() + "</h3>");
        }
      /*  int num=list.size();
            out.println("<h3>" + num + "</h3>");
            out.println("<h4>" + list.get(0).getStudent_Name() + "</h4>");
            out.println("<h5>" + list.get(1).getStudent_Name() + "</h5>");
            */

    }


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

     /*   response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<h1>这里是Login Servlet后台</h1>");
        */
        this.doPost(request, response);
    }
}

