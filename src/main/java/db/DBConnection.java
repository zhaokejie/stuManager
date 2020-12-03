package db;
import java.sql.*;
import java.io.Writer;
public class DBConnection {

        public static Connection getDBconnection() {
            try {
                Connection conn = null;
                Class.forName("com.mysql.cj.jdbc.Driver"); //加载指定的数据库驱动程序
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/stumanager_db?serverTimezone=UTC&useSSL=false",
                        "root", "Hdu1080019");
                return conn;
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            return null;

        }

        public static void closeDB(Connection conn,PreparedStatement pstm,ResultSet rs) {
            try {
                if (rs != null) rs.close();
                if (pstm != null) pstm.close();
                if (conn != null) conn.close();
            }
            catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }


