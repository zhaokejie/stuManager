package Dao;

import Service.building.Room;
import Service.building.RoomDao;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;

public class RoomDaoImpl implements RoomDao {

    public SqlSession sqlSession;

    public RoomDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }




    @Override
    public List<Room> getRoomAll() {
        return this.sqlSession.selectOne("RoomDao.getRoomAll");
    }

    @Override
    public void insertRoom(Room room) {
        this.sqlSession.insert("RoomDao.insertRoom",room);
    }

    @Override
    public void updateRoom(Room room) {
        this.sqlSession.update("RoomDao.updateRoom",room);
    }

    @Override
    public void deleteRoom(int id) {
        this.sqlSession.delete("RoomDao.deleteRoom",id);
    }

    @Override
    public Room getRoomById(HashMap map) {
        return this.sqlSession.selectOne("RoomDao.getRoomById",map);
    }

}
