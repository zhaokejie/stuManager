package Dao;

import Service.buyWater.BuyWater;
import Service.buyWater.BuyWaterDao;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;

public class BuyWaterDaoImpl implements BuyWaterDao {   //把之前定义的接口全部实现

    public SqlSession sqlSession;

    public BuyWaterDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<BuyWater> getBuyWaterById(HashMap map) {

        return this.sqlSession.selectList("BuyWaterDao.getBuyWaterById",map);
    }
    @Override
    public List<BuyWater> getBuyWaterAll(HashMap map) {
        return this.sqlSession.selectList("BuyWaterDao.getBuyWaterAll",map);
    }

    @Override
    public void insertBuyWater(BuyWater buyWater) {
        this.sqlSession.insert("BuyWaterDao.insertBuyWater",buyWater);
    }

    @Override
    public void updateBuyWater(BuyWater buyWater) {
        this.sqlSession.update("BuyWaterDao.updateBuyWater",buyWater);
    }

    @Override
    public void deleteBuyWater(HashMap map) {
        this.sqlSession.delete("BuyWaterDao.deleteBuyWater",map);
    }





}


