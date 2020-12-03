package Action;

import Service.session.SessionsManager;
import Service.user.Account;
import Service.user.Student;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class DoLogin
 */


@WebServlet("/DoLogin")
public class DoLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		System.out.println("有人登陆");
//		String name = req.getParameter("uname");
//		String password = req.getParameter("pwd");
//		Map parameterMap = req.getParameterMap();
//		System.out.println(parameterMap.get("name"));
//		System.out.println("用户名:"+name);
//		resp.setCharacterEncoding("utf-8");
//		JudgeLogin aLogin = new Login_sql();
//		byte[] abyte;
//		User auser = null;
////		auser = aLogin.getUser(name, password);
////		System.out.println(auser.name+"  : "+auser.password);
//		if(aLogin.checkUser(name))
//		{
//			System.out.println("用户名找到了");
////			User auser = null;
//			auser = aLogin.getUser(name, password);
////			System.out.println(auser.getName()+"  : "+auser.getPassword());
//			if(auser.getName().equals("-1"))
//			{
//				abyte = ("密码错误").getBytes("UTF-8");
//
//
//			}
//			else
//			{
//
//				//转发到cookies
//				abyte = ("登陆成功").getBytes("UTF-8");
//				resp.setHeader("uname", name);
//				SessionsManager.removeSession(name);
//				HttpSession hs = req.getSession();
//				SessionsManager.addSession(name, hs);
//				System.out.println("SESSIONid:  "+hs.getId());
//				hs.setMaxInactiveInterval(1*30*60);
//				hs.setAttribute("user", auser);
//
//				if(WebSocket.getClients().containsKey(name));
//					{
//						WebSocket.closeClient(name);
//						WebSocket.getClients().remove(name);
//					}
//				System.out.println("现在的连接"+WebSocket.getClients());
//
//
////				System.out.println(SessionsManager.viewSessions());
//				req.getRequestDispatcher("sendCookies").forward(req, resp);
//			}
//
//		}
//		else
//		{
//			abyte = ("用户未找到").getBytes("UTF-8");
//		}
//
//
//		resp.getOutputStream().write(abyte);


        //临时测试的代码：
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        byte[] bytes = new byte[1000];
        req.getInputStream().read(bytes);
        System.out.println(new String(bytes));
        resp.setHeader("Access-Control-Expose-Headers","LoginState");
        resp.setHeader("Access-Control-Expose-Headers","Set-Cookie");

        String name = req.getParameter("uname");
        String password = req.getParameter("pwd");
        String identity = req.getParameter("identity");
        resp.setHeader("LoginState","0");
        Account account = Account.LoginService(Integer.parseInt(name),password);
        if(account != null)
            {
                resp.setHeader("LoginState",identity);
                Student aStudent = Student.getStudentByID(account.getID());

                SessionsManager.removeSession(name);
                HttpSession hs = req.getSession();
                SessionsManager.addSession(name, hs);
                System.out.println("SESSIONid:  "+hs.getId());
                hs.setMaxInactiveInterval(1*60*60);
                hs.setAttribute("aStudent",aStudent);
            }
        else
        {
            resp.setHeader("LoginState","0");
        }

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("uname");
        String password = req.getParameter("pwd");
        String identity = req.getParameter("identity");
        resp.setHeader("Access-Control-Expose-Headers","LoginState");
        resp.setHeader("Access-Control-Expose-Headers","Set-Cookie");

        resp.setHeader("LoginState","0");



        Account account = Account.LoginService(Integer.parseInt(name),password);
        if(account != null)
        {
            resp.setHeader("LoginState",identity);
            Student aStudent = Student.getStudentByID(account.getID());

            SessionsManager.removeSession(name);
            HttpSession hs = req.getSession();
            SessionsManager.addSession(name, hs);
            System.out.println("SESSIONid:  "+hs.getId());
            hs.setMaxInactiveInterval(1*60*60);
            hs.setAttribute("aStudent",aStudent);
        }
        else
        {
            resp.setHeader("LoginState","0");
        }



    }
}
