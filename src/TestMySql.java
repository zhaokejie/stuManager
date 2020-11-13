import java.io.Writer;
import java.sql.*;

class TestMySqL {

    public static void main(String[] args) throws Exception {
        Connection conn = null;
        try {
            // 加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            long start =System.currentTimeMillis();

            // 建立连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db?serverTimezone=UTC&useSSL=false",
                    "root", "Hdu1080019");
            long end = System.currentTimeMillis();
            System.out.println(conn);
         //   System.out.println("建立连接耗时： " + (end - start) + "ms 毫秒");

            // 创建Statement对象
            Statement stmt = conn.createStatement();

            // 执行SQL语句
            ResultSet rs = stmt.executeQuery("select * from student_db.student");
            System.out.println("id\tname\tsex\tage");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "\t" + rs.getString(2)+ "\t" + rs.getString(3) + "\t" + rs.getInt(4));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}


