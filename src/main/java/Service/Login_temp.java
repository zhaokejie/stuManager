//package Service;
//
//
//import Dao.UserLoginDAO;
////import Service.Model.DormManager;
////import Service.Model.Students;
//import Service.user.Student;
//import Service.user.Manager;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.io.PrintWriter;
//import Dao.AccountTools;
//import Service.user.*;
//import Service.session.SessionsManager;
//public class Login_temp {
//    public static boolean LoginServlet(String uid,String password, HttpSession session) {
//
//        User user = new User();
//        IaboutAccount accountTools = new AccountTools();
//        if (((AccountTools) accountTools).checkUsername(uid)) {  //如果用户名存在
//            String tempPassword = accountTools.getPassword((uid));   //则查询相应的密码
//            if(password.compareTo(tempPassword)==0){  //判断密码正不正确
//                if(accountTools.getUserType(uid)==UserType.student){  //是学生
//                    Student student=new Student();
//                    student=((AccountTools) accountTools).getStudent("Where UID="+uid);
//
//                         //还要调用session层，把用户的相关信息存放在session中
//
//
//                }
//                else{         //是寝室管理员
//                    Manager manager=new Manager();
//                    manager=((AccountTools) accountTools).getManager("Where UID="+uid);
//                }
//            }
//            return true;//返回给DoLogin接口层
//        }
//        else {
//            //用户名不存在，返回相应消息
//            return false;
//        }
//    }
//}
//
