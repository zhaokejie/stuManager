package Service.healthScore;

import Service.healthScore.HealthScore;

import java.util.HashMap;
import java.util.List;

public interface HealthScoreDao {

    public HealthScore getHealthScoreById(HashMap map);

    // public Room getRoomByBuildingId();


    /**
     * 查询所有用户信息
     *
     * @param map
     */
    public List<HealthScore> getHealthScoreAll(HashMap map);




    /**
     * 新增用户
     *
     * @param healthScore
     */
    public void insertHealthScore(HealthScore healthScore);

    /**
     * 更新用户信息
     *
     * @param healthScore
     */
    public void updateHealthScore(HealthScore healthScore);

    /**
     * 根据id删除用户信息
     *
     * @param map
     */
    public void deleteHealthScore(HashMap map);


}

