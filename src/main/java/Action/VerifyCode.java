package Action;

import Service.tools.VerifyCodeTools;

import javax.imageio.*;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

//import static jdk.javadoc.internal.doclets.toolkit.util.StandardDocFileFactory.newFile;

@WebServlet(name = "VerifyCode",urlPatterns="/getVerifyCode")
public class VerifyCode  extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        VerifyCodeTools.createVerifyCode(request.getSession(),response.getOutputStream());



    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


}
