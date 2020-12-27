package Service.buyWater;

import Service.accessRecord.AccessRecord;
import Service.buyWater.BuyWater;

import java.util.HashMap;
import java.util.List;

public interface BuyWaterDao {





    public List <BuyWater> getBuyWaterById(HashMap map);   //根据buildingID和roomId来返回一个list (订水列表>

// public Room getRoomByBuildingId();


    /**
     * 查询所有通知信息
     *
     * @param  map
     */
    public List<BuyWater> getBuyWaterAll(HashMap map);




    /**
     * 新增通知
     *
     * @param buyWater
     */
    public void insertBuyWater(BuyWater buyWater);

    /**
     * 更新通知信息
     *
     * @param buyWater
     */
    public void updateBuyWater(BuyWater buyWater);

    /**
     * 根据id删除通知信息   //根据什么参数来删除通知?
     *
     * @param map
     */
    public void deleteBuyWater(HashMap map);

}
