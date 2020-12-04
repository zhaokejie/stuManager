package Dao;

import Service.building.Building;
import Service.building.BuildingDao;
import org.apache.ibatis.session.SqlSession;
import java.util.HashMap;
import java.util.List;
public class BuildingDaoImpl implements BuildingDao {   //把之前定义的接口全部实现

    public SqlSession sqlSession;

    public BuildingDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }




    @Override
    public List<Building> getBuildingAll() {
        return this.sqlSession.selectList("BuildingDao.getBuildingAll");
    }

    @Override
    public void insertBuilding(Building building) {
        this.sqlSession.insert("BuildingDao.insertBuilding",building);
    }

    @Override
    public void updateBuilding(Building building) { this.sqlSession.update("BuildingDao.updateBuilding",building); }

    @Override
    public void deleteBuilding(int id) {
        this.sqlSession.delete("BuildingDao.deleteBuilding",id);
    }

    @Override
    public Building getBuildingById(int id) { return this.sqlSession.selectOne("BuildingDao.getBuildingById",id); }

}

