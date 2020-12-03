package Service.user;

import Dao.AccountDaoImpl;
import Dao.MyBatisConnect;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Account {

    int ID;
    String passWord;
    String Email;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }


    public static Account LoginService(int ID, String passWord) throws IOException {

        SqlSession sqlSession;
        String resource = "mybatis-config.xml";

        resource = "mybatis-config.xml";
        // mybatis-config.xml

        // 读取配置文件
        InputStream is = Resources.getResourceAsStream(resource);

        // 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        // 获取sqlSession
        sqlSession = sqlSessionFactory.openSession();


        AccountDao accountDao;
//        MyBatisConnect myBatisConnect = new MyBatisConnect();
//        SqlSession sqlSession = myBatisConnect.getSqlSession();
        accountDao = new AccountDaoImpl(sqlSession);
        //判断用户名密码是否匹配
        Account tempAccount = accountDao.getAccountById(ID);
        if(tempAccount == null)
        {
            return null;
        }else if(tempAccount.passWord.equals(passWord))
        {
            return tempAccount;
        }else {
            return null;
        }
    }
}
