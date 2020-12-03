//package Service.ManagerService;
//
//import Service.Model.outComer;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.List;
//@WebServlet(name = "SearchOutRegister",urlPatterns="/SearchOutRegister")
//public class SearchOutsideRegister extends HttpServlet {
//   //BuildingID字段已经提前存入了session
//    //功能:查询这栋楼(这个寝室管理员所负责的这栋楼)的所有的外来人员记录(也是所有的，没加上按条件查询的功能)
//    public void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//
//
//        response.setContentType("text/html");
//        response.setCharacterEncoding("UTF-8");
//        //设置逻辑实现
//        PrintWriter out = response.getWriter();
//        out.println("<h1>这里是查看外来人员登记记录的后台</h1>");
//        HttpSession session = request.getSession();
//
//        //获取当前寝室管理员的信息，看他是负责的是哪栋寝室楼，根据楼号进行下一步
//        //在外来人员数据表中去搜索，把所有外访的楼号为当前寝室管理员对应楼号的外来人员信息都搜索出来
//        String buildingID = (String) session.getAttribute("BuildingID");
//        out.println("<h2>" + buildingID + "</h2>");
//        AccountTools accountTools = new AccountTools();
//        List<outComer> list = new ArrayList<outComer>();
//        list = accountTools.getAllOutComer("Where connectBuildingID=" + buildingID); //以列表的形式得到了该寝室楼的所有的外来人员对象
//        out.println("<h3>" + list.size() + "</h3>");
//        for(int i=0;i<list.size();i++){
//            out.println("<h3>" + list.get(i).getName() + "</h3>");
//        }
//
//    }
//}
