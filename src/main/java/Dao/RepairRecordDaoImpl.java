package Dao;

import Service.repairRecord.RepairRecord;
import Service.repairRecord.RepairRecordDao;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;

public class RepairRecordDaoImpl  implements RepairRecordDao {   //把之前定义的接口全部实现

    public SqlSession sqlSession;

    public RepairRecordDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }




    @Override
    public List<RepairRecord> getRepairRecordAll() {
        return this.sqlSession.selectList("RepairRecordDao.getRepairRecordAll");
    }

    @Override
    public void insertRepairRecord(RepairRecord pay) {
        this.sqlSession.insert("RepairRecordDao.insertRepairRecord",pay);
    }

    @Override
    public void updateRepairRecord(RepairRecord pay) {
        this.sqlSession.update("RepairRecordDao.updateRepairRecord",pay);
    }

    @Override
    public void deleteRepairRecord(HashMap map) {
        this.sqlSession.delete("RepairRecordDao.deleteRepairRecord",map);
    }

    @Override
    public  List<RepairRecord> getRepairRecordById(HashMap map) { return this.sqlSession.selectList("RepairRecordDao.getRepairRecordById",map); }

}




