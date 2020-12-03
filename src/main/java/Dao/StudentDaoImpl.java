package Dao;


import Service.user.Account;
import Service.user.AccountDao;
import Service.user.Student;
import Service.user.StudentDao;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    public SqlSession sqlSession;

    public StudentDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }


    @Override
    public Student getStuInfoById(int id) {
        return this.sqlSession.selectOne("StudentDao.getStuInfoById",id);
    }

    @Override
    public List<Student> getStuInfoAll() {
        return this.sqlSession.selectList("StudentDao.getStuInfoAll");
    }

    @Override
    public void insertStuInfo(Student student) {
        this.sqlSession.insert("StudentDao.insertStuInfo",student);
    }

    @Override
    public void updateStuInfo(Student student) {
        this.sqlSession.update("StudentDao.updateStuInfo",student);
    }

    @Override
    public void deleteStuInfo(int id) {
        this.sqlSession.delete("StudentDao.getStuInfoAll",id);
    }
}