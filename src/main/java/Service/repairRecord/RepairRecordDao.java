package Service.repairRecord;

import Service.repairRecord.RepairRecord;

import java.util.HashMap;
import java.util.List;

public interface RepairRecordDao {

    public List<RepairRecord> getRepairRecordById(HashMap map);

    // public Room getRoomByBuildingId();


    /**
     * 查询所有用户信息
     *
     * @return
     */
    public List<RepairRecord> getRepairRecordAll();




    /**
     * 新增用户
     *
     * @param repairRecord
     */
    public void insertRepairRecord(RepairRecord repairRecord);

    /**
     * 更新用户信息
     *
     * @param repairRecord
     */
    public void updateRepairRecord(RepairRecord repairRecord);

    /**
     * 根据id删除用户信息
     *
     * @param map
     */
    public void deleteRepairRecord(HashMap map);


}



