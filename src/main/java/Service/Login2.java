package Service;


import Dao.UserLoginDAO2;
//import Service.Model.DormManager;
//import Service.Model.Students;
import Service.user.Student;
import Service.user.Manager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Login2",urlPatterns="/Login2")
public class Login2 extends HttpServlet {

  //登录的业务逻辑层涉及到的所有对数据库的操作都封装在了Dao层的UserLoginDAO2这个类中
    UserLoginDAO2 userDao=new UserLoginDAO2 ();

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        //设置逻辑实现
        PrintWriter out = response.getWriter();
        out.println("<h1>这里是Login后台</h1>");
        HttpSession session=request.getSession();
        // 用户名
        String userName=request.getParameter("username");    //对于学生来说，学号就是账号
        // 密码
        String password=request.getParameter("password");
        //用户类型
        String userType=request.getParameter("userType");   //登录时的身份选择按钮的值
        String verifyCode = request.getParameter("verifyCode");
        String BuildingID;

        //获得服务器session 存放数据 ,如果没有返回null
        String sessionCacheData = (String) request.getSession().getAttribute("sessionCacheData"); //sessionCacheData用来存放验证码
        //将服务器缓存session数据移除
        request.getSession().removeAttribute("sessionCacheData");

        try {
            // Students currentStudent=null;
            //DormManager currentDormer=null;
            Student currentStudent=null;   //拟创建一个student对象
            Manager currentDormer=null;    //拟创建一个manager对象

            if("dorm_manager".equals(userType)) {   //如果当前用户登录时的身份是寝室管理员
                //DormManager dormManager=new  DormManager();
                Manager dormManager=new Manager();
                dormManager.setUID(userName);
                dormManager.setpassword(password);
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
                    if(! sessionCacheData.equalsIgnoreCase(verifyCode)){
                        // 用户输入验证码错误
                        // 存放request作用域
                        request.setAttribute("r_userName",userName); //自动填充用户名和密码
                        request.setAttribute("r_password", password);
                        request.setAttribute("message", 1);
                        // 请求转发
                        request.getRequestDispatcher("/login.jsp").forward(request, response);
                        return;
                    }
                    BuildingID=currentDormer.getManager_Building_ID();
                    session.setAttribute("userName",userName);
                    session.setAttribute("password", password); //登录成功，把用户名和密码保存在session中
                    session.setAttribute("userType",userType) ;
                    session.setAttribute("BuildingID",BuildingID) ; //寝室管理员负责的寝室楼号
                    //out.println("<h1>管理员端登录成功！</h1>");
                    request.getRequestDispatcher("/manager/selectStudent_information.jsp").forward(request, response);
                    //跳转到寝室管理员端主页
                    // request.getRequestDispatcher("/manager/selectOutComer.jsp").forward(request, response);
                    //request.getRequestDispatcher("/manager/selectHygieneCheck.jsp").forward(request, response);

                }
            }
            else if("student".equals(userType)) {    //如果当前用户登录时的身份是学生
                Student student=new Student();
                student.setUID(userName);
                student.setpassword(password);
                currentStudent =userDao.StudentLogin(student);
                String dormId=userDao.getDormId(student);
                if(currentStudent==null) {
                    request.setAttribute("message",0);
                    out.println("<h1>当前用户不存在!</h1>");
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                    return;
                }
                else {
                    if(sessionCacheData == null){
                        request.setAttribute("message", 2);
                        System.out.println("验证码为空!");
                        request.getRequestDispatcher("/login.jsp").forward(request, response);
                        return;

                    }

                    //比较
                    if(!sessionCacheData.equalsIgnoreCase(verifyCode)){
                        //  用户输入验证码错误
                        //  存放request作用域
                        request.setAttribute("r_userName",userName); //自动填充用户名和密码
                        request.setAttribute("r_password", password);
                        System.out.println("验证码输入错误！");
                        request.setAttribute("message", 1);
                        //  请求转发
                        request.getRequestDispatcher("/login.jsp").forward(request, response);
                        return;
                    }

                    session.setAttribute("userName",userName);
                    session.setAttribute("password", password); //登录成功，把用户名和密码保存在session中
                    session.setAttribute("dormId",dormId); //学生对应的寝室号
                    session.setAttribute("userType",userType) ;
                    //out.println("<h1>学生端登录成功！</h1>");
                    request.getRequestDispatcher("/student/studentMain.jsp").forward(request, response);
                    //跳转到学生端主页
                }

            }

        }catch(Exception e) {
            e.printStackTrace();
        }finally {

        }

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

