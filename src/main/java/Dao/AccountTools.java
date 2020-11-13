package Dao;

import Service.user.UserType;
import Service.user.IaboutAccount;

public class AccountTools implements IaboutAccount {
    public boolean  addAccount(int UID,String password){
        return true;
    }
    //如果添加成功返回true
    public String getPassword(int UID){
        return null;
    }
    //返回账户的密码,若不存在返回“-1”
    public boolean changePassword(int UID,String newPassword){
        return true;

    }
    //修改密码成功返回true

    public UserType getUserType(int UID){
        return null;
    }
    //返回用户的类型学生 or 管理员
}
