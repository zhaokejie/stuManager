package Dao;

import Service.pay.Pay;
import Service.pay.PayDao;

import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;

public class PayDaoImpl  implements PayDao {   //把之前定义的接口全部实现

    public SqlSession sqlSession;

    public PayDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }




    @Override
    public List<Pay> getPayAll(HashMap map) {
        return this.sqlSession.selectList("PayDao.getPayAll",map);
    }

    @Override
    public void insertPay(Pay pay) {
        this.sqlSession.insert("PayDao.insertPay",pay);
    }

    @Override
    public void updatePay(Pay pay) {
        this.sqlSession.update("PayDao.updatePay",pay);
    }

    @Override
    public void deletePay(HashMap map) {
        this.sqlSession.delete("PayDao.deletePay",map);
    }

    @Override
    public List<Pay> getPayById(HashMap map) {
        return this.sqlSession.selectList("PayDao.getPayById",map);
    }

}


