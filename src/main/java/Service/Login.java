package Service;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import Dao.UserLoginDAO;
import Service.Model.*;
public class Login {


    UserLoginDAO userDao=new UserLoginDAO ();

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        //设置逻辑实现
        PrintWriter out = response.getWriter();
        out.println("<h1>这里是Login后台</h1>");
        HttpSession session=request.getSession();//session
        //用户名
        String userName=request.getParameter("username");   //对于学生来说，学号就是账号
        //密码
        String password=request.getParameter("password");
        //用户类型
        String userType=request.getParameter("userType");
        //验证码
       // String verifyCode = request.getParameter("verifyCode");

        //获得服务器session 存放数据 ,如果没有返回null
       String sessionCacheData = (String) request.getSession().getAttribute("sessionCacheData");//sessionCacheData用来存放验证码
        //将服务器缓存session数据移除
       request.getSession().removeAttribute("sessionCacheData");

        try {
            Students currentStudent=null;
            DormManager currentDormer=null;

            if("dorm_manager".equals(userType)) {
                DormManager dormManager=new  DormManager();
                dormManager.setDormManager_ID(userName);
                dormManager.setDormManager_Password(password);
                currentDormer =userDao.DormLogin(dormManager);
                if(currentDormer==null) {
                    request.setAttribute("message",0);
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                    return;
                }
                else {
                    if(sessionCacheData == null){
                        request.setAttribute("message", 2);
                        request.getRequestDispatcher("/login.jsp").forward(request, response);
                        return;
                    }
                    //比较
                 /*   if(! sessionCacheData.equalsIgnoreCase(verifyCode)){
                        //用户输入验证码错误
                        //存放request作用域
                        request.setAttribute("r_userName",userName);//自动填充用户名和密码
                        request.setAttribute("r_password", password);
                        request.setAttribute("message", 1);
                        //请求转发
                        request.getRequestDispatcher("G:/stuManager/src/main/webapp/login.jsp").forward(request, response);
                        return;
                    }
                    */
                    session.setAttribute("userName",userName);
                    session.setAttribute("password", password);//登录成功，把用户名和密码保存在session中
                    session.setAttribute("userType",userType) ;
                    request.getRequestDispatcher("/admin/dormMain.jsp").forward(request, response);
                }
            }
            else if("student".equals(userType)) {
                Students student=new Students();
                student.setStudent_ID(userName);
                student.setStudent_Password(password);
                currentStudent =userDao.StudentLogin(student);
                String dormId=userDao.getDormId(student);
                if(currentStudent==null) {
                    request.setAttribute("message",0);
                    out.println("<h1>当前用户不存在!</h1>");
                    request.getRequestDispatcher("G:/stuManager/src/main/webapp/login.jsp").forward(request, response);
                    return;
                }
                else {
                  /*  if(sessionCacheData == null){
                        request.setAttribute("message", 2);
                        System.out.println("验证码为空!");
                        request.getRequestDispatcher("G:/stuManager/src/main/webapp/login.jsp").forward(request, response);
                        return;

                    }
                    */
               /*     //比较
                    if(!sessionCacheData.equalsIgnoreCase(verifyCode)){
                        //用户输入验证码错误
                        //存放request作用域
                        request.setAttribute("r_userName",userName);//自动填充用户名和密码
                        request.setAttribute("r_password", password);
                        System.out.println("验证码输入错误！");
                        request.setAttribute("message", 1);
                        //请求转发
                        request.getRequestDispatcher("G:/stuManager/src/main/webapp/login.jsp").forward(request, response);
                        return;
                    }
                    */
                    session.setAttribute("userName",userName);
                    session.setAttribute("password", password);//登录成功，把用户名和密码保存在session中
                    session.setAttribute("dormId",dormId);
                    session.setAttribute("userType",userType) ;
                    out.println("<h1>登录成功！</h1>");
                    request.getRequestDispatcher("G:/stuManager/src/main/webapp/login.jsp").forward(request, response);

                }

            }

        }catch(Exception e) {
            e.printStackTrace();
        }finally {

        }

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }

}


