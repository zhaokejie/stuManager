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


        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("uname");
        String password = req.getParameter("pwd");
        String identity = req.getParameter("identity");
        resp.setHeader("Access-Control-Expose-Headers","LoginState");



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
            resp.setHeader("SessionID",hs.getId());
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


        resp.setHeader("LoginState","0");



        Account account = Account.LoginService(Integer.parseInt(name),password);
        if(account != null)
        {
            resp.setHeader("LoginState",identity);
            Student aStudent = Student.getStudentByID(account.getID());

            HttpSession hs = req.getSession();

            System.out.println("SESSIONid:  "+hs.getId());
            resp.setHeader("SessionID",hs.getId());
            hs.setMaxInactiveInterval(1*60*60);
            hs.setAttribute("aStudent",aStudent);
        }
        else
        {
            resp.setHeader("LoginState","0");
        }



    }
}
