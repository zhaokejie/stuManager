package Action;

import Service.buyWater.BuyWater;



import Service.user.Student;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
@WebServlet(name = "insertBuyWater",urlPatterns = "/insertBuyWater")
public class insertBuyWater extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式和参数
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");

        Date date=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        //获取前端数据er.. 获取前端数据er
        HttpSession httpSession = request.getSession();
        Student  student = (Student) httpSession.getAttribute("aStudent");
        BuyWater buyWater = new BuyWater();

        buyWater.setBuildingID(request.getParameter("buildingId"));
        buyWater.setRoomID(request.getParameter("roomId"));
        buyWater.setCost(Float.parseFloat(request.getParameter("cost")));
        buyWater.setWaterType(request.getParameter("payType"));
        buyWater.setBuyNumber(Integer.parseInt(request.getParameter("payQuantity")));

       /* buyWater.setBuildingID("2");
        buyWater.setRoomID("206");
        buyWater.setCost(16);
        buyWater.setWaterType("莫干山泉8元");
        buyWater.setBuyNumber(2);
*/
        buyWater.setBuyDate(format.format(date));
        buyWater.setTel(student.getMobilePhone());
      //  buyWater.setTel("13925293349");
        //将数据存入数据库
        String state = "";
        if(BuyWater.insertBuyWater(buyWater))
        {
            state = "1";
        }
        else
        {
            state = "0";
        }


        //返回相应数据

        JSONObject respJson = new JSONObject();
        respJson.put("state",state);


        response.getOutputStream().write(respJson.toString().getBytes("UTF-8"));


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException

    {
        doPost(request,response);
    }
}