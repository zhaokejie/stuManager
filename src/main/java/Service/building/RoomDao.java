package Service.building;

import Service.user.Account;
import java.util.List;

public interface RoomDao {

    /**
     * 根据id查询用户信息
     *
     * @param id
     * @return
     */
    public Room getRoomById(int id);




    /**
     * 查询所有用户信息
     *
     * @return
     */
    public List<Room> getRoomAll();

    /**
     * 新增用户
     *
     * @param room
     */
    public void insertRoom(Room room);

    /**
     * 更新用户信息
     *
     * @param room
     */
    public void updateRoom(Room room);

    /**
     * 根据id删除用户信息
     *
     * @param id
     */
    public void deleteRoom(int id);
}