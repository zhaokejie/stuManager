package Service.notice;

import Service.building.Room;
import Service.notice.Notice;
import java.util.HashMap;
import java.util.List;

public interface NoticeDao {

    public Notice getNoticeById(HashMap map);   //根据buildingID和releaseDate来返回一个notice对象

    // public Room getRoomByBuildingId();


    /**
     * 查询所有通知信息
     *
     * @return
     */
    public List<Notice> getNoticeAll();




    /**
     * 新增通知
     *
     * @param notice
     */
    public void insertNotice(Notice notice);

    /**
     * 更新通知信息
     *
     * @param notice
     */
    public void updateNotice(Notice notice);

    /**
     * 根据id删除通知信息   //根据什么参数来删除通知?
     *
     * @param releaseDate
     */
    public void deleteNotice(String releaseDate);



}
