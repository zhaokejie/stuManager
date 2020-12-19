package Action;

import Service.tools.VerifyCodeTools;

import javax.imageio.*;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

//import static jdk.javadoc.internal.doclets.toolkit.util.StandardDocFileFactory.newFile;

@WebServlet(name = "VerifyCode",urlPatterns="/getVerifyCode")
public class VerifyCode  extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        VerifyCodeTools.createVerifyCode(session,response.getOutputStream());
        String VerifyCode = (String) session.getAttribute("sessionCacheData");
        response.setHeader("Access-Control-Expose-Headers","vCode");
        response.setHeader("vCode",VerifyCode);




    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


}
