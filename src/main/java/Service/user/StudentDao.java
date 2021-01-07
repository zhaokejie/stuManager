package Service.user;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public interface StudentDao {
    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    public Student getStuInfoById(int id);
    /**
     * 查询所有用户信息
     * @return
     */
    public List<Student> getStuInfoAll();

    public List<Student> getStuInfoByRoomId(HashMap map);
    /**
     * 新增用户
     * @param student
     */
    public void insertStuInfo(Student student);
    /**
     * 更新用户信息
     * @param student
     */
    public void updateStuInfo(Student student);

    /**
     * 根据id删除用户信息
     * @param id
     */
    public void deleteStuInfo(int id);
}