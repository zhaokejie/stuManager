package Service.accessRecord;

import Service.accessRecord.AccessRecord;

import java.util.List;

public interface AccessRecordDao {

    public List<AccessRecord> getAccessRecordById(int id);




    /**
     * 查询所有寝室楼信息
     *
     * @return
     */
    public List<AccessRecord> getAccessRecordAll();




    /**
     * 新增寝室楼
     *
     * @param accessRecord
     */
    public void insertAccessRecord(AccessRecord accessRecord);

    /**
     * 更新寝室楼信息
     *
     * @param  accessRecord
     */
    public void updateAccessRecord(AccessRecord accessRecord);

    /**
     * 根据id删除寝室楼信息
     *
     * @param id
     */
    public void deleteAccessRecord(int id);


}
