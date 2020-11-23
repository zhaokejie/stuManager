package Service.Model;

public class hygieneCheckRecord {

    private String BuildingID;//工号
    // private String DormManager_Username;
    private String DormitoryID;//寝室楼号
    private String CheckDate;
    private String Score;
    private String Problem;
    private String Recorder;  //记录员



    public String getBuilding_ID_ID() {
        return BuildingID;
    }

    public void setBuilding_ID(String building_id) { BuildingID= building_id;
    }

    public String getDormitoryID() {
        return DormitoryID;
    }

    public void setDormitoryID(String dormitory_id) { DormitoryID =dormitory_id;
    }

    public String getCheckDate() {
        return CheckDate;
    }

    public void setCheckDate(String checkDate) { CheckDate = checkDate;
    }

    public String getScore() {
        return Score;
    }

    public void setScore(String score) {Score=score;
    }
    public String getProblem() {
        return Problem;
    }

    public void setProblem(String problem) { Problem= problem;
    }
    public String getRecorder() {
        return Recorder;
    }

    public void setRecorder(String recorder) { Recorder = recorder;
    }
}
