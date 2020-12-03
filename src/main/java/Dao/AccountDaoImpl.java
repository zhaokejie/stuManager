package Dao;


import Service.user.Account;
import Service.user.AccountDao;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class AccountDaoImpl implements AccountDao {
    public SqlSession sqlSession;

    public AccountDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }


    @Override
    public Account getAccountById(int id) {
        return this.sqlSession.selectOne("AccountDao.getAccountById", id);
    }


    @Override
    public List<Account> getAccountAll() {
        return this.sqlSession.selectList("AccountDao.getAccountAll");
    }

    @Override
    public void insertAccount(Account account) {
        this.sqlSession.insert("AccountDao.insertAccount",account);
    }

    @Override
    public void updateAccount(Account account) {
        this.sqlSession.update("AccountDao.updateAccount",account);
    }

    @Override
    public void deleteAccount(int id) {
        this.sqlSession.delete("AccountDao.deleteAccount",id);
    }
}