package Service.building;

import java.util.HashMap;
import java.util.List;
import Service.building.Building;

public interface BuildingDao {



   //写增删改查的接口


    public Building getBuildingById(int id);




    /**
     * 查询所有寝室楼信息
     *
     * @return
     */
    public List<Building> getBuildingAll();




    /**
     * 新增寝室楼
     *
     * @param building
     */
    public void insertBuilding(Building building);

    /**
     * 更新寝室楼信息
     *
     * @param building
     */
    public void updateBuilding(Building building);

    /**
     * 根据id删除寝室楼信息
     *
     * @param id
     */
    public void deleteBuilding(int id);


}
