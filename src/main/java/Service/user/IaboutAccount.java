package Service.user;

public interface IaboutAccount {
    //public boolean  addAccount(int UID,String password,UserType u);
    //如果添加成功返回true
    public String getPassword(String UID);
    //返回账户的密码,若不存在返回“-1”
    public boolean changePassword(String UID,String newPassword);
    //修改密码成功返回true
    public UserType getUserType(String UID);
    //返回用户的类型学生 or 管理员
}
