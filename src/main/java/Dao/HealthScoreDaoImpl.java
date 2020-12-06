package Dao;

import Service.healthScore.HealthScore;
import Service.healthScore.HealthScoreDao;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;

public class HealthScoreDaoImpl implements HealthScoreDao {   //把之前定义的接口全部实现

    public SqlSession sqlSession;

    public HealthScoreDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }




    @Override
    public List<HealthScore> getHealthScoreAll(HashMap map) {
        return this.sqlSession.selectList("HealthScoreDao.getHealthScoreAll",map);
    }

    @Override
    public void insertHealthScore(HealthScore healthScore) {
        this.sqlSession.insert("HealthScoreDao.insertBuilding",healthScore);
    }

    @Override
    public void updateHealthScore(HealthScore healthScore) { this.sqlSession.update("HealthScoreDao.updateBuilding",healthScore); }

    @Override
    public void deleteHealthScore(HashMap map) {
        this.sqlSession.delete("HealthScoreDao.deleteHealth",map);
    }

    @Override
    public HealthScore getHealthScoreById(HashMap map) { return this.sqlSession.selectOne("HealthScoreDao.getHealthScoreById",map); }


}



