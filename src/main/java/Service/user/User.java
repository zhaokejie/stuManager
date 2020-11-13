package Service.user;

import Dao.AccountTools;
import Service.UserType;

public class User {
    int UID;
    String username;
    String password;
    UserType userType;



//    static Methods
    public static User tryLogin(int UID,String password)
    {
        IaboutAccount accountTools = new AccountTools();
        String tempPassword = accountTools.getPassword((UID));
        if(tempPassword.compareTo("-1") == 0){
            return null;
        }
        if(password.compareTo(accountTools.getPassword(UID)) == 0)
        {
//            return
        }

    }

}

