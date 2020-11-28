package Service.Model;

public class outComer {


    //private int Admin_ID;
    private String Name;
    private String Sex;
    private String Tel;
    private String Reason;
    private String ComeTime;

    private String LeaveTime;
    private String ConnectStudentID;
    private String ConnectStudentName;
    private String ConnectBuildingID;

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }

    public String getSex() {
        return Sex;
    }
    public void setSex(String sex) { Sex=sex; }

    public String getTel() {
        return Tel;
    }
    public void setTel(String tel) {
        Tel = tel;
    }

    public String getReason() { return Reason; }
    public void setReason(String reason) { Reason=reason ;}

    public String getComeTime(String comeTime) {
         return  ComeTime;
    }
    public void setComeTime(String comeTime) {
        ComeTime=comeTime;
    }

    public String getLeaveTime() {
        return LeaveTime;
    }
    public void setLeaveTime(String leaveTime) {
        LeaveTime=leaveTime;
    }

    public String getConnectStudentID() {
       return ConnectStudentID;
    }
    public void setConnectStudentID(String connectStudentID) {
        ConnectStudentID=connectStudentID;
    }
    public String getConnectStudentName() {
        return ConnectStudentName;
    }
    public void setConnectStudentName(String connectStudentName) {
       ConnectStudentName=connectStudentName;
    }

    public String getConnectBuildingID() {
       return ConnectBuildingID;
    }
    public void setConnectBuildingID(String connectBuildingID) {
       ConnectBuildingID=connectBuildingID;
    }


}

