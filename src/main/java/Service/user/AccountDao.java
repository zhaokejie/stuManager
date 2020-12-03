package Service.user;

import Service.user.Account;
import java.util.List;

public interface AccountDao {

    /**
     * 根据id查询用户信息
     *
     * @param id
     * @return
     */
    public Account getAccountById(int id);




    /**
     * 查询所有用户信息
     *
     * @return
     */
    public List<Account> getAccountAll();

    /**
     * 新增用户
     *
     * @param Account
     */
    public void insertAccount(Account Account);

    /**
     * 更新用户信息
     *
     * @param Account
     */
    public void updateAccount(Account Account);

    /**
     * 根据id删除用户信息
     *
     * @param id
     */
    public void deleteAccount(int id);
}