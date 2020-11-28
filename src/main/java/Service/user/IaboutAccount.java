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


//调用DAO层获取用户名是否存在
// 若存在取得该用户名的密码
//判断密码是否正确
//正确就返回登陆成功，错误就返回登陆失败
//若登陆成功再从DAO层获取用户其他需要的临时数据存入Session管理器（内存中）
