package Dao;

import Service.accessRecord.AccessRecord;
import Service.accessRecord.AccessRecordDao;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;

public class AccessRecordDaoImpl implements AccessRecordDao {   //把之前定义的接口全部实现

    public SqlSession sqlSession;

    public AccessRecordDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }




    @Override
    public List<AccessRecord> getAccessRecordAll() {
        return this.sqlSession.selectList("AccessRecordDao.getAccessRecordAll");
    }

    @Override
    public void insertAccessRecord(AccessRecord accessRecord) { this.sqlSession.insert("AccessRecordDao.insertAccessRecord",accessRecord); }

    @Override
    public void updateAccessRecord(AccessRecord accessRecord) {
        this.sqlSession.update("AccessRecordDao.updateAccessRecord",accessRecord);
    }

    @Override
    public void deleteAccessRecord(int id) {
        this.sqlSession.delete("AccessRecordDao.deleteAccessRecord",id);
    }

    @Override
    public List<AccessRecord> getAccessRecordById(int id) {
        return this.sqlSession.selectList("AccessRecordDao.getAccessRecordById",id);
    }

}


