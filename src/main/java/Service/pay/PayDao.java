package Service.pay;

import Service.pay.Pay;

import java.util.HashMap;
import java.util.List;

public interface PayDao {

    public List<Pay> getPayById(HashMap map);   //根据buildingID和releaseDate来返回一个notice对象

    // public Room getRoomByBuildingId();


    /**
     * 查询所有通知信息
     *
     * @param  map
     */
    public List<Pay> getPayAll(HashMap map);




    /**
     * 新增通知
     *
     * @param pay
     */
    public void insertPay(Pay pay);

    /**
     * 更新通知信息
     *
     * @param pay
     */
    public void updatePay(Pay pay);

    /**
     * 根据id删除通知信息   //根据什么参数来删除通知?
     *
     * @param map
     */
    public void deletePay(HashMap map);



}
