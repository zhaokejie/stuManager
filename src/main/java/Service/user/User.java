package Service.user;

import Dao.AccountTools;

public class User {
    String UID;
    String username;
    String password;
    UserType userType;

      public String getUID() {
             return UID;
     }

     public void setUID(String uid) {
             UID=uid;
}
    public String getUsername() {
        return username;
    }

    public void setUsername(String Username) {
        username=Username;
    }

    public String getpassword() {
        return password;
    }

    public void setpassword(String Password) {
        password = Password;
    }
//    static Methods
    public static User tryLogin(String UID,String password) {
        IaboutAccount accountTools = new AccountTools();
        String tempPassword = accountTools.getPassword((UID));

        if (password.compareTo(tempPassword) == 0) {

            if(accountTools.getUserType(UID)==UserType.student){
                return ((AccountTools) accountTools).getStudent("Where UID="+UID);
            }
            else
                return ((AccountTools) accountTools).getManager("Where UID="+UID);
        }
        else{
            return null;
        }


    }
}

