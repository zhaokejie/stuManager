//package Service.ManagerService;
//
//import Service.user.*;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.*;
//@WebServlet(name = "SearchStudent",urlPatterns="/SearchStudent")
//public class SearchStudent extends HttpServlet {
//     //寝室管理员登录成功以后，对应的BuildingID字段已经存入了session,以便后续使用
//    //功能:查询这栋楼(这个寝室管理员所负责的这栋楼)的所有的学生的个人信息(也是所有的，没加上按条件查询的功能)
//    public void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html");
//        response.setCharacterEncoding("UTF-8");
//        //设置逻辑实现
//        PrintWriter out = response.getWriter();
//        out.println("<h1>这里是获取学生信息的后台</h1>");
//        HttpSession session = request.getSession();
//
//        //获取当前寝室管理员的信息，看他是负责的是哪栋寝室楼，根据楼号进行下一步
//        //在学生数据表中去搜索，把所有寝室楼号为当前寝室管理员对应楼号的学生都搜索出来
//        String buildingID = (String) session.getAttribute("BuildingID");
//        out.println("<h2>" + buildingID + "</h2>");
//        AccountTools accountTools = new AccountTools();
//        List<Student> list = new ArrayList<Student>();
//        list = accountTools.getAllStudent("Where Student_Building_ID=" + buildingID); //以列表的形式得到了该寝室楼的所有的学生对象
//        for(int i=0;i<list.size();i++){
//            out.println("<h3>" + list.get(i).getStudent_Name() + "</h3>");
//        }
//      /*  int num=list.size();
//            out.println("<h3>" + num + "</h3>");
//            out.println("<h4>" + list.get(0).getStudent_Name() + "</h4>");
//            out.println("<h5>" + list.get(1).getStudent_Name() + "</h5>");
//            */
//
//        }
//
//
//    public void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//     /*   response.setContentType("text/html");
//        response.setCharacterEncoding("UTF-8");
//        PrintWriter out = response.getWriter();
//        out.println("<h1>这里是Login Servlet后台</h1>");
//        */
//        this.doPost(request, response);
//    }
//    }
//
//
